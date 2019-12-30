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
@Table(name = "clients_emails")
public class ClientEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    private String email;

    private String st_active = "1";

    @Enumerated(EnumType.STRING)
    private StRegistryActive st_registry_active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
}
