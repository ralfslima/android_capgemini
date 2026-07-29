package br.com.treinamento.moduloconsumoapi2.data.repository

import br.com.treinamento.moduloconsumoapi2.data.model.Pessoa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class PessoaRepository {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("pessoas")

    // READ - busca todas as pessoas cadastradas
    suspend fun getPessoas(): List<Pessoa> {
        val snapshot = collection.get().await()
        return snapshot.toObjects(Pessoa::class.java)
    }

    // CREATE - adiciona uma nova pessoa (o Firestore gera o id automaticamente)
    suspend fun addPessoa(pessoa: Pessoa) {
        collection.add(pessoa).await()
    }

    // UPDATE - sobrescreve o documento existente usando o id da pessoa
    suspend fun updatePessoa(pessoa: Pessoa) {
        collection.document(pessoa.id).set(pessoa).await()
    }

    // DELETE - remove o documento pelo id
    suspend fun deletePessoa(id: String) {
        collection.document(id).delete().await()
    }
}
