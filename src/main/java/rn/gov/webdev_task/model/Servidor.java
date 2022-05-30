package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.envers.Audited;

@Entity(name = "servidores")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

public class Servidor {

    @Id
    private int matricula;

    @Column(length = 40)
    private String nome_social;

    private Date data_exclusao;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaFisica pessoaFisica;
}
