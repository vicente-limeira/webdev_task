package rn.gov.webdev_task.service;

import rn.gov.webdev_task.repository.PessoaJuridicaRepository;
import rn.gov.webdev_task.model.PessoaJuridica;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repos;

    public PessoaJuridica insert(PessoaJuridica pj){  
        return this.repos.save(pj);
    }

    public PessoaJuridica update(PessoaJuridica pj){
        return this.repos.save(pj);
    }

    public void delete (PessoaJuridica pj){
        pj.setData_exclusao(new Date());
        this.repos.saveAndFlush(pj);
    }

    public PessoaJuridica saveAndFlush(PessoaJuridica pj){
        return this.repos.saveAndFlush(pj);
    }

    public PessoaJuridica save(PessoaJuridica pj){
        return this.repos.save(pj);
    }

    public Optional<PessoaJuridica> findById(Long id){
        return this.repos.findById(id);
    }

    public List<PessoaJuridica> listAll(){
        return this.repos.findAllNoDeleted();
    }

}
