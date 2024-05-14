package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Modelo;
import Gabriel.ServerLocadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository repository;


    public List<Modelo> obterModelos() {
        return repository.findAll();
    }

    public Modelo obterModeloById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Modelo não encontrado")
        );
    }

    public void inserirModelo(String nome, Integer id, Integer idfabricante) {
        Modelo modelo = new Modelo();
        modelo.setNome(nome);
        modelo.setId(id);
        modelo.setIdfabricante(idfabricante);
        repository.save(modelo);
    }

    public void deletarModelo(Integer id) {
        repository.deleteById(id);
    }

    public void salvarModelo(Modelo modelo) {
        repository.save(modelo);

    }

}

