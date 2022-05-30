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

import rn.gov.webdev_task.dto.request.VinculoRequestDTO;
import rn.gov.webdev_task.dto.response.VinculoResponseDTO;
import rn.gov.webdev_task.model.Vinculo;
import rn.gov.webdev_task.service.VinculoService;

@RestController
@RequestMapping("/api/vinculos")
public class VinculoController {
    
    @Autowired
    private VinculoService service;

    VinculoController(VinculoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VinculoResponseDTO>> listALl(
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "3") int tamanho)
    {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        Page<Vinculo> vinculos = service.listAll(pageRequest);
        List<VinculoResponseDTO> vinculosDTO = vinculos.stream().map(obj -> new VinculoResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(vinculosDTO);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<VinculoResponseDTO> getOne(@PathVariable Long id){
        Optional<Vinculo> e = service.findById(id);
        if (e.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new VinculoResponseDTO(e.get()));
        }
    }

    @PostMapping
    public ResponseEntity<VinculoResponseDTO> insert(@RequestBody VinculoRequestDTO VinculoRequestDTO){
        Vinculo e = service.insert(VinculoRequestDTO.build());
        return ResponseEntity.ok(new VinculoResponseDTO(e));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<VinculoResponseDTO> update(@PathVariable Long id, @RequestBody VinculoRequestDTO VinculoRequestDTO){
        Optional<Vinculo> e = service.findById(id);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new VinculoResponseDTO(service.save(VinculoRequestDTO.build())));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Vinculo> e = service.findById(id);
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
