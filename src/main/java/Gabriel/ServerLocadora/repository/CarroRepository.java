package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Carro;
import Gabriel.ServerLocadora.filter.CarroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
import java.util.*;

@Repository
public class CarroRepository {

    @Autowired
    JdbcClient jdbcClient;

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
            StringJoiner where = new StringJoiner(" AND");

            Map<String, Object> params = new HashMap<>();

            if(filtro.getIdModelo() != null) {
                where.add("idmodelo = :idModelo");
                params.put("idModelo", filtro.getIdModelo());
        }
            if (filtro.getPlaca() != null) {
                where.add("placa = :placa");
                params.put("placa", filtro.getPlaca());
            }

            if (filtro.getAno() != null) {
                where.add("ano = :ano");
                params.put("ano", filtro.getAno());
            }

            if (filtro.getCor() != null) {
                where.add("cor = :cor");
                params.put("cor", filtro.getCor());
            }

            if (filtro.getDisponivel() != null) {
                where.add("disponivel = :disponivel");
                params.put("disponivel", filtro.getDisponivel());
            }

            if (!params.isEmpty()) {
                String sql = "SELECT * FROM carro WHERE" + where;

                return jdbcClient
                        .sql(sql)
                        .param(params)
                        .query(mapperCarro).list();
            }else {
                return jdbcClient
                        .sql("SELECT * FROM carro")
                        .query(mapperCarro)
                        .list();
            }

    }

    public Integer criarCarro(Carro carro) {
        String querySql = "INSERT INTO public.carro (idfabricante, idmodelo, placa, cor, disponivel, ano, valorlocacao) " +
                "VALUES (:idfabricante, :idmodelo, :placa, :cor, :disponivel, :ano, :valorlocacao);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql(querySql)
                .param("idfabricante", carro.getIdfabricante())
                .param("idmodelo", carro.getIdmodelo())
                .param("placa", carro.getPlaca())
                .param("cor", carro.getCor())
                .param("disponivel", carro.isDisponivel())
                .param("ano", carro.getAno())
                .param("valorlocacao", carro.getValorlocacao())
                .update(keyHolder, "id");

        return keyHolder.getKeyAs(Integer.class);
    }

    public Integer atualizarCarro(Carro carro) {
            String querySql = """
                    UPDATE public.carro 
                    SET idfabricante= :idfabricante, cor=:cor, idmodelo=:idmodelo, ano= :ano, placa=:placa, disponivel=:disp
                    WHERE id = :id
                    """;

            return jdbcClient.sql(querySql)
                    .param("id", carro.getId())
                    .param("idfabricante", carro.getIdfabricante())
                    .param("idmodelo", carro.getIdmodelo())
                    .param("placa", carro.getPlaca())
                    .param("cor", carro.getCor())
                    .param("disp", carro.isDisponivel())
                    .param("ano", carro.getAno())
                    .update();
    }

    public Integer deletarCarro(Integer id) {
            String querySql = "DELETE FROM public.carro WHERE id= :id;";

            return jdbcClient.sql(querySql)
                    .param("id", id)
                    .update();
    }

}
