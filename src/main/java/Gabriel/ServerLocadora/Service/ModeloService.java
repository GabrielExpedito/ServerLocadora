package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Modelo;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import Gabriel.ServerLocadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository repository;


    public List<Modelo> obterModelos(){
        return repository.findAll();
    }

    public void inserirModelo(String nome, Integer id) {
        Modelo modelo = new Modelo();
        modelo.setNome(nome);
        modelo.setId(id);
        repository.save(modelo);
    }

}