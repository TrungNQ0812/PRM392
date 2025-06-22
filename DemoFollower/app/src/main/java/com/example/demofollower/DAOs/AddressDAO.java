package com.example.demofollower.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.demofollower.Entity.Address;

import java.util.List;

@Dao
public interface AddressDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Address address);

    @Query("Delete from addresses")
    void deleteAll();

    @Query("Select * from addresses")
    List<Address> getAddresses();
}
