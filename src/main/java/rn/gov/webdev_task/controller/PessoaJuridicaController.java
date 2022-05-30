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

import rn.gov.webdev_task.dto.request.PessoaJuridicaRequestDTO;
import rn.gov.webdev_task.dto.response.PessoaJuridicaResponseDTO;
import rn.gov.webdev_task.model.PessoaJuridica;
import rn.gov.webdev_task.service.PessoaJuridicaService;

@RestController
@RequestMapping("/api/pessoasjuridicas")
public class PessoaJuridicaController {
    
    @Autowired
    private PessoaJuridicaService service;

    @GetMapping
    public ResponseEntity<List<PessoaJuridicaResponseDTO>> listALl(){
        List<PessoaJuridica> pessoasfisicas = service.listAll();
        List<PessoaJuridicaResponseDTO> pessoasfisicasDTO = pessoasfisicas.stream().map(obj -> new PessoaJuridicaResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(pessoasfisicasDTO);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<PessoaJuridicaResponseDTO> getOne(@PathVariable Long id){
        Optional<PessoaJuridica> pj = service.findById(id);
        if (pj.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new PessoaJuridicaResponseDTO(pj.get()));
        }
    }

    @PostMapping
    public ResponseEntity<PessoaJuridicaResponseDTO> insert(@RequestBody PessoaJuridicaRequestDTO PessoaJuridicaRequestDTO){
        PessoaJuridica pj = service.insert(PessoaJuridicaRequestDTO.build());
        return ResponseEntity.ok(new PessoaJuridicaResponseDTO(pj));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<PessoaJuridicaResponseDTO> update(@PathVariable Long id, @RequestBody PessoaJuridicaRequestDTO PessoaJuridicaRequestDTO){
        Optional<PessoaJuridica> pj = service.findById(id);
        if (pj.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new PessoaJuridicaResponseDTO(service.save(PessoaJuridicaRequestDTO.build())));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<PessoaJuridica> pj = service.findById(id);
        if (pj.isEmpty()) {
            return ResponseEntity.notFound().build();
        }  
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
