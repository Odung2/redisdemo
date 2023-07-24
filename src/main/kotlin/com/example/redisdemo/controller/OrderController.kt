package com.example.redisdemo.controller

import com.example.redisdemo.Service.OrderService
import com.example.redisdemo.domian.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(allowedHeaders = ["*"])

@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order {
        return orderService.createOrder(order)
    }

    @get:GetMapping
    val order: ResponseEntity<List<Any>>
        get() = ResponseEntity.ok(orderService.allOrders)

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Int): Order {
        return orderService.getOrder(id)
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Int, @RequestBody order: Order): Order {
        return orderService.updateOrder(order, id)
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Int): String {
        orderService!!.deleteOrder(id)
        return "Order with id: $id deleted."
    }
}