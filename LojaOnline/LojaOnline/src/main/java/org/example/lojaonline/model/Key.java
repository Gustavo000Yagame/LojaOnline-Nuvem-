package org.example.lojaonline.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A Key precisa ser valida!! (Não pode ficar vazia)")
    private String codigo;

    @NotBlank(message = "o status não pode ficar vazio precisa ser valido!!!!!")
    private String status;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
