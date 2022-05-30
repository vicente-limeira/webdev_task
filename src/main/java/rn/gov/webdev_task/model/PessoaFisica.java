package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity(name = "pessoas_fisicas")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

@PrimaryKeyJoinColumn(name="pessoa_id")
public class PessoaFisica extends Pessoa {

    @Column(nullable=false)
    private Character sexo;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(length=3)
    private String tipo_sangue;

    @Column(length = 100, nullable = false)
    private String nome_pai;

    @Column(length = 100, nullable = false)
    private String nome_mae;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "pessoas_fisicas_deficiencias"
        , joinColumns = {
            @JoinColumn(
                name = "pessoa_id",
                referencedColumnName = "pessoa_id"
            )
        }
        , inverseJoinColumns = {
            @JoinColumn(
                name = "deficiencia_id",
                referencedColumnName = "id"
            )
        }
    )
    private List<Deficiencia> deficiencias = new ArrayList<Deficiencia>();
    
    // TODO: Erro
    // @OneToMany(mappedBy="pessoaFisica", fetch = FetchType.LAZY)
    // private List<Servidor> servidores = new ArrayList<Servidor>();    
}
