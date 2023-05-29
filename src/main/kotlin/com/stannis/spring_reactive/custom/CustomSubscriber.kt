package com.stannis.spring_reactive.custom

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


class CustomSubscriber<T>: Subscriber<T> {

    private lateinit var subscription: Subscription

    override fun onSubscribe(subscription: Subscription) {
        this.subscription = subscription
        println("Subscribed!")
        subscription.request(1)

    }

    override fun onNext(item: T) {
        println("On next $item")
        subscription.request(1)
    }

    override fun onError(throwable: Throwable) {
        println(throwable.message)
    }

    override fun onComplete() {
        println("Completed!")
    }

}