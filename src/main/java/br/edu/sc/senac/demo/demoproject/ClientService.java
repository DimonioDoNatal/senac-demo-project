package br.edu.sc.senac.demo.demoproject;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	private final ClientController clientController;

	ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}
	// private List<ClientDTO> clients = new ArrayList<>();

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return this.clientController.getAllClients();
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<ClientDTO> getClient(@PathVariable int id) {
		if (this.clientController.getClient(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ClientDTO client = this.clientController.getClient(id);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id) {
		int index = id.intValue();
		if (this.clientController.removeClient(index) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ClientDTO client = this.clientController.removeClient(index);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		return this.clientController.insertClient(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> uptadeClient(@PathVariable int id, @RequestBody ClientDTO updatedClient) {
		if (this.clientController.uptadeClient(id, updatedClient) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ClientDTO oldClient = this.clientController.uptadeClient(id, updatedClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
}
