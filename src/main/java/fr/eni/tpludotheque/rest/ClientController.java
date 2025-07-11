package fr.eni.tpludotheque.rest;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dto.ClientDTO;
import fr.eni.tpludotheque.bll.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody ClientDTO clientDTO) {
        Client createdClient = clientService.ajouterClient(clientDTO);
        return ResponseEntity.ok(createdClient);
    }
}
