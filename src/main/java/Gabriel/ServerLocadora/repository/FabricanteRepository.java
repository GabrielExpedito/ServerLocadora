package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Fabricante;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

    }

