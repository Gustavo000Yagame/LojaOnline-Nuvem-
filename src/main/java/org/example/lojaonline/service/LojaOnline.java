package org.example.lojaonline.service;

import org.example.lojaonline.model.Key;
import org.example.lojaonline.model.Pedido;
import org.example.lojaonline.model.Produto;
import org.example.lojaonline.repository.KeyRepository;
import org.example.lojaonline.repository.PedidoRepository;
import org.example.lojaonline.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LojaOnline {

    private final ProdutoRepository produtoRepository;
    private final KeyRepository keyRepository;
    private final PedidoRepository pedidoRepository;

    public LojaOnline(ProdutoRepository produtoRepository, KeyRepository keyRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;

        this.keyRepository = keyRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("Produto não encontrado"));
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto casdastrar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto){
        buscarPorId(id);
        produto.setId(id);
        return produtoRepository.save(produto);
    }


    public List<Key> listar(){
        return keyRepository.findAll();
    }

    public Key salvar(Key key){
        return keyRepository.save(key);
    }


    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorIdPD(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }


    public Key comprar(Long produtoId) {
        Key key = keyRepository.findFirstByProdutoIdAndStatus(produtoId, "DISPONIVEL")
                .orElseThrow(() -> new RuntimeException("Sem estoquee!"));

        key.setStatus("VENDIDO");
        keyRepository.save(key);

        Pedido pedido = new Pedido();
        pedido.setValorTotal(key.getProduto().getPreco());
        pedidoRepository.save(pedido);

        return key;
    }
}
