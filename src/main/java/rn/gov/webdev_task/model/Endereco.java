package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import rn.gov.webdev_task.model.generic.AbstractEntity;

@Entity(name = "enderecos")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

public class Endereco extends AbstractEntity {

    @Column(name = "bairro", length = 80, nullable = false)
    private String bairro;

    @Column(length = 20, nullable = false)
    private String tipo_logradouro;

    @Column(length = 80, nullable = false)
    private String logradouro;

    @Column(length = 80, nullable = false)
    private String complemento;

    @Column(length = 6, nullable = true)
    private String numero;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(nullable = true)
    private double latidute;

    @Column(nullable = true)
    private double longitude;
}
