package com.sunday.aadproject.main

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.sunday.aadproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar?.setOnMenuItemClickListener { menuItem->
            when (menuItem.itemId) {
                R.id.action_settings-> {
                    true
                }
                else -> false
            }
        }
    }
}