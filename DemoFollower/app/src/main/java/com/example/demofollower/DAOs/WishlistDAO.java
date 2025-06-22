package com.example.demofollower.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.demofollower.Entity.Wishlist;

import java.util.List;

@Dao
public interface WishlistDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWishlist(Wishlist wishlist);

    @Query("Delete from wishlist")
    void deleteAllWishlist();

    @Query("Select * from wishlist")
    List<Wishlist> getWishlists();
}
