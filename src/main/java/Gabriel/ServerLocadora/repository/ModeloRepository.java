package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModeloRepository {


    @Autowired
    JdbcClient jdbcClient;

    public List<Modelo> obterTodosModelos() {
        List<Modelo> modelos = jdbcClient
                .sql("SELECT * FROM modelo")
                .query(Modelo.class)
                .list();

        RowMapper<Modelo> mapperModelo = (rs, rowNum) -> {
            Modelo modelo = new Modelo();
            modelo.setNome(modelo.getNome());
            modelo.setId(modelo.getId());

            return modelo;
        };

        List<Modelo> modelos1 = jdbcClient
                .sql("SELECT * FROM modelo")
                .query(mapperModelo)
                .list();

        return modelos;
    }


}
