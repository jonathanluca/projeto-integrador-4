package br.com.pucc.cuida_pet;

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.pucc.cuida_pet.R



import android.app.Activity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLoginConfirm = findViewById<Button>(R.id.btnLoginConfirm)

        btnLoginConfirm.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Adicione aqui a lógica para verificar o login
            // Você pode implementar a autenticação, verificar os dados, etc.
        }
    }
}
