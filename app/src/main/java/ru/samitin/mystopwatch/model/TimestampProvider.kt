package ru.samitin.mystopwatch.model

interface TimestampProvider {
    fun getMilliseconds(): Long
}