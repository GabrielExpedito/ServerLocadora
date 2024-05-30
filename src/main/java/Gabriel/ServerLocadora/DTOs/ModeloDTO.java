package Gabriel.ServerLocadora.DTOs;

import Gabriel.ServerLocadora.entity.Fabricante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.naming.factory.FactoryBase;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {
    private Integer id;
    private String nome;
    private Fabricante fabricante;
}
