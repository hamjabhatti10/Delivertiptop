package com.hamza.delivertiptop.constant


object Constants {

    const val BASE_URL = "https://staging.base.com/api/v1/"


    val DIRECTION_API = "https://maps.googleapis.com/maps/api/directions/json?origin="


    const val LOCATION_UPDATE_TIME = 0 //in miliSeconds like miliSeconds X seconds X mint X hours
    const val LOCATION_UPDATE_DISTANCE = 20 //in meter

    const val PREF_NAME = "_Data_Store_Pref_"

    const val STRIPE_KEY = "abc"
    const val SPLASHDELAY = 1000 * 3 * 1 // in milliSeconds
    const val KEY_REQUEST_PLACE: Int = 1000
    const val GOOGLE_REQUEST_CODE: Int = 1001
    const val EARTHRADIUS = 6366198.0

    const val DEFAULT_DATE_FORMATE = "dd MMMM,yyyy"

    const val FCM_ANDROID_TOPIC = "Android_Users"

    const val CPP_LIBRARY_NAME = "keys"

    const val IMAGE_PICKER_REQUEST_CODE = 1234

    const val CAMERA_PICKER_REQUEST_CODE = 12345

    const val VIDEO_GALLERY_PICKER_REQUEST_CODE = 2234

    const val VIDEO_CAMERA_PICKER_REQUEST_CODE = 22345
}
