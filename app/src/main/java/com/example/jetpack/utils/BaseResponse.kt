package com.example.jetpack.utils

import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseResponse {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): DataResponse<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    DataResponse.Success(data = response.body()!!)
                } else {
                    val errorResponse: Error? = convertErrorBody(response.errorBody())
                    DataResponse.Error(errorMessage = (errorResponse?.message ?: "Something went wrong").toString())
                }

            } catch (e: HttpException) {
                DataResponse.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                DataResponse.Error("Please check your network connection")
            } catch (e: Exception) {
                DataResponse.Error(errorMessage = "Something went wrong")
            }
        }
    }

    private fun convertErrorBody(errorBody: ResponseBody?): Error? {
        return try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(Error::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}