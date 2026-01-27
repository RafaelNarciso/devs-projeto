package br.com.estudos.rafa.livraria.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro", schema = "public")
@Data // Gera getters, setters, toString, equals e hashCode
public class Livro {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private String isbn;

    private String titulo;

    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    private GeneroLivro genero;

    private BigDecimal preco;

    @ManyToOne// Muitos livros podem ser escritos por um autor
    @JoinColumn(name = "autor_id", nullable = false) // Chave estrangeira para a tabela Autor
    private  Autor autor; // Relacionamento com a entidade Autor

}
