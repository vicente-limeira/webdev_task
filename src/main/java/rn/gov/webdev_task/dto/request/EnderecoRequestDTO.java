package rn.gov.webdev_task.dto.request;
import lombok.Data;
import rn.gov.webdev_task.model.Endereco;

@Data
public class EnderecoRequestDTO {
    private long id;
    private String bairro;
    private String tipo_logradouro;
    private String logradouro;
    private String complemento;
    private String numero;
    private String cep;
    private double latidute;
    private double longitude;

    public Endereco build() {
        Endereco e = new Endereco();
        e.setId(this.id);                   // new
        e.setBairro(this.bairro);
        e.setTipo_logradouro(this.tipo_logradouro);
        e.setLogradouro(this.logradouro);
        e.setComplemento(this.complemento);
        e.setNumero(this.numero);
        e.setCep(this.cep);
        e.setLatidute(this.latidute);
        e.setLongitude(this.longitude);
        return e;
    }
}
