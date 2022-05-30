package rn.gov.webdev_task.dto.response;
import java.util.Date;

import lombok.Data;
import rn.gov.webdev_task.model.Deficiencia;

@Data
public class DeficienciaResponseDTO {
    private long id;
    private Boolean eh_fisica;
    private Boolean eh_visual;
    private Boolean eh_auditiva;
    private Boolean eh_mental;
    private Boolean eh_intelectual;
    private String denominacao;  
    private Date data_exclusao;

    public DeficienciaResponseDTO (Deficiencia d) {
        this.setId(d.getId());
        this.setEh_fisica(d.getEh_fisica());
        this.setEh_visual(d.getEh_visual());
        this.setEh_auditiva(d.getEh_auditiva());
        this.setEh_mental(d.getEh_mental());
        this.setEh_intelectual(d.getEh_intelectual());
        this.setDenominacao(d.getDenominacao());
        this.setData_exclusao(d.getData_exclusao());
    }
}
