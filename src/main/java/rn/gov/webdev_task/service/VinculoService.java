package rn.gov.webdev_task.service;

import rn.gov.webdev_task.repository.VinculoRepository;
import rn.gov.webdev_task.model.Vinculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VinculoService {

    @Autowired
    private VinculoRepository repos;

    public Vinculo insert(Vinculo v){  
        return this.repos.save(v);
    }

    public Vinculo update(Vinculo v){
        return this.repos.save(v);
    }

    public void delete (Vinculo v){
        v.setData_exclusao(new Date());
        this.repos.saveAndFlush(v);
    }

    public Vinculo saveAndFlush(Vinculo v){
        return this.repos.saveAndFlush(v);
    }

    public Vinculo save(Vinculo v){
        return this.repos.save(v);
    }

    public Optional<Vinculo> findById(Long id){
        return this.repos.findById(id);
    }

    public Page<Vinculo> listAll(PageRequest pageRequest){
        return this.repos.findAllNoDeleted(pageRequest);
    }

}
