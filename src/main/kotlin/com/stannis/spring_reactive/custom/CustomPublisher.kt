package com.stannis.spring_reactive.custom

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

class CustomPublisher<T>(list: List<T>): Publisher<T> {

    private val list: List<T>

    init {
        this.list = list
    }

    override fun subscribe(subscriber: Subscriber<in T>) {
        val subscription = CustomSubscription(this.list, subscriber)
        subscriber.onSubscribe(subscription)
    }

}