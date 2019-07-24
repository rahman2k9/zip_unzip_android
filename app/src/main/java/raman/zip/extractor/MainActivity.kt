package raman.zip.extractor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.SystemClock
import android.util.Log
import com.hzy.libp7zip.P7ZipApi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val externalStorage = Environment.getExternalStorageDirectory()
        val file = File(externalStorage.absolutePath, "KKK.zip")


        extrat.setOnClickListener {
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
            Log.d("TIMEHERE", "${(System.currentTimeMillis()-currentMilliseconds)}")
        }


    }
}
