package org.example.lojaonline.repository;

import org.example.lojaonline.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.lojaonline.model.Key;
import java.util.Optional;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Optional<Key> findFirstByProdutoIdAndStatus(Long produtoId, String status);
}
