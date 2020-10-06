package com.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1 // changes in db, this should be updated
)
abstract class ShoppingDatabase: RoomDatabase(){
    abstract fun getShoppingDao(): ShoppingDao

    //singleton
    companion object {
        @Volatile // this instance will be made visible to other threads. One thread at a time
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()
        //executed when created an instance
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it } // whatevs the result from the createDatabase will be set to the instance created above
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()

        }

    }