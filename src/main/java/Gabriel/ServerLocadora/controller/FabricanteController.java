package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.DTOs.FabricanteDTO;
import Gabriel.ServerLocadora.Service.FabricanteService;
import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/*Classe FabricanteController, é responsável pelo processamento das requisições e por gerar respostas referente a
entidade Fabricante.
* */
@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {


    /*Injeção da dependência do FabricanteService.
    *
    * Com a anotação @Autowired, o Spring vai gerenciar a injeção de dependência do FabricanteService.
    * Sendo assim ele vai criar uma instância do FabricanteService para poder acessar seus métodos.
    * */
    @Autowired
    FabricanteService service;

    /*Método para realizar Select * From na tabela Fabricante.
    *Utilizando a anotação GetMapping é feita a solicitação para buscar as informações do banco.
    *
    *
    *Sendo assim esse método busca os registros inseridos na tabela Fabricante e demonstra eles na tela.
    * */
    @GetMapping
    public ResponseEntity<List<Fabricante>> getFabricantes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterFabricantes());
    }

    /*Método para realizar Select from Fabricante = "id".
    * Utilizando a anotação GetMapping é feita a solicitação para buscar as informações do banco conforme id informado.
    *
    *
    * Sendo assim esse método busca o registro inserido na tabela Fabricante conforme o id informado.
    **/
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFabricante(@PathVariable(value = "id") Integer id) {
        try {
            Fabricante fabricante = service.obterFabricantesByIdJDBC(id);
            return ResponseEntity.status(HttpStatus.OK).body(fabricante);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fabricante não encontrado");
        }
    }


    /*Método para realizar inserir into Fabricantes
    * Utilizando a anotação PostMapping é utilizado para mapear as inserçoes que serão solicitadas por métodos
    * específicos
    *
    * Sendo assim esse método inseri novos registros ao banco de dados conforme os atributos da entidade Fabricante.
    **/
    @PostMapping
    public ResponseEntity<String> salvarFabricantes(@RequestBody Fabricante fabricante) {
        try {
            service.inserirFabricantes(fabricante.getNome());
            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante inserido com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir novo fabricante");
        }
    }

    /*Método para realizar Delete na tabela Fabricante no banco de dados
     * Utilizando a anotação @DeleteMapping, anotação essa que é usada para deletar registros utilizando o HTTP DELETE
     *
     * Sendo assim esse método solicita que seja deletado algum registro do banco através do ID informado no
     * acesso do endpoit
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFabricante(@PathVariable(value = "id") Integer id) {
        try {
            service.deletarFabricante(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao deletar o Fabricante");
        }
    }

    /*Método para realizar UPDATE nas informações salva no banco de dados
     * Utilizando a anotação PutMapping é utilizada para mapear as solicitações em métodos manipuladores específicos
     * é uma anotação composta que atua como um atalho para @ResquetMapping.
     *
     * Sendo assim esse método pega as novas informações que serão atualizadas conforme o ID do fabricante e
     * persisti elas no banco de dados.
     *
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFabricante(@PathVariable(value = "id") Integer id,
                                                      @RequestBody FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = service.obterFabricantesById(id);

        BeanUtils.copyProperties(fabricanteDTO, fabricante);
        service.salvarFabricante(fabricante);
        return ResponseEntity.status(HttpStatus.OK).body("Fabricante atualizado com sucesso");

        }*/
    }

