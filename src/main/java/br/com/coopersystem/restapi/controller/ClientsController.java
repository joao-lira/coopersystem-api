package br.com.coopersystem.restapi.controller;

import br.com.coopersystem.restapi.model.Client;
import br.com.coopersystem.restapi.repository.ClientsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clients"})
public class ClientsController {

    private ClientsRepository clientsRepository;

    ClientsController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @GetMapping
    public List findAll() {

        return clientsRepository.getClients();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Client> findById(@PathVariable long id) {
        return clientsRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientsRepository.save(client);
    }

    @PutMapping
    public ResponseEntity<Client> update(@PathVariable("id") long id, @RequestBody Client client) {
        return clientsRepository.findById(id)
                .map(record -> {
                    record.setClient_name(client.getClient_name());
                    Client updated = clientsRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return clientsRepository.findById(id)
                .map(record -> {
                    clientsRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
