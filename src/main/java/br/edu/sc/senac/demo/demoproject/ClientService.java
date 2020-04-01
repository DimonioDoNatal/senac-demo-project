package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
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
	public static ArrayList<ClientDTO> list = new ArrayList<ClientDTO>();

	@GetMapping("/list")

	public List<ClientDTO> list() {
		;
		return list;
	}

	@PostMapping("/add-default")
	public List<ClientDTO> addDefault() {

		ClientDTO client1 = new ClientDTO("Marcelo", "21/10/2003", "Marcelo@gmail.com");
		list.add(0, client1);

		ClientDTO client2 = new ClientDTO("Carlos", "14/11/2001", "Carlos@gmail.com");
		list.add(1, client2);

		ClientDTO client3 = new ClientDTO("José", "02/09/2003", "Jose@gmail.com");
		list.add(2, client3);

		return list;

	}

	@PostMapping("/register")
	public int registerClient(@RequestBody final ClientDTO client) {
		list().add(client);
		return list().size();

	}

	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> getClient(@PathVariable final int id) {

		if (id >= list().size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ClientDTO client = list().get(id);
		return new ResponseEntity<>(client, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable final int id) {
		if (id >= list.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ClientDTO client = list.remove(id);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> uptadeClient(@PathVariable final int id, @RequestBody ClientDTO uptadeClient) {
		if (id >= list.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ClientDTO oldClient = list.remove(id);
		list().add(id, uptadeClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
	

}
