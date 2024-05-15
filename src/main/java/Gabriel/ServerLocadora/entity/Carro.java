package Gabriel.ServerLocadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*  A anotação @Data faz com que os métodos Getters, Setters, toString, Equals, hashcode sejam criados automaticamente.
*   A anotação @AllArgsConstructor faz com que os métodos construtores com todos os atributos seja criado automaticamente.
*   A anotação @NoArgsConstructos faz com que os méotodos construtores sem nenhum atributo seja criado automaticamente.
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    private Integer idfabricante;

    private Integer idmodelo;

    private String placa;

    private String cor;

    private boolean disponivel;

    private Integer ano;

    private Double valorlocacao;

}
