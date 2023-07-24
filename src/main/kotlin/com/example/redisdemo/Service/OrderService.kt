package com.example.redisdemo.Service

import com.example.redisdemo.domian.Order


interface OrderService {
    fun createOrder(order: Order): Order
    fun getOrder(orderId: Int): Order
    fun updateOrder(order: Order, orderId: Int): Order
    fun deleteOrder(orderId: Int)
    val allOrders: List<Any>
}