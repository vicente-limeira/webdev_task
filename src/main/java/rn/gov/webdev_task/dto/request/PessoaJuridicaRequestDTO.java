package rn.gov.webdev_task.dto.request;

import lombok.Data;
import rn.gov.webdev_task.model.*;

@Data
public class PessoaJuridicaRequestDTO {
    
    private long pessoa_id;
    private String razao_social;
    private String cnpj;  

    // Pessoa
    private String nome;
    private String telefones;
    private Endereco endereco;

    public PessoaJuridica build() {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setId(this.pessoa_id);
        pj.setRazao_social(this.razao_social);
        pj.setCnpj(this.cnpj);
        
        // Pessoa
        pj.setNome(this.nome);
        pj.setPessoa_juridica(true);
        pj.setTelefones(this.telefones);
        pj.setEndereco(this.endereco);
        
        return pj;
    }
}
