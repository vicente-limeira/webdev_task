package rn.gov.webdev_task.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rn.gov.webdev_task.dto.request.ServidorRequestDTO;
import rn.gov.webdev_task.dto.response.ServidorResponseDTO;
import rn.gov.webdev_task.model.Servidor;
import rn.gov.webdev_task.service.ServidorService;

@RestController
@RequestMapping("/api/servidores")
public class ServidorController {
    
    @Autowired
    private ServidorService service;

    ServidorController(ServidorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServidorResponseDTO>> listALl(){
        List<Servidor> servidores = service.listAll();
        List<ServidorResponseDTO> servidoresDTO = servidores.stream().map(obj -> new ServidorResponseDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(servidoresDTO);
    }

    @GetMapping(path = "/{matricula}")
    public ResponseEntity<ServidorResponseDTO> getOne(@PathVariable int matricula){
        Optional<Servidor> s = service.findByMatricula(matricula);
        if (s.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(new ServidorResponseDTO(s.get()));
        }
    }

    @PostMapping
    public ResponseEntity<ServidorResponseDTO> insert(@RequestBody ServidorRequestDTO servidorRequestDTO){
        Optional<Servidor> s = service.findByMatricula(servidorRequestDTO.getMatricula());
        if (s.isEmpty()){
            Servidor srv = service.insert(servidorRequestDTO.build());
            return ResponseEntity.ok(new ServidorResponseDTO(srv));
            // ServidorResponseDTO result = new ServidorResponseDTO(servidorRequestDTO.build());
            // return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
    
    @PutMapping(path = "/{matricula}")
    public ResponseEntity<ServidorResponseDTO> update(@PathVariable int matricula, @RequestBody ServidorRequestDTO servidorRequestDTO){
        Optional<Servidor> s = service.findByMatricula(matricula);
        if (s.isEmpty()) {
            return ResponseEntity.notFound().build();
        }       
        return ResponseEntity.ok(new ServidorResponseDTO(service.save(servidorRequestDTO.build())));
    }

    @DeleteMapping(path = "/{matricula}")
    public ResponseEntity<?> delete(@PathVariable int matricula){
        Optional<Servidor> s = service.findByMatricula(matricula);
        if (s.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return s.map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
