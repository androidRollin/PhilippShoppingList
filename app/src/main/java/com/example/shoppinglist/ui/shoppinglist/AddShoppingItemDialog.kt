package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context,"Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            //that method, will notify the shopping activity and give the item we just created
            //this stuff will be saved in the activity where it was impelemented, which is in the shopping activity
            //passing only of the data in the dialog
            //in the activity in which it is in action
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}