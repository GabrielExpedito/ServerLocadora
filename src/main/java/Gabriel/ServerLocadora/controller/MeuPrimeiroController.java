package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class MeuPrimeiroController {

    private FabricanteRepository fabricanteRepository;

    @Autowired
    FabricanteRepository repository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

        return String.format("Hello %s!", name);
    }

    @PostMapping("/hello")
    public String olar(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("OLAR");
    }

    @GetMapping("/fabricante")
    public ResponseEntity<List<Fabricante>> getFabricante() {
        return ResponseEntity.ok().body(repository.findAll());

    }

    @PostMapping()
    public String Insert(Integer id, String nome) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(10);
        fabricante.setNome("Teste8");
        fabricanteRepository.save(fabricante);

        return String.format("Fabricante inserido no banco de dados");

    }
}
