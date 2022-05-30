package rn.gov.webdev_task.service;

import rn.gov.webdev_task.repository.DeficienciaRepository;
import rn.gov.webdev_task.model.Deficiencia;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository repos;

    DeficienciaService(DeficienciaRepository repos){
        this.repos = repos;
    }

    public Deficiencia insert(Deficiencia e){
        return this.repos.save(e);
    }

    public Deficiencia update(Deficiencia e){
        return this.repos.save(e);
    }

    public void delete (Deficiencia e){
        e.setData_exclusao(new Date());
        this.repos.saveAndFlush(e);
    }

    public Deficiencia saveAndFlush(Deficiencia e){
        return this.repos.saveAndFlush(e);
    }

    public Deficiencia save(Deficiencia e){
        return this.repos.save(e);
    }

    public Optional<Deficiencia> findById(Long id){
        return this.repos.findById(id);
    }

    public List<Deficiencia> listAll(){
        return this.repos.findAllNoDeleted();
        //        return this.repos.findAll();
    }

}
