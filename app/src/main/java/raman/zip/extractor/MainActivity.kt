package raman.zip.extractor

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.hzy.libp7zip.P7ZipApi
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest
import java.io.File


class MainActivity : AppCompatActivity(), View.OnClickListener, EasyPermissions.PermissionCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EasyPermissions.requestPermissions(
            PermissionRequest.Builder(
                this,
                502,
                "android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE"
            )
                .build()
        )

        buttonExtract.setOnClickListener(this)
        buttonChoose.setOnClickListener(this)
        buttonCompress.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.buttonChoose -> {
                choose()
            }

            R.id.buttonExtract -> {
                extract()
            }

            R.id.buttonCompress -> {
                compress()
            }
        }
    }


    private fun extract() {

        val externalStorage = Environment.getExternalStorageDirectory()
        val file = File(externalStorage.absolutePath, "KKK.zip")
        val currentMilliseconds = System.currentTimeMillis()
        Log.d("TIMEHERE", "$externalStorage : $file")
        Log.d("TIMEHERE", "${currentMilliseconds}")

        Command.showResult(
            P7ZipApi.executeCommand(
                Command.getExtractCmd(
                    file.toString(),
                    externalStorage.absolutePath
                )
            )
        )

        Log.d("TIMEHERE", "${Command.getExtractCmd(file.toString(), externalStorage.absolutePath)}")
        Log.d("TIMEHERE", "${(System.currentTimeMillis() - currentMilliseconds)}")
    }

    private fun choose() {

    }

    private fun compress() {

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }
}
