package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Carro;
import Gabriel.ServerLocadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {


    @Autowired
    CarroRepository repository;

    public List<Carro> obterCarros() {
       return repository.findAll();
    }

    public Carro obterCarroById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Carro não encontrado"));

    }

    public void inserirCarros(Carro carro) {
        repository.save(carro);
    }

    public void deletarCarros(Integer id) {
        repository.deleteById(id);
    }
}

