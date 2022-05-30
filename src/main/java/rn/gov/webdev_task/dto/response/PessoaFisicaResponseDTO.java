package rn.gov.webdev_task.dto.response;
import java.util.Date;
// import java.util.List;
import java.util.List;

import lombok.Data;
import rn.gov.webdev_task.model.*;

@Data
public class PessoaFisicaResponseDTO {
    private Long pessoa_id;
    private Character sexo;
    private String cpf;
    private Date data_nascimento;
    private String tipo_sangue;
    private String nome_pai;
    private String nome_mae;  
    private Date data_exclusao;

    // Pessoa
    private String nome;
    private String telefones;
    private Endereco endereco;

    private List<Deficiencia> deficiencias;
    // TODO: Erro
    // private List<Servidor> servidores;

    public PessoaFisicaResponseDTO (PessoaFisica pf) {
        this.setPessoa_id(pf.getId());
        this.setSexo(pf.getSexo());
        this.setCpf(pf.getCpf());
        this.setData_nascimento(pf.getData_nascimento());
        this.setTipo_sangue(pf.getTipo_sangue());
        this.setNome_pai(pf.getNome_pai());
        this.setNome_mae(pf.getNome_mae());
        this.setData_exclusao(pf.getData_exclusao());

        // Pessoa
        this.setNome(pf.getNome());
        this.setTelefones(pf.getTelefones());
        this.setEndereco(pf.getEndereco());

        this.setDeficiencias(pf.getDeficiencias());
        // TODO: Erro
        // this.setServidores(pf.getServidores());
    }
}
