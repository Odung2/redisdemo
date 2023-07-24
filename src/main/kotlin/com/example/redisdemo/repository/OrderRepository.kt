package com.example.redisdemo.repository

import com.example.redisdemo.domian.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

internal open interface OrderRepository : JpaRepository<Order, Int> {

}