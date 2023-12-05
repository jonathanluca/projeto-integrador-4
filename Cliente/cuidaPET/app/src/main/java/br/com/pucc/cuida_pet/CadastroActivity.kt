// CadastroActivity.kt

package br.com.pucc.cuida_pet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.view.View



class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnCreateAccount: Button = findViewById(R.id.btnCadastrar)
        val chkVeterinario: CheckBox = findViewById(R.id.chkVeterinario)
        val etIdClinica: EditText = findViewById(R.id.etIdClinica)

        chkVeterinario.setOnCheckedChangeListener { _, isChecked ->
            etIdClinica.visibility = if (isChecked) {
                // Se o usuário for veterinário, tornar o campo ID da clínica visível
                View.VISIBLE
            } else {
                // Se o usuário não for veterinário, ocultar o campo ID da clínica
                View.GONE
            }
        }

        btnCreateAccount.setOnClickListener {
            val username = findViewById<EditText>(R.id.etNome).text.toString()
            val email = findViewById<EditText>(R.id.etEmailCadastro).text.toString()
            val phone = findViewById<EditText>(R.id.etTelefone).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            val userManager = UserManager(this)
            userManager.registerUser(username, email, phone, password)

            if (chkVeterinario.isChecked) {
                // Se o usuário for veterinário, você pode acessar o ID da clínica
                val idClinica = etIdClinica.text.toString()
                // Faça o que for necessário com o ID da clínica
            }

            val resultIntent = Intent()
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
