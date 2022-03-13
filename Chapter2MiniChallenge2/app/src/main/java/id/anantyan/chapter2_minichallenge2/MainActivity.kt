package id.anantyan.chapter2_minichallenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.anantyan.chapter2_minichallenge2.DataDummy.dataComponent
import id.anantyan.chapter2_minichallenge2.adapter.Component2Adapter
import id.anantyan.chapter2_minichallenge2.adapter.Component4Adapter
import id.anantyan.chapter2_minichallenge2.databinding.ActivityMainBinding
import id.anantyan.chapter2_minichallenge2.model.DataComponent2
import id.anantyan.chapter2_minichallenge2.model.DataComponent4
import id.anantyan.chapter2_minichallenge2.model.ListItem

class MainActivity : AppCompatActivity() {

    private lateinit var adapter1: Component2Adapter
    private lateinit var adapter2: Component4Adapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter1 = Component2Adapter()
        adapter2 = Component4Adapter()

        binding.rvComponent2.adapter = adapter1
        binding.rvComponent2.setHasFixedSize(true)
        binding.rvComponent2.itemAnimator = DefaultItemAnimator()
        binding.rvComponent2.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvComponent2.isNestedScrollingEnabled = false
        adapter1.differ.submitList(dataComponent().resultsComponent2)

        binding.rvComponent4.adapter = adapter2
        binding.rvComponent4.setHasFixedSize(true)
        binding.rvComponent4.itemAnimator = DefaultItemAnimator()
        binding.rvComponent4.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvComponent4.isNestedScrollingEnabled = false
        adapter2.differ.submitList(dataComponent().resultsComponent4)
    }
}

object DataDummy {
    fun dataComponent(): ListItem {
        return ListItem(
            resultsComponent2 = mutableListOf(
                DataComponent2(
                    "",
                    "Pizza Unta",
                    "Grim Caffee & Eatery",
                    8.79f
                ),
                DataComponent2(
                    "",
                    "O'Donut",
                    "Mang Kobul",
                    7.80f
                ),
                DataComponent2(
                    "",
                    "Salad You",
                    "Restaurant Elite",
                    10.50f
                )
            ),
            resultsComponent4 = mutableListOf(
                DataComponent4(
                    "",
                    "Cassetto O'Donut",
                    "Open until 10.30PM",
                    4.9f,
                    "10K"
                ),
                DataComponent4(
                    "",
                    "McDonald",
                    "Jakart Selatan",
                    4.3f,
                    "9.2K"
                ),
            )
        )
    }
}