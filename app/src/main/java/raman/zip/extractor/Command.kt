package raman.zip.extractor

import android.R
import android.util.Log
import com.hzy.libp7zip.ExitCode


object Command {

    fun getExtractCmd(archivePath: String, outPath: String): String {
        return String.format("7z x '%s' '-o%s' -aoa", archivePath, outPath);
    }

    fun getCompressCmd(filePath: String, outPath: String, type: String): String {
        return String.format("7z a -t%s '%s' '%s'", type, outPath, filePath)
    }

    fun showResult(result: Int): String {

        val retMsgId = when (result) {
            ExitCode.EXIT_OK -> "done"
            ExitCode.EXIT_WARNING -> "Warning"
            ExitCode.EXIT_FATAL -> "fatal error"
            ExitCode.EXIT_CMD_ERROR -> "error"
            ExitCode.EXIT_MEMORY_ERROR -> "memory"
            ExitCode.EXIT_NOT_SUPPORT -> "support"
            else -> "done"
        }
        Log.d("TIMEHERE", retMsgId)
        return retMsgId
    }
}