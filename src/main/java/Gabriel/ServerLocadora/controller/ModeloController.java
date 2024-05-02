package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.Service.ModeloService;
import Gabriel.ServerLocadora.entity.Modelo;
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

    @PostMapping
    public ResponseEntity<String> inserirModelo(@RequestBody Modelo modelo) {
        try {
            service.inserirModelo(modelo.getNome(), modelo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante inserido com sucesso");
        }catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao inserir fabricante");

        }
    }

}
