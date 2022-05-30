package rn.gov.webdev_task.dto.request;
import java.util.Date;
import java.util.List;

import lombok.Data;
import rn.gov.webdev_task.model.Deficiencia;
import rn.gov.webdev_task.model.Endereco;
import rn.gov.webdev_task.model.PessoaFisica;

@Data
public class PessoaFisicaRequestDTO {
    
    private long pessoa_id;
    private Character sexo;
    private String cpf;
    private Date data_nascimento;
    private String tipo_sangue;
    private String nome_pai;
    private String nome_mae;  

    // Pessoa
    private String nome;
    private String telefones;
    private Endereco endereco;

    private List<Deficiencia> deficiencias;

    public PessoaFisica build() {
        PessoaFisica pf = new PessoaFisica();
        pf.setId(this.pessoa_id);
        pf.setSexo(this.sexo);
        pf.setCpf(this.cpf);
        pf.setData_nascimento(this.data_nascimento);
        pf.setTipo_sangue(this.tipo_sangue);
        pf.setNome_pai(this.nome_pai);
        pf.setNome_mae(this.nome_mae);
        
        // Pessoa
        pf.setNome(this.nome);
        pf.setPessoa_juridica(false);
        pf.setTelefones(this.telefones);
        pf.setEndereco(this.endereco);

        pf.setDeficiencias(deficiencias);
        
        return pf;
    }
}
