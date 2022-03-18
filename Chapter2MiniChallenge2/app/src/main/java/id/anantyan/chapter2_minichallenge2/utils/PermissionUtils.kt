package id.anantyan.chapter2_minichallenge2.utils

import android.app.Activity
import android.content.Context
import com.vmadalin.easypermissions.EasyPermissions

object PermissionUtils {

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