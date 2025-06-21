package com.example.demofollower.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "categories", foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "parent_id", onDelete = ForeignKey.SET_NULL), indices = {
        @Index("parent_id") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "parent_id")
    private Integer parentId; // Nullable for root categories

    // Constructor without id (for creating new categories)
    public Category(String name, String description, Integer parentId) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
    }
}