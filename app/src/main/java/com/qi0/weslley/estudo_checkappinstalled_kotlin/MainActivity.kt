package com.qi0.weslley.estudo_checkappinstalled_kotlin

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            if (isPackageAvailable("com.qi0.weslley.estudo_radiolajefm")){
                Toast.makeText(this, "App instaled", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "App missing", Toast.LENGTH_SHORT).show();
            }
        }
    }

    fun isPackageAvailable(name: String): Boolean {
        var available = true

        try {
            packageManager.getPackageInfo(name, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            available = false
        }

        return available

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
