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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import rn.gov.webdev_task.dto.request.EnderecoRequestDTO;
import rn.gov.webdev_task.dto.response.EnderecoResponseDTO;
import rn.gov.webdev_task.model.Endereco;
import rn.gov.webdev_task.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;

    EnderecoController(EnderecoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listALl(
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "3") int tamanho)
    {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        Page<Endereco> enderecos = service.listAll(pageRequest);
        List<EnderecoResponseDTO> enderecosDTO = enderecos.stream().map(obj -> new EnderecoResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(enderecosDTO);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<EnderecoResponseDTO> getOne(@PathVariable Long id){
        Optional<Endereco> e = service.findById(id);
        if (e.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new EnderecoResponseDTO(e.get()));
        }
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> insert(@RequestBody EnderecoRequestDTO enderecoRequestDTO){
        Endereco e = service.insert(enderecoRequestDTO.build());
        return ResponseEntity.ok(new EnderecoResponseDTO(e));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<EnderecoResponseDTO> update(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoRequestDTO){
        Optional<Endereco> e = service.findById(id);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new EnderecoResponseDTO(service.save(enderecoRequestDTO.build())));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Endereco> e = service.findById(id);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
