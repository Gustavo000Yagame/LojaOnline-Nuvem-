package org.example.lojaonline.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Getter
@Setter

@Table(name = "TBPRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto não pode ficar vazio")
    private String nome;


    @NotBlank(message = "A categoria precisa ser valida!, não pode ficar vazia")
    private String categoria;


    @NotBlank(message = "A descrição precisa ser valida!, não pode ficar vazia")
    private String descricao;

    @Positive(message = "O preço precisa ser positivo")
    private Long preco;
}
