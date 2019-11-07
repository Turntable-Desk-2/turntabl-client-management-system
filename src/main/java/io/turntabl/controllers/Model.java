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
                    System.out.println("=====All Clients=====");
                    for(String client : PersistData.readFile()){
                        System.out.println(client);
                    }
                    break;
                case 3:
                    System.out.println("Update Client Info");
                    break;
                case 4:
                    System.out.println("Remove Client");
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
}