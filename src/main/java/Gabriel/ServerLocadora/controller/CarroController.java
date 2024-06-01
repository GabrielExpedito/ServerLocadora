package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.DTOs.CarroDTO;
import Gabriel.ServerLocadora.Service.CarroService;
import Gabriel.ServerLocadora.entity.Carro;
import Gabriel.ServerLocadora.entity.Modelo;
import Gabriel.ServerLocadora.filter.CarroFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> getCarros(@RequestParam Map<String, String> parametros) {
        CarroFilter filtro = new CarroFilter(parametros);
        return ResponseEntity.status(HttpStatus.OK).body(service.obterCarros(filtro));
    }

    @PostMapping
    public ResponseEntity<String> inserirCarros(@RequestBody Carro carro) {
        service.inserirCarros(carro);
        return ResponseEntity.status(HttpStatus.OK).body("Carro inserido com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarro(@PathVariable(value = "id") Integer id) {
        try {
            service.deletarCarros(id);
            return ResponseEntity.status(HttpStatus.OK).body("Carro deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarCarro(Carro carro) {
        service.atualizarCarro(carro);
        return ResponseEntity.status(HttpStatus.OK).body("Carro atualizado com sucesso");
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable(value = "id") Integer id) {
        try {
            Carro carro = service.obterCarroById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(carro);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }*/
}
