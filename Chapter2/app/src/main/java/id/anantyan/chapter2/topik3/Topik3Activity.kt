package id.anantyan.chapter2.topik3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.anantyan.chapter2.databinding.ActivityTopik3Binding

class Topik3Activity : AppCompatActivity() {

    private lateinit var _binding: ActivityTopik3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTopik3Binding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}

class ComponentClass {
    private var variable: String? = null

    companion object {
        private const val INI_KONSTANTA: String = "Hello World!"
    }

    init {
        variable = "Hello World!"
    }

    private constructor(arg: String) {
        this.variable = arg
    }

    private fun showText(): String? {
        return this.variable
    }
}