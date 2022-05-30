package rn.gov.webdev_task.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rn.gov.webdev_task.dto.request.PessoaFisicaRequestDTO;
import rn.gov.webdev_task.dto.response.PessoaFisicaResponseDTO;
import rn.gov.webdev_task.model.PessoaFisica;
import rn.gov.webdev_task.service.PessoaFisicaService;

@RestController
@RequestMapping("/api/pessoasfisicas")
public class PessoaFisicaController {
    
    @Autowired
    private PessoaFisicaService service;

    @GetMapping
    public ResponseEntity<List<PessoaFisicaResponseDTO>> listALl(){
        List<PessoaFisica> pessoasfisicas = service.listAll();
        List<PessoaFisicaResponseDTO> pessoasfisicasDTO = pessoasfisicas.stream().map(obj -> new PessoaFisicaResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(pessoasfisicasDTO);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<PessoaFisicaResponseDTO> getOne(@PathVariable Long id){
        Optional<PessoaFisica> pf = service.findById(id);
        if (pf.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new PessoaFisicaResponseDTO(pf.get()));
        }
    }

    @PostMapping
    public ResponseEntity<PessoaFisicaResponseDTO> insert(@RequestBody PessoaFisicaRequestDTO pessoaFisicaRequestDTO){
        PessoaFisica pf = service.insert(pessoaFisicaRequestDTO.build());
        return ResponseEntity.ok(new PessoaFisicaResponseDTO(pf));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<PessoaFisicaResponseDTO> update(@PathVariable Long id, @RequestBody PessoaFisicaRequestDTO pessoaFisicaRequestDTO){
        Optional<PessoaFisica> pf = service.findById(id);
        if (pf.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new PessoaFisicaResponseDTO(service.save(pessoaFisicaRequestDTO.build())));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<PessoaFisica> pf = service.findById(id);
        if (pf.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
