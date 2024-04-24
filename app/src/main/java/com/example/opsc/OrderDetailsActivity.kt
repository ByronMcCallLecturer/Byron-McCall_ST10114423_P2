package com.example.opsc

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opsc.databinding.ActivityOrderDetailsBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database
import java.util.Calendar

class OrderDetailsActivity : AppCompatActivity() {

    var order = Order()
    val database = Firebase.database

    val starSucksRef = database.getReference("orders")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()

        // set the product name on the text view
        binding.tvPlacedOrder.text = order.productName

        // changing image based on what the customer picked
        when (order.productName) {
            "Soy Latte" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb1)
            "Chocco Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb2)
            "Bottled Americano" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb3)
            "Rainbow Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb4)
            "Caramel Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb5)
            "Black Forest Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb6)
        }

        binding.fabOrder.setOnClickListener() {
            shareIntent(this, order.productName)
        }

        binding.fabCalendar.setOnClickListener()
        {
            val datePickerCalendar = Calendar.getInstance()
            val year = datePickerCalendar.get(Calendar.YEAR)
            val month = datePickerCalendar.get(Calendar.MONTH)
            val day = datePickerCalendar.get(Calendar.DAY_OF_MONTH)

            val listener = object : DatePickerDialog.OnDateSetListener
            {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    order.orderDate = "${year}-${month+1}-${day}"
                }
            }
            var ordersDatePicker = DatePickerDialog(this@OrderDetailsActivity, listener, year, month, day)

            ordersDatePicker.show()

        }


        binding.fabCloud.setOnClickListener()
        {
            order.customerName = binding.etCustomerName.text.toString()
            order.customerCell = binding.etCustomerCell.text.toString()

            if(!order.customerName.isNullOrBlank() && !order.customerCell.isNullOrBlank()
                && !order.orderDate.isNullOrBlank() && !order.productName.isNullOrBlank())
            {
                starSucksRef.push().setValue(order)
            }
            else
            {
                Toast.makeText(this@OrderDetailsActivity, "Please complete all fields", Toast.LENGTH_SHORT).show()
            }

        }

    }
}