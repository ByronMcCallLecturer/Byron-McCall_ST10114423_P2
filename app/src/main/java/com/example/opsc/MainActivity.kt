package com.example.opsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.opsc.databinding.ActivityMainBinding
import com.example.opsc.databinding.ActivityMainWithNavDrawerBinding
import com.google.android.material.navigation.NavigationView
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    var order = Order()
    private lateinit var binding: ActivityMainWithNavDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView4.setOnClickListener(this)
        binding.imageView5.setOnClickListener(this)
        binding.imageView6.setOnClickListener(this)
        binding.imageView7.setOnClickListener(this)
        binding.imageView8.setOnClickListener(this)
        binding.imageView9.setOnClickListener(this)

        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var toggleOnOff = ActionBarDrawerToggle(this, binding.drawerLayout,
            binding.navToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()


        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)



//        binding.imageView4.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Soy Latte",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imageView5.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Bottled Americano",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imageView6.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Rainbow Frapp",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imageView7.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Caramel Frapp",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imageView8.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Black Forest Frapp",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imageView9.setOnClickListener()
//        {
//            Toast.makeText(this@MainActivity, "MMM Soy Latte",
//                Toast.LENGTH_SHORT).show()
//        }



    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageView4 -> order.productName = "Soy Latte"
            R.id.imageView5 -> order.productName = "Chocco Frap"
            R.id.imageView6 -> order.productName = "Bottled Americano"
            R.id.imageView7 -> order.productName = "Rainbow Frapp"
            R.id.imageView8 -> order.productName = "Caramel Frapp"
            R.id.imageView9 -> order.productName = "Black Forest Frapp"
        }

        // Small pop up message to the user
        Toast.makeText(this@MainActivity, "MMM " + order.productName,
            Toast.LENGTH_SHORT).show()

        // Call the openIntent to start the OrderDetailsActivity class
        openIntent(this, order.productName, OrderDetailsActivity::class.java)
    }

//    override fun onBackPressed(){
//        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START))
//        {
//            binding.drawerLayout.closeDrawer(GravityCompat.START)
//        }else
//        {
//            super.onBackPressed()
//        }
//    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //  Navigate to the photo activity
        when (item.itemId) {
            R.id.nav_main -> openIntent(this, "", ActivityMainWithNavDrawerBinding::class.java)
            R.id.nav_photo -> openIntent(this, "", CoffeeSnapsActivity::class.java)
            R.id.nav_history -> openIntent(this, "", OrderHistoryActivity::class.java)

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }


}