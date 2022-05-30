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

import rn.gov.webdev_task.dto.request.PessoaRequestDTO;
import rn.gov.webdev_task.dto.response.PessoaResponseDTO;
import rn.gov.webdev_task.model.Pessoa;
import rn.gov.webdev_task.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    PessoaController(PessoaService service){
       this.service = service;
   }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listAll(){
        List<Pessoa> pessoas =service.listAll();
        List<PessoaResponseDTO> pessoaDTO = pessoas.stream().map(obj ->
        new PessoaResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(pessoaDTO);
    } 

    @GetMapping(path ="/{id}")
    public ResponseEntity<PessoaResponseDTO> getOne(@PathVariable long id){
        Optional<Pessoa> p = service.findById(id);
        if(p.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new PessoaResponseDTO(p.get()));
        }
    }


    @PostMapping
    public ResponseEntity<PessoaResponseDTO> insert(@RequestBody PessoaRequestDTO pessoaRequestDTO){
        Pessoa p = service.insert(pessoaRequestDTO.build());
        return ResponseEntity.ok(new PessoaResponseDTO(p));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@PathVariable Long id, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        Optional<Pessoa> p = service.findById(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new PessoaResponseDTO(service.save(pessoaRequestDTO.build())));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.findById(id).map(record -> {
            service.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }      

}












