package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.Service.ModeloService;
import Gabriel.ServerLocadora.entity.Modelo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    ModeloService service;


    @GetMapping
    public ResponseEntity<List<Modelo>> getModelos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterModelos());
    }

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
