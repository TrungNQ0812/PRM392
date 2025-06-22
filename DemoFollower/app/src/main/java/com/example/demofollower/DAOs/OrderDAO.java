package com.example.demofollower.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.demofollower.Entity.Order;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOrder(Order order);

    @Query("Delete from orders")
    void deleteAll();

    @Query("Select * from orders")
    List<Order> getOrders();
}
