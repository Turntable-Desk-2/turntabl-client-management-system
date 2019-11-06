package io.turntabl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientRegister {

    private List<Client> clients;

    public ClientRegister(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClientsByName(String name){
        return null;
    }

    public List<Client> getClientsLevel(ClientLevel level) {
        return clients.stream()
                .filter(client -> client.getClientLevel().equals(level))
                .collect(Collectors.toList());
    }

    public List <Client> getClientsById(int clientsId){
        return clients.stream()
                .filter(client -> client.getId() == clientsId)
                .collect(Collectors.toList());
    }


}
