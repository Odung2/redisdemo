package com.example.redisdemo.Service

import com.example.redisdemo.domian.Order
import com.example.redisdemo.exception.OrderNotFoundException
import com.example.redisdemo.exception.OrderStatusException
import com.example.redisdemo.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
class OrderServiceImpl : OrderService {

    @Autowired
    private lateinit var orderRepository:OrderRepository

    override fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }

    @Cacheable(value = ["Order"], key = "#orderId", cacheManager = "testCacheManager")
    override fun getOrder(orderId: Int): Order {
        return orderRepository.findById(orderId).orElseThrow { OrderNotFoundException("Order Not Found") }
    }

    @CachePut(value = ["Order"], key = "#orderId", cacheManager = "testCacheManager")
    override fun updateOrder(order: Order, orderId: Int): Order {
        /*
        order status 변화주기
        status: ready -> processing -> shipped -> delivered
         */

        val orderObject: Order = orderRepository.findById(orderId).orElseThrow { OrderNotFoundException("Order Not Found") }
        if (orderObject.orderStatus ==  "ready") {
            orderObject.orderStatus = ("processing")
        } else if (orderObject.orderStatus ==  ("processing")) {
            orderObject.orderStatus = ("shipped")
        } else if (orderObject.orderStatus ==  ("shipped")) {
            orderObject.orderStatus = ("delivered")
        } else {
            throw OrderStatusException("Order Status Cannot Change")
        }
        return orderRepository.save(orderObject)
    }

    @CacheEvict(value = ["Order"], key = "#orderId", cacheManager = "testCacheManager")
    override fun deleteOrder(orderId: Int) {
        val orderObject: Order = orderRepository.findById(orderId).orElseThrow { OrderNotFoundException("Order Not Found") }
        orderRepository.delete(orderObject)
    }

    @get:Cacheable(value = ["Order"], cacheManager = "testCacheManager")
    override val allOrders: List<Any>
        get() = orderRepository.findAll()
}