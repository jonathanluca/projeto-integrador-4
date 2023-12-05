// MainActivity.kt
package br.com.pucc.cuida_pet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (userManager.loginUser(email, password)) {
                startUserActivity()
            } else {
                showToast("Login failed. Check your credentials.")
            }
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent) // Use startActivity se não precisar de um resultado
            // startActivityForResult(intent, SIGNUP_REQUEST_CODE) // Use isso se precisar de um resultado
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun startUserActivity() {
        val intent = Intent(this, PetListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
