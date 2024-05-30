package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    FabricanteRepository repository;


    public List<Fabricante> obterFabricantes() {
        return repository.obterTodosFabricantes();
    }

    public Fabricante obterFabricantesByIdJDBC(Integer id) {
        Optional<Fabricante> fabricante = repository.obterFabricanteById(id);
        if (fabricante.isEmpty()) {
            throw new RuntimeException("Não encontrado");
        }
        return fabricante.get();
    }

    /*public Fabricante obterFabricantesById(Integer id) {
        Fabricante fabricante = fabricanteRepositoryJdbc.findById(id).orElseThrow(() ->
                new RuntimeException("Fabricante não encontrado"));
        return fabricante;
    }*/

    public void inserirFabricantes(String nome) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(nome);
        repository.criarFabricante(fabricante);
    }

    /*public void deletarFabricante(Integer id) {
        repository.deleteById(id);
    }

    /*public void atualizarFabricante(Integer id, String novoNome) {
        Fabricante fabricante = repository.findById(id).orElseThrow(() -> 
                new IllegalArgumentException("Fabricante não encontrado"));
        fabricante.setNome(novoNome);
        repository.save(fabricante);
    }

    public void salvarFabricante(Fabricante fabricante) {
        repository.save(fabricante);
    }*/
}
