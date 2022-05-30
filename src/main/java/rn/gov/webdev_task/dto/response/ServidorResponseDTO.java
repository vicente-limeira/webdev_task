package rn.gov.webdev_task.dto.response;
import java.util.Date;

import lombok.Data;
import rn.gov.webdev_task.model.Servidor;
import rn.gov.webdev_task.model.PessoaFisica;

@Data
public class ServidorResponseDTO {
    private int matricula;
    private String nome_social;
    private Date data_exclusao;
    private PessoaFisica pessoaFisica;

    public ServidorResponseDTO (Servidor s) {
        this.setMatricula(s.getMatricula());
        this.setNome_social(s.getNome_social());
        this.setPessoaFisica(s.getPessoaFisica());
        this.setData_exclusao(s.getData_exclusao());
        
        // TODO: Erro
        // this.setPessoaFisica(s.getPessoaFisica());
    }
}
