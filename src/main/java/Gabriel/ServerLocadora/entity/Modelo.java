package Gabriel.ServerLocadora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* A anotação @Table(name = Modelo) indica que a entidade será mapeada para a tabela modelo no banco de dados.
*  A anotação @Entity(name = Modelo) indica que a classe é uma entidade.
*  A anotação @Data faz com que os métodos Getters, Setters, toString, Equals, hashcode sejam criados automaticamente.
*  A anotação @AllArgsConstructor faz com que os métodos construtores com todos os atributos seja criado automaticamente.
*  A anotação @NoArgsConstructos faz com que os méotodos construtores sem nenhum atributo seja criado automaticamente.
* */
@Table(name = "modelo")
@Entity(name = "Modelo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @jakarta.persistence.Id
    @Column(name = "Id", unique = true)
    private Integer Id;
    private String nome;
    private Integer idfabricante;

}
