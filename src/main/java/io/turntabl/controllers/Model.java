package io.turntabl.controllers;

import java.util.Scanner;

public class Model {
    public static void indexPage(){
        System.out.println("=====TURNTABL CLIENT MANAGEMENT SYSTEM=====\nPlease Choose an Option by Number");
        System.out.println("1. Add new Client \n2. Display All Clients \n3. Update a Client Info \n4. Remove a Client \n5. Search for Client \n0. Quit App");
        System.out.println("Enter Option here: ");
        Scanner sc = new Scanner(System.in);
        Integer res = sc.nextInt();

        boolean q = true;

        while(q) {
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
                    break;
                case 3:
                    System.out.println("Update Client Info");
                    break;
                case 4:
                    System.out.println("Remove Client");
                case 5:
                    System.out.println("Search for Client");
                    break;
                default:
                    System.out.println("Please Enter Valid Number");
            }
        }
    }
}
