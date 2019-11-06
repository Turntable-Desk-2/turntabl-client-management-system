package io.turntabl;

public class Client {
    private int id;
    private String name;
    private String address;
    private String telephone;
    private String email;
    private ClientLevel clientLevel;

    public Client(int id, String name, String address, String telephone, String email, ClientLevel clientLevel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.clientLevel = clientLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public ClientLevel getClientLevel() {
        return clientLevel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", clientLevel=" + clientLevel +
                '}';
    }
}
