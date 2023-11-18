package br.com.pucc.cuida_pet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager = UserManager(this)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivityForResult(intent, SIGNUP_REQUEST_CODE)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun startUserActivity() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val SIGNUP_REQUEST_CODE = 1
    }
}
