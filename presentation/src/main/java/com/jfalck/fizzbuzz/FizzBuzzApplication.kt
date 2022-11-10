package com.jfalck.fizzbuzz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
* The app declaration is necessary for Hilt to work.
* */

@HiltAndroidApp
class FizzBuzzApplication : Application()