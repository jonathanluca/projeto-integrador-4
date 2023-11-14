package br.com.pucc.cuida_pet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            // Criar um Intent para iniciar a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)

            // Iniciar a nova atividade
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {
            // Criar um Intent para iniciar a LoginActivity
            val intent = Intent(this, CadastroActivity::class.java)

            // Iniciar a nova atividade
            startActivity(intent)
        }
    }
}
