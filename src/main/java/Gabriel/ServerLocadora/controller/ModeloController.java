package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.Service.ModeloService;
import Gabriel.ServerLocadora.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
