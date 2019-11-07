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
        return clients.stream().filter(client -> client.getName() == name)
                .collect(Collectors.toList());
    }

    public List<Client> getClientsLevel(ClientLevel level){
        return null;
    }

}



