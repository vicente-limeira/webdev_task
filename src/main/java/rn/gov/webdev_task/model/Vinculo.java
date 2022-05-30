package rn.gov.webdev_task.model;
import rn.gov.webdev_task.model.generic.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;

@Entity(name = "vinculos")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

public class Vinculo extends AbstractEntity {

    private Date data_nomeacao;
    private Date data_posse;
    private Date data_exercicio;

    @ManyToOne()
    @JoinColumn(name = "matricula")
    private Servidor servidor;
}