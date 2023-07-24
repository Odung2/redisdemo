package com.example.redisdemo.domian

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

//
//import lombok.AllArgsConstructor
//import lombok.Data
//import lombok.NoArgsConstructor
//import org.springframework.data.annotation.Id
//import javax.persistence.Entity
//import javax.persistence.GeneratedValue
//import javax.persistence.Table
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "ORDERS")
//data class Order (
//        var serialVersionUID:Long = 1L,
//
//        @Id
//        @GeneratedValue
//        var id:Int,
//
//        var orderCode:String,
//
//        var orderObject:String ,
//
//        var orderStatus:String ,
//
//        var orderPrice:Int ,
//)


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
class Order {
        @Id
        @GeneratedValue
         var id: Int? = null
         var orderCode: String? = null
         var orderObject: String? = null
         var orderStatus: String? = null
         var orderPrice: Int? = null

        companion object {
                private const val serialVersionUID = 1L
        }
}