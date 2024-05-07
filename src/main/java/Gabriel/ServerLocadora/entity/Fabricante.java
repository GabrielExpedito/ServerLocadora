package Gabriel.ServerLocadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
