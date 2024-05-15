package Gabriel.ServerLocadora.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private Integer idfabricante;

    private Integer idmodelo;

    private String placa;

    private String cor;

    private boolean disponivel;

    private Integer ano;

    private Double valorlocacao;
}
