package com.hamza.delivertiptop.application

import android.app.Application
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.multidex.MultiDex
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class DeliverTipTopApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)


        mContext = this


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        // app moved to foreground
        isInBackground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        // app moved to background
        isInBackground = true
    }

    companion object {

        private lateinit var mContext: Context
        private lateinit var mGso: GoogleSignInOptions
        private lateinit var mAuth: FirebaseAuth
        private lateinit var firestoreDB: FirebaseFirestore
        private var isInBackground = false

        fun getContext(): Context {
            return mContext
        }

        fun getWasInBackground(): Boolean {
            return isInBackground
        }

        fun getGso(): GoogleSignInOptions {
            return mGso
        }

        fun getFirebaseAuthen(): FirebaseAuth {
            return mAuth
        }

        fun getFirebaseFirestore(): FirebaseFirestore {
            return firestoreDB
        }

    }
}