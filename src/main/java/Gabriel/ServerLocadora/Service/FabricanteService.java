package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    FabricanteRepository repository;

    public List<Fabricante> obterFabricantes() {
        return repository.findAll();
    }

    public Fabricante obterFabricantesById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Fabricante não encontrado"));
    }

        public void inserirFabricantes(String nome) {
            Fabricante fabricante = new Fabricante();
            fabricante.setNome(nome);
            repository.save(fabricante);
        }

    public void deletarFabricante(Integer id) {
        repository.deleteById(id);
    }

    public void atualizarFabricante(Integer id, String novoNome) {
        Fabricante fabricante = repository.findById(id).orElseThrow(() -> 
                new IllegalArgumentException("Fabricante não encontrado"));
        fabricante.setNome(novoNome);
        repository.save(fabricante);
    }

    public void salvarFabricante(Fabricante fabricante) {
        repository.save(fabricante);
    }
}
