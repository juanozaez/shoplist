package com.home.shoplist.shared

import com.github.rholder.retry.RetryerBuilder
import com.github.rholder.retry.StopStrategies
import com.github.rholder.retry.WaitStrategies
import java.util.concurrent.TimeUnit

object AwaitAssertion {
    fun awaitAssertionOk(millis: Long = 250, lambda: () -> Unit) {
        RetryerBuilder.newBuilder<Unit>()
                .retryIfException()
                .withWaitStrategy(WaitStrategies.fixedWait(millis, TimeUnit.MILLISECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(50))
                .build()
                .call {
                    try {
                        lambda()
                    } catch (e: AssertionError) {
                        throw RuntimeException(e)
                    }
                }
    }
}