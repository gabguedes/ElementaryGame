package br.com.gabrielguedesvillelacrispim

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.gabrielguedesvillelacrispim.databinding.ActivityTelaJogoBinding
import br.com.gabrielguedesvillelacrispim.model.Jogador

class TelaJogo : AppCompatActivity() {

    private lateinit var binding : ActivityTelaJogoBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jogador = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            intent.getParcelableExtra("jogador", Jogador::class.java)
        } else {
            intent.getParcelableExtra("jogador")
        }

        binding.tvNomeJogador.text = jogador?.nomeJogador
        binding.tvSexoJogador.text = jogador?.sexoJogador
        binding.tvPaisJogador.text = jogador?.paisJogador
    }
}