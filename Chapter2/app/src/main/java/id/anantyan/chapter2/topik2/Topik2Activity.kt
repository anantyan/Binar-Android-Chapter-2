package id.anantyan.chapter2.topik2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.anantyan.chapter2.databinding.ActivityTopik2Binding

class Topik2Activity : AppCompatActivity() {

    private var _listener: ((String?) -> Unit)? = null
    private lateinit var _binding: ActivityTopik2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTopik2Binding.inflate(layoutInflater)
        setContentView(_binding.root)
        view {
            _binding.txtView.text = it
        }
        showText()
    }

    private fun showText() {
        _listener?.let {
            it("Hello World!")
        }
    }

    private fun view(listener: (String?) -> Unit) {
        _listener = listener
    }
}