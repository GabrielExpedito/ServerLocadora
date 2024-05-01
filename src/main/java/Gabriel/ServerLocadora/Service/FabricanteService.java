package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.DadosCriacaoFabricante;
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

        public void inserirFabricantes(String nome) {
            Fabricante fabricante = new Fabricante();
            fabricante.setNome(nome);
            repository.save(fabricante);
        }

    public void deletarFabricante(Integer id) {
        repository.deleteById(id);
    }
}
