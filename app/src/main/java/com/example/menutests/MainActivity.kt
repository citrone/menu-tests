package com.example.menutests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set action bar
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_categories -> {
            createPopupMenu(item)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun createPopupMenu(item: MenuItem) {
        PopupMenu(this, this.findViewById(R.id.action_categories)).apply {
            setOnMenuItemClickListener {
                Toast.makeText(context, "You clicked on: ${it.title}", Toast.LENGTH_SHORT).show()
                true
            }
            menu.add("Option 1")
            menu.add("Option 2")
            show()
        }
    }
}

