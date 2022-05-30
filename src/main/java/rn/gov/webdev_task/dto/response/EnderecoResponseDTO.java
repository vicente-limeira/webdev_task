package rn.gov.webdev_task.dto.response;
import java.util.Date;

import lombok.Data;
import rn.gov.webdev_task.model.Endereco;

@Data
public class EnderecoResponseDTO {
    private long id;
    private String bairro;
    private String tipo_logradouro;
    private String logradouro;
    private String complemento;
    private String numero;
    private String cep;
    private double latidute;
    private double longitude;
    private Date data_exclusao;

    public EnderecoResponseDTO (Endereco e) {
        this.setId(e.getId());
        this.setBairro(e.getBairro());
        this.setBairro(e.getBairro());
        this.setTipo_logradouro(e.getTipo_logradouro());
        this.setLogradouro(e.getLogradouro());
        this.setComplemento(e.getComplemento());
        this.setNumero(e.getNumero());
        this.setCep(e.getCep());
        this.setLatidute(e.getLatidute());
        this.setLongitude(e.getLongitude());
        this.setData_exclusao(e.getData_exclusao());
    }    
}
