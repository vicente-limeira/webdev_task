package rn.gov.webdev_task.dto.response;

import lombok.Data;
import rn.gov.webdev_task.model.PessoaJuridica;
import rn.gov.webdev_task.model.Endereco;

@Data
public class PessoaJuridicaResponseDTO {

    private Long id;
    private String razao_social;
    private String cnpj;  

    // Pessoa
    private String nome;
    private String telefones;
    private Endereco endereco;

    
    public PessoaJuridicaResponseDTO (PessoaJuridica pj) {
        this.setId(pj.getId());
        this.setRazao_social(pj.getRazao_social());
        this.setCnpj(pj.getCnpj());

        // Pessoa
        this.setNome(pj.getNome());
        this.setTelefones(pj.getTelefones());
        this.setEndereco(pj.getEndereco());
    }
}
