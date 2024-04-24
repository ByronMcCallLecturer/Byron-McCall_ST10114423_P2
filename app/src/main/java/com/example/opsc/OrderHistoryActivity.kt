package com.example.opsc

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opsc.databinding.ActivityOrderHistoryBinding
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class OrderHistoryActivity : AppCompatActivity() {

    val database = Firebase.database
    val starSucksRef = database.getReference("orders")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOrderHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        starSucksRef.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = mutableListOf<Order>()

                for(PulledOrder in snapshot.children)
                {
                    val order : Order? = PulledOrder.getValue(Order::class.java)
                    if(order != null)
                    {
                        list.add(order)
                    }
                }

                var orderAdapter = ArrayAdapter(this@OrderHistoryActivity,
                    android.R.layout.simple_list_item_1, list)
                binding.lstvOrderHistory.adapter = orderAdapter

            }


            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@OrderHistoryActivity,
                    "Error reading from database", Toast.LENGTH_SHORT).show()
            }


        })

    }
}