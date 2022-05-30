package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import rn.gov.webdev_task.model.generic.AbstractEntity;

@Entity(name = "pessoas")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean pessoa_juridica;

    @Column(length = 80, nullable = false)
    private String telefones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
}
