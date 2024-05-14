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

@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> getFabricantes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterFabricantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getFabricante(@PathVariable(value = "id") Integer id) {
        try {
            Fabricante fabricante = service.obterFabricantesById(id);
            return ResponseEntity.status(HttpStatus.OK).body(fabricante);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFabricante(@PathVariable(value = "id") Integer id) {
        try {
            service.deletarFabricante(id);

            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao deletar o Fabricante");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFabricante(@PathVariable(value = "id") Integer id,
                                                      @RequestBody FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = service.obterFabricantesById(id);

        BeanUtils.copyProperties(fabricanteDTO, fabricante);
        service.salvarFabricante(fabricante);
        return ResponseEntity.status(HttpStatus.OK).body("Fabricante atualizado com sucesso");

        }
    }

