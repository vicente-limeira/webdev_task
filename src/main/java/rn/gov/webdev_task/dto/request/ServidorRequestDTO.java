package rn.gov.webdev_task.dto.request;
import lombok.Data;

import rn.gov.webdev_task.model.Servidor;
import rn.gov.webdev_task.model.PessoaFisica;

@Data
public class ServidorRequestDTO {
    private int matricula;
    private String nome_social;
    private PessoaFisica pessoaFisica;

    public Servidor build() {
        Servidor s = new Servidor();
        s.setMatricula(this.matricula);
        s.setNome_social(this.nome_social);
        s.setPessoaFisica(this.pessoaFisica);
        return s;
    }
}
