package id.anantyan.chapter2challenge.ui.gojek

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.anantyan.chapter2challenge.R
import id.anantyan.chapter2challenge.databinding.ActivityGojekBinding
import id.anantyan.chapter2challenge.adapter.gojek.BannerAdapter
import id.anantyan.chapter2challenge.adapter.gojek.GridAdapter

class GojekActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGojekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGojekBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val adapter = BannerAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvBanner.layoutManager = layoutManager
        binding.rvBanner.adapter = adapter

        val listTitle = resources.getStringArray(R.array.grid_title_list)
        val listIcon = intArrayOf(
            R.drawable.ic_goride,
            R.drawable.ic_gocar,
            R.drawable.ic_gofood,
            R.drawable.ic_gosend,
            R.drawable.ic_gomart,
            R.drawable.ic_go_pulsa,
            R.drawable.ic_checkin,
            R.drawable.ic_lainnya
        )
        val gridAdapter = GridAdapter(this, listTitle, listIcon)
        binding.gvMenu.adapter = gridAdapter

        binding.bottomNavBar.getOrCreateBadge(R.id.promo).isVisible = true
        binding.bottomNavBar.getOrCreateBadge(R.id.chat).isVisible = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gojek_toolbar_menu, menu)
        return true
    }
}