package org.example.lojaonline.service;

import org.example.lojaonline.model.Produto;
import org.example.lojaonline.repository.KeyRepository;
import org.example.lojaonline.repository.PedidoRepository;
import org.example.lojaonline.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaOnline {

    private final ProdutoRepository produtoRepository;

    public LojaOnline(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
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
}
