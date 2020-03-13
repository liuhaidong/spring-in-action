package com.arkdex.springinaction.threadpool.atomicreference;
/*

The AtomicReference class provides reference objects that may be read and written atomically, so when multiple threads
try to reach them at the same time, only one will be able to do so.

        In the example below, we have created two threads that try to update the values of a String object, message and
        a custom class object, Person. They also update two AtomicReference objects, one created for the message, and
        the other one created for the person object.

        The AtomicReference class provides a few methods in order to update the referenced object. Below, we make use of
        them:

        The compareAndSet(V expect, V update) API method atomically sets the value to the given updated value, only if
            the current value is equal to the expected value.
        The getAndSet(V newValue) API method atomically sets to the given value and returns the old value.
        The lazySet(V newValue) API method eventually sets to the given value.
        The set(V newValue) API method sets to the given value.
        The get() API method gets the current value.
*/
