package org.example.lojaonline.controller;

import jakarta.validation.Valid;
import org.example.lojaonline.model.Key;
import org.example.lojaonline.model.Pedido;
import org.example.lojaonline.model.Produto;
import org.example.lojaonline.repository.KeyRepository;
import org.example.lojaonline.repository.PedidoRepository;
import org.example.lojaonline.repository.ProdutoRepository;
import org.example.lojaonline.service.LojaOnline;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final LojaOnline lojaOnline;
    private final KeyRepository keyRepository;
    private final PedidoRepository pedidoRepository;

    public ProdutoController(LojaOnline lojaOnline, KeyRepository keyRepository, PedidoRepository pedidoRepository) {
        this.lojaOnline = lojaOnline;
        this.keyRepository = keyRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return lojaOnline.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorid(@PathVariable Long id){
        return lojaOnline.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        lojaOnline.deletarProduto(id);
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return lojaOnline.casdastrar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto){
        return lojaOnline.atualizar(id, produto);
    }

    @PostMapping("/keys")
    public Key cadastrarKey(@RequestBody Key key){
        return lojaOnline.salvar(key);
    }

    @PostMapping("/comprar/{produtoId}")
    public Key comprar(@PathVariable Long produtoId) {
        return lojaOnline.comprar(produtoId);
    }

    @GetMapping("/keys")
    public List<Key> listarKeys(){
        return lojaOnline.listar();
    }

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos(){
        return lojaOnline.listarPedidos();
    }

    @GetMapping("/pedidos/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return lojaOnline.buscarPorIdPD(id);
    }
}

