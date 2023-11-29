// LoginActivity.kt
package br.com.pucc.cuida_pet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userManager = UserManager(this)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLoginConfirm = findViewById<Button>(R.id.btnLoginConfirm)

        btnLoginConfirm.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (tryLogin(email, password)) {
                startUserActivity()
            } else {
                showToast("Credenciais incorretas, tente novamente!")
            }
        }
    }
    private fun tryLogin(email: String, senha: String): Boolean{
       var mySocketClient: MySocketClient = MySocketClient();

         if(mySocketClient.login(email, senha)) {
             return true
         }
        return false
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
