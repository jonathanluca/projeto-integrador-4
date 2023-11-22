package br.com.pucc.cuida_pet

import java.io.IOException
import java.net.Socket


class MySocketClient {
    private val DEFAULT_HOST = "localhost"
    private var clientSocket: Socket? = null
    @Throws(IOException::class)
    fun run() {
        clientSocket = Socket(DEFAULT_HOST, 4001)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val client = MySocketClient()
                client.run()
            } catch (e: IOException) {
//            throw new RuntimeException(e);
                println("Error starting client : " + e.message)
            }
        }
    }
}
