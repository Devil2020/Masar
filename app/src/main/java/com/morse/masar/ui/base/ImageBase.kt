package com.morse.masar.ui.base

import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun getRequestOptions (rad : Int) : RequestOptions =   RequestOptions()?.transforms(CenterInside(), RoundedCorners(rad))