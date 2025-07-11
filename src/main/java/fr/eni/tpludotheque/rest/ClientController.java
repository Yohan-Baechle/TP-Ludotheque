package fr.eni.tpludotheque.rest;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dto.AdresseDTO;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Integer id) {
        clientService.supprimerClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable("id") Integer id, @RequestBody ClientDTO clientDTO) {
        Client updatedClient = clientService.modifierClient(id, clientDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @PatchMapping("/{id}/adresse")
    public ResponseEntity<Client> modifierAdresseClient(@PathVariable Integer id, @RequestBody AdresseDTO adresseDTO) {
        Client updatedClient = clientService.modifierAdresseClient(id, adresseDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping("/recherche")
    public ResponseEntity<List<Client>> findClientsByNom(@RequestParam String prefix) {
        List<Client> clients = clientService.findClientsByNom(prefix);
        return ResponseEntity.ok(clients);
    }
}
