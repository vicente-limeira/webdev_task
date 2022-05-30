package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.PessoaFisica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    @Query("select pf from #{#entityName} pf where pf.data_exclusao is null")
    List<PessoaFisica> findAllNoDeleted();
}