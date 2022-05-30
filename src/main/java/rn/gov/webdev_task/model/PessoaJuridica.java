package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

@Entity(name = "pessoas_juridicas")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

@PrimaryKeyJoinColumn(name="pessoa_id")
public class PessoaJuridica extends Pessoa {

    @Column(length = 120, nullable = false)
    private String razao_social;

    @Column(length = 14, nullable = false)
    private String cnpj;
}
