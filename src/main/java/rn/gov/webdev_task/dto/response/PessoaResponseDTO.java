package rn.gov.webdev_task.dto.response;


import java.util.Date;

import lombok.Data;
import rn.gov.webdev_task.model.Pessoa;

@Data
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private Boolean pessoa_juridica;
    private String telefones;
    private Date data_exclusao;

public PessoaResponseDTO(Pessoa p){
    this.setId(p.getId());
    this.setNome(p.getNome());
    this.setPessoa_juridica(p.getPessoa_juridica());
    this.setTelefones(p.getTelefones());
    this.setData_exclusao(p.getData_exclusao());
}

}