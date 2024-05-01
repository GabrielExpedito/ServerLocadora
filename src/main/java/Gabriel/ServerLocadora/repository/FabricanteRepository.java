package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Fabricante;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Integer> {

    @Override
    List<Fabricante> findAll();

    @Query("DELETE from fabricante WHERE id = :id")
    void deletarPorId(@Param("x") Integer id);

    }

