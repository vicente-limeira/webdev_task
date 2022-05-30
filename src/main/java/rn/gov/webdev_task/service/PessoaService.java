package rn.gov.webdev_task.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rn.gov.webdev_task.model.Pessoa;
import rn.gov.webdev_task.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repos;

    PessoaService(PessoaRepository repos){
        this.repos = repos;
    }

    public Pessoa update(Pessoa p){
        return this.repos.save(p);
    }

    public Pessoa insert(Pessoa p){
        return this.repos.save(p);
    }

    public Optional<Pessoa> findById(Long id){
        return this.repos.findById(id);
    }

    public List<Pessoa> listAll(){
        //return this.repos.findAllNoDeleted();
        return this.repos.findAll();
    }

    public Pessoa save(Pessoa p){
        return this.repos.save(p);
    }

    public Pessoa saveAndFlush(Pessoa p){
        return this.repos.saveAndFlush(p);
    }

    public void delete(Pessoa p){
        p.setData_exclusao(new Date());
        this.repos.saveAndFlush(p);
    }
}
