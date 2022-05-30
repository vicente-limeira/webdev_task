package rn.gov.webdev_task.dto.request;
import java.util.Date;

import lombok.Data;

import rn.gov.webdev_task.model.Vinculo;
import rn.gov.webdev_task.model.Servidor;

@Data
public class VinculoRequestDTO {
    
    private Long id;
    private Date data_nomeacao;
    private Date data_posse;
    private Date data_exercicio;
    private Servidor servidor;

    public Vinculo build() {
        Vinculo v = new Vinculo();
        v.setId(this.id);
        v.setData_nomeacao(this.data_nomeacao);
        v.setData_posse(this.data_posse);
        v.setData_exercicio(this.data_exercicio);
        v.setServidor(this.servidor);
        return v;
    }
}
