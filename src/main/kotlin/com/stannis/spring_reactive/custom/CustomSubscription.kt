package com.stannis.spring_reactive.custom

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class CustomSubscription<T>(list: List<T>, subscriber: Subscriber<in T>): Subscription {

    private var lastRequestedElement = -1

    private val list: List<T>

    private val subscriber: Subscriber<in T>

    init {
        this.list = list
        this.subscriber = subscriber
    }

    override fun request(p0: Long) {
        lastRequestedElement++
        if (lastRequestedElement < list.size) {
            subscriber.onNext(list[p0.toInt()])
        } else {
            subscriber.onComplete()
        }
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }
}