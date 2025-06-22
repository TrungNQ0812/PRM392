package com.example.demofollower.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.demofollower.Entity.OrderItem;

import java.util.List;

@Dao
public interface OrderItemDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOrderItem(OrderItem orderItem);

    @Query("Delete from order_items ")
    void deleteOrderItem();

    @Query("Select * from order_items")
    List<OrderItem> getOrderItems();
}
