package com.hamza.delivertiptop.source.remote.rxjava

import com.hamza.delivertiptop.models.MyDataClass
import com.hamza.delivertiptop.models.ResponseMain
import com.hamza.delivertiptop.models.ResponseModel
import com.hamza.delivertiptop.source.remote.retrofit.ApiService
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response


class ErrorUtils {
    companion object {
        fun parseError(response: Response<*>): ResponseMain {
            val converter: Converter<ResponseBody, ResponseMain> = ApiService.getRetrofitObject()
                .responseBodyConverter(ResponseMain::class.java, arrayOfNulls<Annotation>(0))
            val error: ResponseMain = try {
                converter.convert(response.errorBody()) ?: ResponseMain(
                    ResponseModel(
                        false,
                        "",
                        MyDataClass()
                    )
                )
            } catch (e: Exception) {
                return ResponseMain(ResponseModel(false, e.localizedMessage, MyDataClass()))
            }
            return error
        }
    }

}