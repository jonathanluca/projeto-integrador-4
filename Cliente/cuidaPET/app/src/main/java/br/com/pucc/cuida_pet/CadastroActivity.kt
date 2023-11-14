package br.com.pucc.cuida_pet

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val chkVeterinario = findViewById<CheckBox>(R.id.chkVeterinario)
        val etIdClinica = findViewById<EditText>(R.id.etIdClinica)

        chkVeterinario.setOnCheckedChangeListener { _, isChecked ->
            // Exibir/ocultar o campo ID da clínica com base no estado do CheckBox
            etIdClinica.visibility = if (isChecked) android.view.View.VISIBLE else android.view.View.GONE
        }

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            // Adicione aqui a lógica para realizar o cadastro
            // Pode verificar os campos, chamar um serviço de cadastro, etc.
        }
    }
}