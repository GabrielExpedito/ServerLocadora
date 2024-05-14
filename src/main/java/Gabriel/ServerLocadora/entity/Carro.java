package Gabriel.ServerLocadora.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    private Integer id;

    private Integer idfabricante;

    private Integer idmodelo;

    private String placa;

    private String cor;

    private boolean disponivel;

    private Integer ano;

    private Double valorlocacao;

}
