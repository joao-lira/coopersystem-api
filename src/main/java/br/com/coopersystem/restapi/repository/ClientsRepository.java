package br.com.coopersystem.restapi.repository;

import br.com.coopersystem.restapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Client, Long> {

    List<Client> getClients();
}
