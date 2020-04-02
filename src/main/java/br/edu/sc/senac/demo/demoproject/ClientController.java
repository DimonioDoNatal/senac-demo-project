package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	private List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return this.clients;
	}

	Long insertClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}
	
	ClientDTO getClient(int id) {
		ClientDTO client = clients.get(id);
		return client;
	}

}
