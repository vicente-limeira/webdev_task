package rn.gov.webdev_task.service;

import rn.gov.webdev_task.repository.PessoaFisicaRepository;
import rn.gov.webdev_task.model.PessoaFisica;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repos;

    public PessoaFisica insert(PessoaFisica pf){  
        return this.repos.save(pf);
    }

    public PessoaFisica update(PessoaFisica pf){
        return this.repos.save(pf);
    }

    public void delete (PessoaFisica pf){
        pf.setData_exclusao(new Date());
        this.repos.saveAndFlush(pf);
    }

    public PessoaFisica saveAndFlush(PessoaFisica pf){
        return this.repos.saveAndFlush(pf);
    }

    public PessoaFisica save(PessoaFisica pf){
        return this.repos.save(pf);
    }

    public Optional<PessoaFisica> findById(Long id){
        return this.repos.findById(id);
    }

    public List<PessoaFisica> listAll(){
        return this.repos.findAllNoDeleted();
    }

}
