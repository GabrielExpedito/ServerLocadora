package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.DTOs.ModeloDTO;
import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ModeloRepository {


    @Autowired
    JdbcClient jdbcClient;

    RowMapper<ModeloDTO> mapperModelo = (rs, rowNum) -> {
        ModeloDTO modelo = new ModeloDTO();
        modelo.setNome(rs.getString("Nome"));
        modelo.setId(rs.getInt("Id"));

        Fabricante fabricante = new Fabricante();
        fabricante.setId(rs.getInt("id"));
        fabricante.setNome(rs.getString("nome"));

        modelo.setFabricante(fabricante);

        return modelo;
    };

    public List<ModeloDTO> obterTodosModelos() {
        List<ModeloDTO> modelos = jdbcClient
                .sql("SELECT * FROM modelo")
                .query(mapperModelo)
                .list();
        return modelos;
    }

    public Optional<ModeloDTO> obterModelosById(Integer Id) {
        return jdbcClient
                .sql("SELECT * FROM modelo WHERE id = :id")
                .param("id", Id)
                .query(mapperModelo)
                .optional();
    }
    public Integer deletarModelo(Integer id) {
        String querySql = "DELETE FROM public.modelo WHERE id = :id";
        return jdbcClient.sql(querySql)
                .param("id", id)
                .update();
    }
    public Integer inserirModelo(Modelo modelo) {
        String querySql = "INSERT INTO public.modelo (id, nome, idfabricante) VALUES (:id, :nome, :idfabricante);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql(querySql)
                .param("id", modelo.getId())
                .param("nome", modelo.getNome())
                .param("idfabricante", modelo.getIdfabricante())
                .update(keyHolder, "id");

        return keyHolder.getKeyAs(Integer.class);
    }

    public Integer atualizarModelo(Modelo modelo) {
        String querySql = "UPDATE public.modelo SET nome= :nome, idfabricante= :idfabricante WHERE id = :id;";

        return jdbcClient.sql(querySql)
                .param("nome", modelo.getNome())
                .param("idfabricante", modelo.getIdfabricante())
                .param("id", modelo.getId())
                .update();
    }
}




