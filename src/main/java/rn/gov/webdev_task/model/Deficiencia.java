package rn.gov.webdev_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import rn.gov.webdev_task.model.generic.AbstractEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "deficiencias")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited

public class Deficiencia extends AbstractEntity {

    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean eh_fisica;
    @Column(nullable = false)
    private Boolean eh_visual;
    @Column(nullable = false)
    private Boolean eh_auditiva;
    @Column(nullable = false)
    private Boolean eh_mental;
    @Column(nullable = false)
    private Boolean eh_intelectual;

    @Column(length = 80, nullable = false)
    private String denominacao;
}
