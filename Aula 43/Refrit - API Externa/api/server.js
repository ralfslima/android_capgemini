const express = require("express");

const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.json());

// Vetor de alunos
const alunos = [];

// Cálculo da média
function calcularMedia(n1, n2) {
    return ((n1 + n2) / 2).toFixed(1);
}

// Situação do aluno
function situacao(media) {
    if (media >= 7) {
        return "Aprovado";
    } else if (media >= 5) {
        return "Recuperação";
    } else {
        return "Reprovado";
    }
}

// Listar alunos
app.get("/alunos", (req, res) => {

    const lista = alunos.map(aluno => {

        const media = Number(calcularMedia(aluno.nota1, aluno.nota2));

        return {
            codigo: aluno.codigo,
            nome: aluno.nome,
            nota1: aluno.nota1,
            nota2: aluno.nota2,
            media,
            situacao: situacao(media)
        };
    });

    res.json(lista);
});

// Buscar aluno pelo código
app.get("/alunos/:codigo", (req, res) => {

    const aluno = alunos.find(a => a.codigo == req.params.codigo);

    if (!aluno) {
        return res.status(404).json({
            mensagem: "Aluno não encontrado."
        });
    }

    const media = Number(calcularMedia(aluno.nota1, aluno.nota2));

    res.json({
        ...aluno,
        media,
        situacao: situacao(media)
    });
});

// Cadastrar aluno
app.post("/alunos", (req, res) => {

    const { codigo, nome, nota1, nota2 } = req.body;

    if (!codigo || !nome || nota1 === undefined || nota2 === undefined) {
        return res.status(400).json({
            mensagem: "Todos os campos são obrigatórios."
        });
    }

    const existe = alunos.find(a => a.codigo == codigo);

    if (existe) {
        return res.status(400).json({
            mensagem: "Código já cadastrado."
        });
    }

    alunos.push({
        codigo,
        nome,
        nota1: Number(nota1),
        nota2: Number(nota2)
    });

    res.status(201).json({
        mensagem: "Aluno cadastrado com sucesso."
    });
});

// Atualizar aluno
app.put("/alunos/:codigo", (req, res) => {

    const aluno = alunos.find(a => a.codigo == req.params.codigo);

    if (!aluno) {
        return res.status(404).json({
            mensagem: "Aluno não encontrado."
        });
    }

    const { nome, nota1, nota2 } = req.body;

    if (nome !== undefined) aluno.nome = nome;
    if (nota1 !== undefined) aluno.nota1 = Number(nota1);
    if (nota2 !== undefined) aluno.nota2 = Number(nota2);

    res.json({
        mensagem: "Aluno atualizado com sucesso."
    });
});

// Excluir aluno
app.delete("/alunos/:codigo", (req, res) => {

    const indice = alunos.findIndex(a => a.codigo == req.params.codigo);

    if (indice === -1) {
        return res.status(404).json({
            mensagem: "Aluno não encontrado."
        });
    }

    alunos.splice(indice, 1);

    res.json({
        mensagem: "Aluno removido com sucesso."
    });
});

app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});