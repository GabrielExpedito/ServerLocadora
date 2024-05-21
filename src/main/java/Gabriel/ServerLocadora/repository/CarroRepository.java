package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Carro;
import Gabriel.ServerLocadora.filter.CarroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@Repository
public class CarroRepository {

    @Autowired
    JdbcClient jdbcClient;


    public List<Carro> obterTodosCarros() {
        List<Carro> carros = jdbcClient
                .sql("SELECT * FROM carro")
                .query(Carro.class)
                .list();

        RowMapper<Carro> mapperCarro = (rs, rowNum) -> {
            Carro carro = new Carro();
            carro.setId(rs.getInt("id"));
            carro.setIdmodelo(rs.getInt("idmodelo"));
            carro.setIdfabricante(rs.getInt("idfabricante"));
            carro.setAno(rs.getInt("ano"));
            carro.setCor(rs.getString("cor"));
            carro.setPlaca(rs.getString("placa"));
            carro.setDisponivel(rs.getBoolean("disponivel"));
            carro.setValorlocacao(rs.getDouble("valorlocacao"));

            return carro;
        };

        public List<Carro> buscarTodosCarros(CarroFilter filtro) {


        }


    }

}
