package br.com.pucc.cuida_pet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PetCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_cadastro)

        val btnCadastrarPet: Button = findViewById(R.id.btnCadastrarPet)

        btnCadastrarPet.setOnClickListener {
            val nomePet = findViewById<EditText>(R.id.etNomePet).text.toString()
            val especiePet = findViewById<EditText>(R.id.etEspeciePet).text.toString()
            val racaPet = findViewById<EditText>(R.id.etRacaPet).text.toString()
            val dataNascimentoPet = findViewById<EditText>(R.id.etDataNascimentoPet).text.toString()
            val corPrimariaPet = findViewById<EditText>(R.id.etCorPrimariaPet).text.toString()
            val idVeterinario = findViewById<EditText>(R.id.etIdVeterinario).text.toString()

            // Adicione aqui a lógica para cadastrar o pet
            // Pode usar um gerenciador de pets ou armazenar localmente, conforme sua implementação
            // Por enquanto, apenas exibiremos os dados no Toast
            showToast("Pet cadastrado com sucesso!")
            finish()  // Fecha a atividade de cadastro de pet após o sucesso
        }
    }

    // Método showToast para exibir mensagens Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}