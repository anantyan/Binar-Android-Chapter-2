package id.anantyan.chapter2.topik4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.anantyan.chapter2.R
import id.anantyan.chapter2.databinding.ActivityTopik4Binding

class Topik4Activity : AppCompatActivity() {

    private lateinit var _binding: ActivityTopik4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTopik4Binding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}