package id.anantyan.chapter2challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.anantyan.chapter2challenge.databinding.ActivityMainBinding
import id.anantyan.chapter2challenge.ui.gojek.GojekActivity
import id.anantyan.chapter2challenge.ui.tokped.TokpedActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGojek.setOnClickListener {
            val intent = Intent(this, GojekActivity::class.java)
            startActivity(intent)
        }

        binding.btnTokped.setOnClickListener {
            val intent = Intent(this, TokpedActivity::class.java)
            startActivity(intent)
        }

    }
}