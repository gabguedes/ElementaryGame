package br.com.gabrielguedesvillelacrispim.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jogador(
    val nomeJogador : String,
    val sexoJogador: String,
    val paisJogador: String
) : Parcelable
