package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.Deficiencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeficienciaRepository extends JpaRepository<Deficiencia, Long> {

    @Query("select e from #{#entityName} e where e.data_exclusao is null")
    List<Deficiencia> findAllNoDeleted();
}