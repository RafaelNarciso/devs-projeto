package br.com.estudos.rafa.livraria.library.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor",schema = "public")
@Getter
@Setter
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column(name ="nome",length =100,nullable = false )//ientificar a tabela e realizar um bom mapeamento
    private String nome;

    @Column(name = "data_nascimento",nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade",length = 50,nullable = false)
    private String nacionalidade;


    @OneToMany(mappedBy = "autor") // Um autor pode ter muitos livros e estou mapeando pelo atributo "autor" na classe Livro
    private List <Livro> livros; // Relacionamento com a entidade Livro e uma lista de livros relacionados a esse autor

}
