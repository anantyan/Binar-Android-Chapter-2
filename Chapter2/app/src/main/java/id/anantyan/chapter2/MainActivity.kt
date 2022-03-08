package id.anantyan.chapter2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.anantyan.chapter2.databinding.ActivityMainBinding
import id.anantyan.chapter2.topik2.Topik2Activity
import id.anantyan.chapter2.topik3.Topik3Activity

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        binding()
    }

    private fun binding() {
        _binding.btnToTopik2.setOnClickListener {
            val intent = Intent(this, Topik2Activity::class.java)
            startActivity(intent)
        }
        _binding.btnToTopik3.setOnClickListener {
            val intent = Intent(this, Topik3Activity::class.java)
            startActivity(intent)
        }
    }
}