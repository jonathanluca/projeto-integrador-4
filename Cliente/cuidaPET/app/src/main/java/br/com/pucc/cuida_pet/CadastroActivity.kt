package br.com.pucc.cuida_pet

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.pucc.cuida_pet.data.DonoPet
import br.com.pucc.cuida_pet.databinding.ActivityCadastroBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
            val dataNascimentoStr = binding.etDataNascimento.text.toString()

            try {
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val dataNascimento = LocalDate.parse(dataNascimentoStr, formatter)
                val senha = binding.etSenha.text.toString()

                val donoPet = DonoPet(nome, email, telefone, dataNascimento, senha)

                // Adicione o Logcat para exibir as informações do objeto
                Log.d("CadastroActivity", "DonoPet criado: $donoPet")

                showToast("Cadastro realizado com sucesso!")
                finish()

            } catch (e: IllegalArgumentException) {
                showToast(e.message ?: "Erro no cadastro.")
            }
        }
    }

    // Método showToast para exibir mensagens Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
