package rn.gov.webdev_task.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rn.gov.webdev_task.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
  //  @Query("select p form #{#entityName} p where p.data_exclucao is null")
  // List<Pessoa> findAllNoDeleted(PageRequest pageRequest);
}
    
