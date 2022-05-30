package rn.gov.webdev_task.dto.request;

import lombok.Data;
import rn.gov.webdev_task.model.Pessoa;

@Data
public class PessoaRequestDTO {
 private Long id;
 private String nome;
 private boolean pessoa_juridica;
 private String telefones;  
 
 public Pessoa build(){
     Pessoa p = new  Pessoa();
     p.setId(this.id);
     p.setNome(this.nome);
     p.setPessoa_juridica(this.pessoa_juridica);
     p.setTelefones(this.telefones);
     return p;
 }

 }


