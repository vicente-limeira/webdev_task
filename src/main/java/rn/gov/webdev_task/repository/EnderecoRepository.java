package rn.gov.webdev_task.repository;

import rn.gov.webdev_task.model.Endereco;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("select e from #{#entityName} e where e.data_exclusao is null")
    // List<Endereco> findAllNoDeleted();
    Page<Endereco> findAllNoDeleted(PageRequest pageRequest);
}

