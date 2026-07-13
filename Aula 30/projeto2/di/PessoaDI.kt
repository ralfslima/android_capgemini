package br.com.treinamento.moduloarquiteturadesoftware.projeto2.di

import br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository.PessoaRepository
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository.PessoaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PessoaDI {

    @Binds
    abstract fun bindPessoa(impl: PessoaRepositoryImpl) : PessoaRepository

}

