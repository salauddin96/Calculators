package com.raihan.practicalpart3
import android.app.Person
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.setupWithNavController
import com.raihan.practicalpart3.R
import com.raihan.practicalpart3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawyerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottomnav.setupWithNavController(navController)
        binding.navview.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerlayout,R.string.nav_open,R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bmiFragment ->{
                    binding.navview.setupWithNavController(navController)
                    binding.drawerlayout.closeDrawers()
                }

                R.id.tempFragment ->{
                    binding.navview.setupWithNavController(navController)
                    binding.drawerlayout.closeDrawers()
                }
                R.id.share ->{
                    Toast.makeText(this,"You clicked share",Toast.LENGTH_SHORT).show()
                }
                R.id.Setting ->{
                    Toast.makeText(this,"You clicked Setting",Toast.LENGTH_SHORT).show()
                }

                R.id.about ->{
                    Toast.makeText(this,"You clicked About",Toast.LENGTH_SHORT).show()
                }


            }
            true
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else super.onOptionsItemSelected(item)
    }

}
