package br.com.gabrielguedesvillelacrispim

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.gabrielguedesvillelacrispim.databinding.ActivityMainBinding
import br.com.gabrielguedesvillelacrispim.model.Jogador

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun iniciarJogo(view: View){
        val nomeJogador = binding.etNomeJogador.text
        val idSexoJogador = binding.rgSexoJogador.checkedRadioButtonId
        val paisJogador = binding.spPaises.selectedItem as String
        val termosDeUso = binding.cbTermosDeUso.isChecked
        var sexoSelecionado = ""

        when (idSexoJogador){
            R.id.rbMasculino -> {
                sexoSelecionado = binding.rbMasculino.text.toString()
            }

            R.id.rbFeminino -> {
                sexoSelecionado = binding.rbFeminino.text.toString()
            }
        }

        if (nomeJogador.isNotBlank() && nomeJogador.isNotEmpty() && termosDeUso){
            val intent = Intent(this, TelaJogo::class.java)
            val jogador = Jogador(
                nomeJogador.toString(),
                sexoSelecionado,
                paisJogador
            )
            intent.putExtra("jogador", jogador)
            startActivity(intent)
        }else {
            Toast.makeText(this, "Preencha todos os campos",
                Toast.LENGTH_SHORT).show()
        }

    }
}