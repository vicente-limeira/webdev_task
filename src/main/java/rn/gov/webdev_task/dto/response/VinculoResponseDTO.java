package rn.gov.webdev_task.dto.response;
import java.util.Date;

import lombok.Data;
import rn.gov.webdev_task.model.Vinculo;
import rn.gov.webdev_task.model.Servidor;

@Data
public class VinculoResponseDTO {
    private Long id;
    private Date data_nomeacao;
    private Date data_posse;
    private Date data_exercicio;
    private Date data_exclusao;
    private Servidor servidor;

    public VinculoResponseDTO (Vinculo v) {
        this.setId(v.getId());
        this.setData_nomeacao(v.getData_nomeacao());
        this.setData_posse(v.getData_posse());
        this.setData_exercicio(v.getData_exercicio());
        this.setData_exclusao(v.getData_exclusao());
        this.setServidor(v.getServidor());
    }
}
