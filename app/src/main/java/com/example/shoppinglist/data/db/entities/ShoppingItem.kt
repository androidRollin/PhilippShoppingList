package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//to hold a data
//entity - table of data

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
){
    @PrimaryKey(autoGenerate = true) // Room will do this for use
    var id: Int? = null
}
//Dao - data access object