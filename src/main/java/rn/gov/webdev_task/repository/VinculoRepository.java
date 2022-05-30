package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.Vinculo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VinculoRepository extends JpaRepository<Vinculo, Long> {

    @Query("select e from #{#entityName} e where e.data_exclusao is null")
    Page<Vinculo> findAllNoDeleted(PageRequest pageRequest);
}