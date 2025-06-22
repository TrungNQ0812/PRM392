package com.example.demofollower.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.demofollower.Entity.Review;

import java.util.List;

@Dao
public interface ReviewDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertReview(Review review);

    @Query("Delete from reviews")
    void deleteReviews();

    @Query("Select * from reviews")
    List<Review> getReviews();
}
