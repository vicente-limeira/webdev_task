package rn.gov.webdev_task.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import rn.gov.webdev_task.model.Endereco;
import rn.gov.webdev_task.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repos;

    EnderecoService(EnderecoRepository repos){
        this.repos = repos;
    }

    public Endereco insert(Endereco e){
        return this.repos.save(e);
    }

    public Endereco update(Endereco e){
        return this.repos.save(e);
    }

    public void delete (Endereco e){
        e.setData_exclusao(new Date());
        this.repos.saveAndFlush(e);
    }

    public Endereco saveAndFlush(Endereco e){
        return this.repos.saveAndFlush(e);
    }

    public Endereco save(Endereco e){
        return this.repos.save(e);
    }

    public Optional<Endereco> findById(Long id){
        return this.repos.findById(id);
    }

    //public List<Endereco> listAll(){
    //    return this.repos.findAllNoDeleted();
    //}

    public Page<Endereco> listAll(PageRequest pageRequest) {
        
        return this.repos.findAllNoDeleted(pageRequest);
    }

}
