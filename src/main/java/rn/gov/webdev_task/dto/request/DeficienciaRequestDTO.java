package rn.gov.webdev_task.dto.request;

import lombok.Data;
import rn.gov.webdev_task.model.Deficiencia;

@Data
public class DeficienciaRequestDTO {

    private long id;
    private Boolean eh_fisica;
    private Boolean eh_visual;
    private Boolean eh_auditiva;
    private Boolean eh_mental;
    private Boolean eh_intelectual;
    private String denominacao;

    public Deficiencia build() {
        Deficiencia d = new Deficiencia();
        d.setEh_fisica(this.eh_fisica);
        d.setEh_visual(this.eh_visual);
        d.setEh_auditiva(this.eh_auditiva);
        d.setEh_mental(this.eh_mental);
        d.setEh_intelectual(this.eh_intelectual);
        d.setDenominacao(this.denominacao);
       
        return d;
    }
}
