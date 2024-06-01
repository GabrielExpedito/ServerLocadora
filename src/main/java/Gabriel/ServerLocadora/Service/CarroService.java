package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Carro;
import Gabriel.ServerLocadora.filter.CarroFilter;
import Gabriel.ServerLocadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    /*Injeção de dependência do CarroRepository
    *
    * Com a anotação @Autowired, o spring vai gerenciar a injeção da dependência do CarroRepository
    * */
    @Autowired
    CarroRepository repository;

    /*O método retorna uma lista de Carro com todos os carros registrados no banco de dados
    *Utilizando um método JDBCRepository que retorna todos os Carros
    * */
    public List<Carro> obterCarros(CarroFilter filtro) {
        return repository.buscarTodosCarros(filtro);
    }

    /*O método não espera nenhum retorno ele realiza a persistência no banco para inserir um novo Carro
    * @Param: atributos da entidade Carro
    * Utilizando um método JDBCRepository para inserir dados no banco de dados
    * */
    public void inserirCarros(Carro carro) {
        repository.criarCarro(carro);
    }

    /*O método não esperar nenhum retorno ele realiza uma persistência no banco para excluir um dado
    *@Para: Integer id - identificador do carro que deseja ser exluído
    * Utilizando um método JDBCRepository para excluir dados no banco de dados
    * */
    public void deletarCarros(Integer id) {
        repository.deletarCarro(id);
    }

    /*O método não espera nenhum retorno ele realiza uma persistência no banco de dados para atualizar um registro
    * @Param: atributos da entidade Carro
    * Utilizando um método JDBCRepository para atualizar dados no banco de dados
    * */
    public void atualizarCarro(Carro carro) {
        repository.atualizarCarro(carro);
    }

   /* public Carro obterCarroById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Carro não encontrado"));
    }*/
}


