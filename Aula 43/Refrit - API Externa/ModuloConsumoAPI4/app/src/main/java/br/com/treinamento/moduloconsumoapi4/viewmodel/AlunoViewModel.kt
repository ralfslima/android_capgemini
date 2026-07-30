package br.com.treinamento.moduloconsumoapi4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AtualizarAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.NovoAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.repository.AlunoRepository
import br.com.treinamento.moduloconsumoapi4.model.Aluno
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel
class AlunoViewModel : ViewModel() {


    private val repository =
        AlunoRepository()


    private val _uiState =
        MutableStateFlow(
            AlunoUiState()
        )


    val uiState: StateFlow<AlunoUiState> =
        _uiState



    init {

        listarAlunos()

    }



    fun alterarCodigo(valor:String){

        _uiState.value =
            _uiState.value.copy(
                codigo = valor
            )

    }



    fun alterarNome(valor:String){

        _uiState.value =
            _uiState.value.copy(
                nome = valor
            )

    }



    fun alterarNota1(valor:String){

        _uiState.value =
            _uiState.value.copy(
                nota1 = valor
            )

    }



    fun alterarNota2(valor:String){

        _uiState.value =
            _uiState.value.copy(
                nota2 = valor
            )

    }



    fun listarAlunos(){


        viewModelScope.launch {


            try {


                _uiState.value =
                    _uiState.value.copy(
                        carregando = true
                    )


                val lista =
                    repository.listarAlunos()



                _uiState.value =
                    _uiState.value.copy(

                        alunos = lista,

                        carregando = false

                    )


            } catch(e:Exception){


                _uiState.value =
                    _uiState.value.copy(

                        carregando = false,

                        erro = e.message

                    )

            }


        }

    }



    fun salvar(){


        val estado =
            _uiState.value



        viewModelScope.launch {


            try {


                if(estado.modoEdicao){


                    repository.atualizarAluno(

                        estado.codigoEdicao!!,


                        AtualizarAlunoDTO(

                            estado.nome,

                            estado.nota1.toDouble(),

                            estado.nota2.toDouble()

                        )

                    )


                } else {


                    repository.cadastrarAluno(

                        NovoAlunoDTO(

                            estado.codigo.toInt(),

                            estado.nome,

                            estado.nota1.toDouble(),

                            estado.nota2.toDouble()

                        )

                    )

                }



                limparFormulario()


                listarAlunos()



            }catch(e:Exception){


                _uiState.value =
                    _uiState.value.copy(
                        erro = e.message
                    )

            }


        }


    }




    fun editarAluno(aluno:Aluno){


        _uiState.value =
            _uiState.value.copy(

                codigo =
                    aluno.codigo.toString(),

                nome =
                    aluno.nome,


                nota1 =
                    aluno.nota1.toString(),


                nota2 =
                    aluno.nota2.toString(),


                modoEdicao = true,


                codigoEdicao =
                    aluno.codigo

            )


    }




    fun cancelarEdicao(){

        limparFormulario()

    }




    fun excluirAluno(codigo:Int){


        viewModelScope.launch {


            try {


                repository.excluirAluno(codigo)


                listarAlunos()


            }catch(e:Exception){


                _uiState.value =
                    _uiState.value.copy(
                        erro = e.message
                    )

            }


        }


    }




    private fun limparFormulario(){


        _uiState.value =
            _uiState.value.copy(

                codigo = "",

                nome = "",

                nota1 = "",

                nota2 = "",

                modoEdicao = false,

                codigoEdicao = null

            )

    }


}