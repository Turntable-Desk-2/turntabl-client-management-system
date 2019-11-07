package io.turntabl.controllers;

import io.turntabl.*;

import java.io.*;
import java.util.Scanner;

public class PersistData {
    public static void writeFile(int id, String name, String address, String telephone, String email, ClientLevel level) {
        try {
            File file = new File("./store/store.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(id + "---" + name + "---" + address + "---" + telephone + "---" + email + "---" + level + "\n");
            pw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(){
        try {
            File file = new File("./store/store.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
    }
}
