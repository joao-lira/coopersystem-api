package br.com.coopersystem.restapi.model;

import br.com.coopersystem.restapi.enuns.StRegistryActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clients")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Client.getClients",
                query = "SELECT c.id, c.client_name, client_cpf, MASK(c.client_cpf, '###.###.###-##') AS client_cpf_formatted, client_cep, MASK(c.client_cep, '#####-###') AS client_cep_formatted, client_logradouro, client_bairro, client_cidade, client_uf, client_complemento, c.st_active, c.st_registry_active, created, modified, DATE_FORMAT(c.created, '%d/%m/%Y %H:%i') AS created_formatted, DATE_FORMAT(c.modified, '%d/%m/%Y %H:%i') AS modified_formatted FROM clients c WHERE c.st_active = 1 ORDER BY c.client_name ASC",
                resultClass = Client.class
        )
})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client_name;

    private String client_cpf;

    private String client_cpf_formatted;

    private String client_cep;

    private String client_cep_formatted;

    private String client_logradouro;

    private String client_bairro;

    private String client_cidade;

    private String client_uf;

    private String client_complemento;

    private String st_active = "1";

    @Enumerated(EnumType.STRING)
    private StRegistryActive st_registry_active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String created_formatted = new String();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = new Date();

    private String  modified_formatted = new String();

}
