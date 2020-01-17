package com.vchornenkyi.appsaudit.test

import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing

@Suppress("NOTHING_TO_INLINE")
inline fun <T> whenever(methodCall: T): OngoingStubbing<T> {
    return Mockito.`when`(methodCall)!!
}