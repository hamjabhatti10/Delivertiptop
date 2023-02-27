package com.hamza.delivertiptop.DataManager

import com.hamza.delivertiptop.googleMapHelper.DirectionObject
import com.hamza.delivertiptop.source.remote.retrofit.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object RemoteDataManager : DataManagerImp {


    // Remote calls
    override fun getDirectionRoutes(url: String): Observable<DirectionObject> {
        return ApiService.getDirectionResponse().getDirectionRoutes(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    /**
     * This is example code for success dummy response now you don't need to pass data directly from doOnSubscribe.
     * After that all apis are called same as this. */
//    override fun sendOTP(email: String): Observable<Response<ResponseMain>> {
//        return Observable.create { observer ->
//            // observer.onError(Throwable("This is dummy thorwable if you want to test failed case."))
//            observer.onNext(null)
//            observer.onComplete()
//        }
//    }

}