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

import rn.gov.webdev_task.dto.request.DeficienciaRequestDTO;
import rn.gov.webdev_task.dto.response.DeficienciaResponseDTO;
import rn.gov.webdev_task.model.Deficiencia;
import rn.gov.webdev_task.service.DeficienciaService;

@RestController
@RequestMapping("/api/deficiencias")
public class DeficienciaController {
    
    @Autowired
    private DeficienciaService service;

    DeficienciaController(DeficienciaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DeficienciaResponseDTO>> listALl(){
        List<Deficiencia> enderecos = service.listAll();
        List<DeficienciaResponseDTO> enderecosDTO = enderecos.stream().map(obj -> new DeficienciaResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(enderecosDTO);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<DeficienciaResponseDTO> getOne(@PathVariable Long id){
        Optional<Deficiencia> e = service.findById(id);
        if (e.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new DeficienciaResponseDTO(e.get()));
        }
    }

    @PostMapping
    public ResponseEntity<DeficienciaResponseDTO> insert(@RequestBody DeficienciaRequestDTO DeficienciaRequestDTO){
        Deficiencia e = service.insert(DeficienciaRequestDTO.build());
        return ResponseEntity.ok(new DeficienciaResponseDTO(e));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<DeficienciaResponseDTO> update(@PathVariable Long id, @RequestBody DeficienciaRequestDTO DeficienciaRequestDTO){
        Optional<Deficiencia> e = service.findById(id);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new DeficienciaResponseDTO(service.save(DeficienciaRequestDTO.build())));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Deficiencia> e = service.findById(id);
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
