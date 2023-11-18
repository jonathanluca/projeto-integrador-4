package br.com.pucc.cuida_pet

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.etNome).text.toString()
            val email = findViewById<EditText>(R.id.etEmailCadastro).text.toString()
            val telefone = findViewById<EditText>(R.id.etTelefone).text.toString()
            val senha = findViewById<EditText>(R.id.etSenha).text.toString()

            val userManager = UserManager(this)


            // Se o usuário não estiver logado, faça o cadastro
            val isVeterinario = findViewById<CheckBox>(R.id.chkVeterinario).isChecked
            val idClinica = if (isVeterinario) findViewById<EditText>(R.id.etIdClinica).text.toString() else ""

            // Crie lógica para lidar com o cadastro e outras ações necessárias
            userManager.registerUser(nome, email, telefone, senha)
            showToast("Cadastro realizado com sucesso!")
            finish()  // Fecha a atividade de cadastro após o sucesso

        }
    }

    // Método showToast para exibir mensagens Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
