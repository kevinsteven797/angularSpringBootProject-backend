package com.managment.client.com.controller;

import com.managment.client.com.exceptions.ResourceNotFoundException;
import com.managment.client.com.model.Client;
import com.managment.client.com.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping("/clients")
    public List<Client> listClients(){
        return repository.findAll();
    }

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        return repository.save(client);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado ID:"+id));
        return ResponseEntity.ok(client);
    }

    @PutMapping("clients/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,@RequestBody Client detailClient){
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado ID:"+id));
        client.setName(detailClient.getName());
        client.setPhone(detailClient.getPhone());
        client.setEmail(detailClient.getEmail());
        client.setStartDate(detailClient.getStartDate());
        client.setEndDate(detailClient.getEndDate());
        client.setNickName(detailClient.getNickName());

        Client clientAct = repository.save(client);

        return ResponseEntity.ok(clientAct);
    }

}
