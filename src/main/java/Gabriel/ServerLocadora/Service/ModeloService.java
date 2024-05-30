package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.DTOs.ModeloDTO;
import Gabriel.ServerLocadora.entity.Modelo;
import Gabriel.ServerLocadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository repository;


    public List<ModeloDTO> obterModelos() {
        return repository.obterTodosModelos();
    }

   public ModeloDTO obterModeloById(Integer id) {
        Optional<ModeloDTO> modelo = repository.obterModelosById(id);
        if (modelo.isEmpty()) {
            throw new RuntimeException("Modelo não existe");
        }
        return modelo.get();
    }

    public void deletarModelo(Integer id) {
        repository.deletarModelo(id);
    }

   public void inserirModelo(Modelo modelo) {
        repository.inserirModelo(modelo);
    }

   public void salvarModelo(Modelo modelo) {
        repository.atualizarModelo(modelo);
    }

}

