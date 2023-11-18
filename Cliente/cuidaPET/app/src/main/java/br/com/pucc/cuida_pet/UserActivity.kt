package br.com.pucc.cuida_pet

// UserActivity.kt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userManager = UserManager(this)

        val tvUserName: TextView = findViewById(R.id.tvUserName)
        val tvUserEmail: TextView = findViewById(R.id.tvUserEmail)
        val tvUserPhone: TextView = findViewById(R.id.tvUserPhone)
        val tvPetCount: TextView = findViewById(R.id.tvPetCount)
        val btnViewPets: Button = findViewById(R.id.btnViewPets)

        tvUserName.text = "Nome: ${userManager.getUsername()}"
        tvUserEmail.text = "Email: ${userManager.getEmail()}"
        tvUserPhone.text = "Telefone: ${userManager.getPhone()}"
        tvPetCount.text = "Quantidade de pets cadastrados: 0"  // Inicialmente zero

        btnViewPets.setOnClickListener {
            // Implemente a lógica para ver os pets cadastrados
            showToast("Implemente a lógica para visualizar os pets cadastrados.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
