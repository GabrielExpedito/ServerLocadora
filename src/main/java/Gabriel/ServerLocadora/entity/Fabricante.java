package Gabriel.ServerLocadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
*   A anotação @Table(name = "fabricante") indica que a entidade será mapeada para a tabela fabricante no banco de dados
*   A anotação @Entity(name = "Fabricante") indica que a classe é uma entidade que o mesmo nome
*   A anotação @EqualsAndHashCode(of = "id") serve para gerar os métodos equals e hashCode para a classe.
*   A anotação @Data faz com que os métodos Getters, Setters, toString, Equals, hashcode sejam criados automaticamente.
*   A anotação @AllArgsConstructor faz com que os métodos construtores com todos os atributos seja criado automaticamente.
*   A anotação @NoArgsConstructos faz com que os méotodos construtores sem nenhum atributo seja criado automaticamente.
* */
@Table(name = "fabricante")
@Entity(name = "Fabricante")
@EqualsAndHashCode(of = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    private String nome;

}
