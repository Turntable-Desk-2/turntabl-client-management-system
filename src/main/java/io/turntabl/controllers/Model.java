package io.turntabl.controllers;

import io.turntabl.Client;
import io.turntabl.ClientLevel;
import io.turntabl.ClientRegister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Model {
    public static void indexPage(){
        boolean q = true;
        while(q) {
        System.out.println("\n=====TURNTABL CLIENT MANAGEMENT SYSTEM=====\nPlease Choose an Option by Number");
        System.out.println("1. Add new Client \n2. Display All Clients \n3. Update a Client Info \n4. Remove a Client \n5. Search for Client \n0. Quit App");
        System.out.println("Enter Option here: ");
        Scanner sc = new Scanner(System.in);
        Integer res = sc.nextInt();

            switch (res) {
                case 0:
                    System.out.println("Quiting Application...");
                    q = false;
                    break;
                case 1:
                    System.out.println("Add new CLient Details");
                    NewClient.newClient();
                    break;
                case 2:
                    getAllData();
                    break;
                case 3:
                    getAllData();
                    System.out.println("Enter id of Client you want to Update: ");
                    Integer idToUpdate = sc.nextInt();
                    System.out.println("CLIENT:\n" + searchByID(idToUpdate));
                    System.out.println("What do you want to Update?\n1. Name\n2. Address\n3. Telephone\n4. Email\n5. Level");
                    Integer op = sc.nextInt();
                    switch (op){
                        case 1:
                             break;
                    }
                    break;
                case 4:
                    System.out.println("Enter client Id to Remove: ");
                    String idtoRemove = sc.next();
                    PersistData.removeClient(idtoRemove);
                    System.out.println("\n-------------------------------\nClient Removed Successfully\n----------------------------\n");
                    break;
                case 5:
                    System.out.println("=====Search for Clients By: \n1. Name\n2. Level\n3. ID");
                    Integer input = sc.nextInt();
                    Integer level = null;
                    switch (input){
                        case 1:
                            System.out.println("Enter Name: ");
                            String name = sc.next();
                            switch (name){
                                case " ":
                                    System.out.println("Enter client name");
                                    break;
                                default:
                                    System.out.println(searchByName(name));
                            }
                            break;
                        case 2:
                            System.out.println("Enter Level: \n1. Gold\n2. Premium\n3. Platinum\n");
                            Integer in = sc.nextInt();
                            switch (in){
                                case 1:
                                    System.out.println(searchByLevel(ClientLevel.GOLD));
                                    break;
                                case 2:
                                    System.out.println(searchByLevel(ClientLevel.PREMIUM));
                                    break;
                                case 3:
                                    System.out.println(searchByLevel(ClientLevel.PLATINUM));
                                    break;
                                default:
                                    System.out.println("Enter Valid Client Level");
                            }
                            break;
                        case 3:
                            System.out.println("Enter Id: ");
                            int id = sc.nextInt();
                            System.out.println(searchByID(id));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Please Enter Valid Number");
            }
        }
    }

    public static List<Client> searchByLevel(ClientLevel lvl){
        ClientRegister reg = new ClientRegister(clientList());
        return reg.getClientsLevel(lvl);
    }

    public static List<Client> searchByName(String name){
        ClientRegister reg = new ClientRegister(clientList());
        return reg.getClientsByName(name);
    }

    public static List<Client> searchByID(int id){
        ClientRegister reg = new ClientRegister(clientList());
        return reg.getClientsById(id);
    }

    public static List<Client> clientList(){
        List<Client> clients = new ArrayList<>();

        for (String data : PersistData.readFile()){
            String[] split = data.split("---");
            clients.add(new Client(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4], ClientLevel.valueOf(split[5])));
        }
        return clients;
    }

    public static void getAllData(){
        System.out.println("=====All Clients=====");
        for(String client : PersistData.readFile()){
            System.out.println(client);
        }
    }


}
