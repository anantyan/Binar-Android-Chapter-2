package id.anantyan.chapter2challenge.ui.tokped

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import id.anantyan.chapter2challenge.R
import id.anantyan.chapter2challenge.databinding.ActivityTokpedBinding

class TokpedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTokpedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokpedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barangLayout1.progressBar2.isEnabled = false
        binding.barangLayout2.progressBar2.isEnabled = false
        binding.barangLayout3.progressBar2.isEnabled = false
        binding.barangLayout4.progressBar2.isEnabled = false

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                val headerHeight = binding.header.height
                if (scrollY > headerHeight) {
                    binding.include.clToolbar.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    val window = this.window
                    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    binding.include.svSearch.background =
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.search_bar_bordered,
                            theme
                        )
                    binding.include.imageView.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView12.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView13.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView14.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                } else {
                    binding.include.clToolbar.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.tokped_primary
                        )
                    )
                    val window = this.window
                    window.statusBarColor = ContextCompat.getColor(this, R.color.tokped_primary)
                    binding.include.clToolbar.elevation = 2f
                    binding.include.svSearch.background =
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.search_bar_bordered,
                            theme
                        )
                    binding.include.imageView.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView12.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView13.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    binding.include.imageView14.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                    )
                }
            }
        }
    }
}