package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.PessoaJuridica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    @Query("select pf from #{#entityName} pf where pf.data_exclusao is null")
    List<PessoaJuridica> findAllNoDeleted();
}