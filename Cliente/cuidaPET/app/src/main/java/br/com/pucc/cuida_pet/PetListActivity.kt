package br.com.pucc.cuida_pet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.pucc.cuida_pet.data.Pet
import br.com.pucc.cuida_pet.ui.theme.CuidapetTheme
import coil.compose.AsyncImage
val cliente1: List<Pet>? = null

val petTeste= Pet(
    "Cliente1",
    "link1",
    "Especie1",
    "Raca1",
    3,
    "Cor1",
    500.0f, // Exemplo de peso em mg
    null,
    1,
    101,
    null
)
class PetListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val novaListaCliente1 = cliente1.orEmpty().toMutableList() // Converte para MutableList
        novaListaCliente1.add(petTeste)
        setContent {
            CuidapetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PetsList(novaListaCliente1)
                }
            }
        }
    }
}
@Composable
fun PetsList(petList: List<Pet>?) {
    if (petList == null) return
    val novaListaCliente1 = cliente1.orEmpty().toMutableList() // Converte para MutableList
    novaListaCliente1.add(petTeste)
    for (pet in petList) {
        PetItem(pet)
    }
}

@Composable
fun PetItem(pet: Pet) {
    Row(modifier = Modifier.padding(all = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = "https://cdn-prod.medicalnewstoday.com/content/images/articles/322/322868/golden-retriever-puppy.jpg",
            contentDescription = null,
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = pet.nome)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val novaListaCliente1 = cliente1.orEmpty().toMutableList() // Converte para MutableList
    novaListaCliente1.add(petTeste)
    CuidapetTheme {
        PetsList(novaListaCliente1)
    }
}