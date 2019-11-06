package io.turntabl.controllers;

import io.turntabl.Client;
import io.turntabl.ClientLevel;
import io.turntabl.ClientRegister;
import jdk.vm.ci.code.Register;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NewClient {
    public void newClient(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("Address: ");
        String address = sc.nextLine();

        System.out.println("Telephone: ");
        String telephone = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        ClientRegister reg = new ClientRegister(Arrays.asList(new Client(1, name, address, telephone, email, ClientLevel.GOLD)));
        System.out.println("Client Added Successfully\n" + reg.getAllClients());

        try{
            File file = new File("out.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(new Client(1, name, address, telephone, email, ClientLevel.GOLD));
            pw.close();

        }catch (IOException e){
            System.out.println(e);
        }



    }

}
