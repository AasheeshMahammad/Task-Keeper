/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.task_keeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Aasheesh
 */
public class Model {
    public static void CreateProfile(String name, String password, Register form) throws IOException{
        String datapath = "Data\\"+name;
        String pass = datapath+"\\key.txt";
        String data = datapath+"\\data.txt";
        File file = new File(datapath);
        File key = new File(pass);
        File datafile = new File(data);
        if(!file.exists()){
            file.mkdirs();
            key.createNewFile();
            datafile.createNewFile();
            Model.register(name, password);
            form.dispose();
            new TaskList(name);
        } else {
            form.alertUser();
        }
    }
    
    public static void register(String name, String password) throws IOException{
        String datapath = "Data\\"+name;
        String profile = datapath+"\\key.txt";
        FileWriter writer = new FileWriter(profile);
        writer.write(password);
        writer.close();
    }
    public static String getData(String path) throws IOException,FileNotFoundException{
        FileReader reader = new FileReader(path);
        int ch = reader.read();
        String data = "";
        while(ch != -1){
            data += String.valueOf((char)ch);
            ch = reader.read();
        }
        reader.close();
        return data;
    }
    
    public static void modifyTasks(String name, Vector<String> TaskVector){
        String path = "Data\\"+ name + "\\data.txt";
        try{
            FileWriter writer = new FileWriter(path);
            String data = "";
            for(String task:TaskVector){
                data += task + "\n";
            }
            writer.write(data);
            writer.close();
        } catch(IOException ex){
            System.out.println("Error when accessing files");
        }
        
        
    }
    
    public static void checkDetails(String name, String password, Login form){
        String datapath = "Data\\"+name;
        String profile = datapath+"\\key.txt";
        String data = datapath +"\\data.txt";
        File prof = new File(datapath);
        if(!prof.exists()){
            form.alertUser("User does not exist!");
        }
        String key = "";
        try {
            key = Model.getData(profile);
        } catch (IOException ex) {
            System.out.println("Error when accessing files");
            return;
        }
        if(!key.equals(password)){
            form.alertUser("Incorrect Password!");
        } else{
            form.dispose();
            new TaskList(name);
        }
        
    }
    
}
