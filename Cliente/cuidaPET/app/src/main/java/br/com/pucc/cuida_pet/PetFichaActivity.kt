package br.com.pucc.cuida_pet

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pucc.cuida_pet.data.Pet
import br.com.pucc.cuida_pet.ui.theme.CuidapetTheme

class PetFichaActivity : ComponentActivity() {
    private var pet: Pet = Pet(
        "",
        "",
        "",
        "",
        0,
        "",
        0.0f,
        null,
        0,
        null
    )
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtenha o objeto Pet da Intent
        if (intent.getParcelableExtra("pet", Pet::class.java) != null) {
            // Coloca no objeto pet pra editar
            pet = intent.getParcelableExtra("pet", Pet::class.java)!!
        }
        setContent {
            CuidapetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PetForm(pet)
                }
            }
        }
    }
}

fun onSubmit(pet: Pet) {
    // Se for editar, coloca o novo no lugar

    // Se for criar, adiciona na array aqui e no back

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetForm(pet: Pet) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (pet.nome == "") {
            Text(
                text = "Insira as informações de seu pet",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        } else {
            Text(
                text = "Edite as informações de seu pet",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        }

        pet.nome?.let {
            TextField(
                value = it,
                onValueChange = { pet.nome = it },
                label = { Text("Nome") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        pet.linkFoto?.let {
            TextField(
                value = it,
                onValueChange = { pet.linkFoto = it },
                label = { Text("Link da Foto") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        pet.especie?.let {
            TextField(
                value = it,
                onValueChange = { pet.especie = it },
                label = { Text("Espécie") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        pet.raca?.let {
            TextField(
                value = it,
                onValueChange = { pet.raca = it },
                label = { Text("Raça") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        TextField(
            value = pet.idade.toString(),
            onValueChange = { pet.idade = it.toInt() },
            label = { Text("Idade") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        pet.cor?.let {
            TextField(
                value = it,
                onValueChange = { pet.cor = it },
                label = { Text("Cor") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        TextField(
            value = pet.peso.toString(),
            onValueChange = { pet.peso = it.toFloat() },
            label = { Text("Peso (kg)") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(
            onClick = { onSubmit(pet) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Salvar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CuidapetTheme {
        Row {

        }
    }
}