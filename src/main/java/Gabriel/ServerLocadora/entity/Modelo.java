package Gabriel.ServerLocadora.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "modelo")
@Entity(name = "Modelo")
@EqualsAndHashCode(of = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @jakarta.persistence.Id
    private Integer Id;
    private String nome;
    private Integer idfabricante;

}
