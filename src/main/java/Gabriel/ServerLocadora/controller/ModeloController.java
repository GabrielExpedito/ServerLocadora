package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.DTOs.ModeloDTO;
import Gabriel.ServerLocadora.Service.ModeloService;
import Gabriel.ServerLocadora.entity.Modelo;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * Classe ModeloController, é responsável pelo processamento das requisições e por gerar as respostas referente
 * ao objeto Fabricante
 * */
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    /*
     * Injeção da dependência do ModeloService
     *
     * Com a anotação @AutoWired, o Spring vai gerenciar a injeção de dependência do ModeloService.
     * Sendo assim ele vai criar uma instância do ModeloService para poder acessar seu métodos
     * */
    @Autowired
    ModeloService service;

    /*Método para realizar UPDATE nas informações salva no banco de dados
    * Utilizando a anotação PutMapping é utilizada para mapear as solicitações em métodos manipuladores específicos
    * é uma anotação composta que atua como um atalho para @ResquetMapping.
    *
    * Sendo assim esse método pega as novas informações que serão atualizadas conforme o ID do modelo e persisti elas no
    * banco de dados.
    *
    * */
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarModelos(@PathVariable(value = "id") Integer id,
                                                   @RequestBody ModeloDTO modeloDTO) {
        Modelo modelo = service.obterModeloById(id);

        BeanUtils.copyProperties(modeloDTO, modelo);
        service.salvarModelo(modelo);
        return ResponseEntity.status(HttpStatus.OK).body("Modelo atualizado com suscesso");


    }

    /*Método para realizar Select * From Modelo no banco de dados
    * Utilizando a anotação GetMapping, anotação essa que é usada para mapear solicitações em HTTP GET
    *
    * Sendo assim esse método solicita e traz a tela todos os modelos que estão cadastrados no banco.
    * */
    @GetMapping
    public ResponseEntity<List<Modelo>> getModelos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterModelos());
    }

    /*Método para realizar Select from Modelo where = "id" selecionado pelo usuário
    * Utilizando a anotação GetMapping, anotação essa que é usada para mapear solicitações em HTTP GET
    *
    * Sendo assim esse método solicita e traz a tela o modelo conforme o id passado pela solicitação que está cadastrado
    * no banco de dados
    * */
    @GetMapping("{id}")
    public ResponseEntity<Modelo> getModelosById(@PathVariable(value = "id") Integer id) {
        try {
            Modelo modelo = service.obterModeloById(id);
            return ResponseEntity.ok(modelo);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PostMapping
    public ResponseEntity<String> inserirModelo(@RequestBody Modelo modelo) {
        try {
            service.inserirModelo(modelo.getNome(), modelo.getId(), modelo.getIdfabricante());
            return ResponseEntity.status(HttpStatus.CREATED).body("Modelo inserido com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir Modelo");

        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarModelo(@PathVariable(value = "id") Integer id) {
        try {
            service.deletarModelo(id);
            return ResponseEntity.status(HttpStatus.OK).body("Modelo deletado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao deletar modelo");

        }

    }

}
