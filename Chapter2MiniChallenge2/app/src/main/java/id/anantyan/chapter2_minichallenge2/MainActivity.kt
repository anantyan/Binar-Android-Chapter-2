package id.anantyan.chapter2_minichallenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.anantyan.chapter2_minichallenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}