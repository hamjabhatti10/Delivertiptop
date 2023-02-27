package com.hamza.delivertiptop.DataManager

import com.hamza.delivertiptop.googleMapHelper.DirectionObject
import io.reactivex.Observable

interface DataManagerImp {
    //Remote calls
    fun getDirectionRoutes(url: String): Observable<DirectionObject>


    //  fun sendOTP(email: String): Observable<Response<ResponseMain>>

}