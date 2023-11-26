package br.com.pucc.cuida_pet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pucc.cuida_pet.data.Pet
import br.com.pucc.cuida_pet.ui.theme.CuidapetTheme
import coil.compose.AsyncImage
val cliente1: List<Pet>? = null

val petTeste= Pet(
    "Cliente1",
    "https://love.doghero.com.br/wp-content/uploads/2018/12/golden-retriever-1.png",
    "Especie1",
    "Raca1",
    3,
    "Cor1",
    0.5f, // Peso em kg
    null,
    1,
    null
)
val petTeste2 = Pet(
    "Melo",
    "https://www.florence.edu.br/wp-content/uploads/2022/08/Imagem-Materia_Dia-do-Cachorro.png",
    "Canine",
    "SRD - Caramelo",
    2,
    "Brown",
    8.7f,
    null,
    1,
    null)
class PetListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val novaListaCliente1 = cliente1.orEmpty().toMutableList() // Converte para MutableList
        novaListaCliente1.add(petTeste)
        novaListaCliente1.add(petTeste2)
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
    novaListaCliente1.add(petTeste2)
    LazyColumn {
        items(novaListaCliente1) {pet ->
            PetItem(pet)
        }
    }
}

@Composable
fun PetItem(pet: Pet) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .clickable {
                val intent = Intent(context, PetFichaActivity::class.java)
                intent.putExtra("pet", pet) // Lá na
                context.startActivity(intent)
            }
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = pet.linkFoto,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = pet.nome,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }
    Divider()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val novaListaCliente1 = cliente1.orEmpty().toMutableList() // Converte para MutableList
    novaListaCliente1.add(petTeste)
    novaListaCliente1.add(petTeste2)
    CuidapetTheme {
        PetsList(novaListaCliente1)
    }
}