package id.anantyan.chapter2_minichallenge2

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog
import id.anantyan.chapter2_minichallenge2.adapter.Component2Adapter
import id.anantyan.chapter2_minichallenge2.adapter.Component4Adapter
import id.anantyan.chapter2_minichallenge2.databinding.ActivityMainBinding
import id.anantyan.chapter2_minichallenge2.model.DataComponent2
import id.anantyan.chapter2_minichallenge2.model.DataDummy.dataComponent

object PermissionUI {
    const val PERMISSION_LOCATION = 1001
    fun requestLocation(activity: Activity) {
        EasyPermissions.requestPermissions(
            activity,
            "Beberapa fitur tidak akan jalan tanpa adanya izin lokasi!",
            PERMISSION_LOCATION,
            perms = arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }
    fun hasPermissionLocation(context: Context): Boolean {
        return EasyPermissions.hasPermissions(context, perms = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ))
    }
}

class MainActivity : AppCompatActivity(),
    Component2Adapter.Component2Callback,
    EasyPermissions.PermissionCallbacks {
    
    private lateinit var adapter1: Component2Adapter
    private lateinit var adapter2: Component4Adapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter1 = Component2Adapter(this)
        adapter1.differ.submitList(dataComponent().resultsComponent2)

        adapter2 = Component4Adapter()
        adapter2.differ.submitList(dataComponent().resultsComponent4)

        binding.rvComponent2.adapter = adapter1
        binding.rvComponent2.setHasFixedSize(true)
        binding.rvComponent2.itemAnimator = DefaultItemAnimator()
        binding.rvComponent2.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvComponent2.isNestedScrollingEnabled = false

        binding.rvComponent4.adapter = adapter2
        binding.rvComponent4.setHasFixedSize(true)
        binding.rvComponent4.itemAnimator = DefaultItemAnimator()
        binding.rvComponent4.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvComponent4.isNestedScrollingEnabled = false
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            SettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        when (requestCode) {
            PermissionUI.PERMISSION_LOCATION -> { }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onClick(item: DataComponent2, position: Int) {
        PermissionUI.requestLocation(this)
        if (PermissionUI.hasPermissionLocation(this)) {
            Toast.makeText(
                this,
                "${item.title}, position : ${position}!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}