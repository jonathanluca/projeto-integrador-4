package br.com.pucc.cuida_pet

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.pucc.cuida_pet.data.Pet
import br.com.pucc.cuida_pet.ui.theme.CuidapetTheme
import kotlin.jvm.Throws

class PetFichaActivity : ComponentActivity() {
    private var pet: Pet? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtenha o objeto Pet da Intent
         pet = intent.getParcelableExtra("pet", Pet::class.java) // O que pegar e que classe que isso é

        if (pet == null) { //Se não veio o pet, da erro e fecha o app
            Toast.makeText(this, "ERRO INESPERADO", Toast.LENGTH_LONG).show()
        }

        setContent {
            CuidapetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CuidapetTheme {
        Greeting("Android")
    }
}