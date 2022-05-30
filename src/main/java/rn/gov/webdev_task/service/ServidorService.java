package rn.gov.webdev_task.service;

import rn.gov.webdev_task.repository.ServidorRepository;
import rn.gov.webdev_task.model.Servidor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository repos;

    public Servidor insert(Servidor s){  
        return this.repos.save(s);
    }

    public Servidor update(Servidor s){
        return this.repos.save(s);
    }

    public void delete (Servidor s){
        s.setData_exclusao(new Date());
        this.repos.saveAndFlush(s);
    }

    public Servidor saveAndFlush(Servidor s){
        return this.repos.saveAndFlush(s);
    }

    public Servidor save(Servidor s){
        return this.repos.save(s);
    }

    public Optional<Servidor> findByMatricula(int matricula){
        return this.repos.findByMatricula(matricula);
    }

    public List<Servidor> listAll(){
        return this.repos.findAllNoDeleted();
    }

}
