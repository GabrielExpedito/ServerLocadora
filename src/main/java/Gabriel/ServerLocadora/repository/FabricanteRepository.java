package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.DTOs.FabricanteDTO;
import Gabriel.ServerLocadora.entity.Fabricante;
import org.apache.naming.factory.FactoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FabricanteRepository {

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<Fabricante> mapperFabricante = (rs, rowNum) -> {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(rs.getInt("id"));
        fabricante.setNome(rs.getString("nome"));
        return fabricante;
    };


    public List<Fabricante> obterTodosFabricantes() {
        return jdbcClient
                .sql("SELECT * FROM fabricante")
                .query(mapperFabricante)
                .list();
    }

    public Optional<Fabricante> obterFabricanteById(Integer id) {
        return jdbcClient
                .sql("SELECT * FROM fabricante f WHERE id = :id")
                .param("id", id)
                .query(mapperFabricante)
                .optional();

    }
     public Integer criarFabricante(Fabricante fabricante) {
        String querySql = "INSERT INTO public.fabricante (nome) VALUES(:nome);";

         KeyHolder keyHolder = new GeneratedKeyHolder();

         jdbcClient.sql(querySql)
                 .param("nome", fabricante.getNome())
                 .update(keyHolder, "id");

         return keyHolder.getKeyAs(Integer.class);
     }

     public Integer deletarFabricante(Integer id) {
        String querySql = "DELETE FROM public.fabricante WHERE id= :id;";

        return jdbcClient.sql(querySql)
                .param("id", id)
                .update();
     }
}


