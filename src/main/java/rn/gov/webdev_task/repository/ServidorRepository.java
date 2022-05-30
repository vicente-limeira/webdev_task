package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.Servidor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServidorRepository extends JpaRepository<Servidor, Integer> {

    @Query("select e from #{#entityName} e where e.data_exclusao is null")
    List<Servidor> findAllNoDeleted();

    Optional<Servidor> findByMatricula(int matricula);
}