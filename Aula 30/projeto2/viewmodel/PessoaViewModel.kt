package br.com.treinamento.moduloarquiteturadesoftware.projeto2.viewmodel

import androidx.lifecycle.ViewModel
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository.PessoaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PessoaViewModel @Inject constructor(
    private val pessoaRepository: PessoaRepository
): ViewModel() {

}