const url = 'http://localhost:8080/produtos';

function salvar(){
    const produto = {
        nome: document.getElementById("nome").value,
        categoria: document.getElementById("categoria").value,
        descricao: document.getElementById("descricao").value,
        preco: parseFloat(document.getElementById("preco").value)
    };


    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(produto)}).then(() => listar());
}

function listar(){
    fetch(url)
        .then(res => res.json())
        .then(dados => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";

            dados.forEach(produto => {
                const li = document.createElement("li");
                li.innerText = `${produto.nome} - ${produto.categoria} - ${produto.descricao} - ${produto.preco}`;
                lista.appendChild(li);
            });
        });
}

listar();
