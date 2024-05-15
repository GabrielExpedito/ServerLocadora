package Gabriel.ServerLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Gabriel.ServerLocadora.entity.Carro;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
