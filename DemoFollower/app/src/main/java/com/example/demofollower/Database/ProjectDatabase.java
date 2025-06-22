package com.example.demofollower.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.demofollower.Entity.*;
import com.example.demofollower.DAOs.*;


@Database(entities={Address.class,
User.class,
Category.class,
Order.class,
OrderItem.class,
Product.class,
Review.class,
Wishlist.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ProjectDatabase extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract UserDAO userDAO();
    public abstract AddressDAO addressDAO();
    public abstract OrderDAO orderDAO();
    public abstract ReviewDAO reviewDAO();
    public abstract OrderItemDAO orderItemDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract WishlistDAO wishlistDAO();
}
