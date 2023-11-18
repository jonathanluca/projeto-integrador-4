package br.com.pucc.cuida_pet

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.pucc.cuida_pet.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener {
            val nome = binding.etNome.text.toString()
            val email = binding.etEmailCadastro.text.toString()
            val telefone = binding.etTelefone.text.toString()
            val senha = binding.etSenha.text.toString()

            val userManager = UserManager(this)

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
