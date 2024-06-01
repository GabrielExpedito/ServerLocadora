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

    /*Injeção de dependência do ModeloRepository
     *Com a anotação @Autowired, o spring vai gerenciar a injeção da dependência do CarroRepository
     *  */
    @Autowired
    ModeloRepository repository;

    /*Método retorna uma lista de Modelos com todos os carros registrados no banco de dados
     *Utilizando um método JDBCRepository que retorna todos os Carros
     * */
    public List<ModeloDTO> obterModelos() {
        return repository.obterTodosModelos();
    }

    /*Método retorna uma ModeloDTO com o Modelo encontrado no banco igual o id solicitado
    * Utilizando um método JDBCRepository que retorna um Carro conforme o id solicitado
    * */
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

