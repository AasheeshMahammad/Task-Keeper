/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.task_keeper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Aasheesh
 */
public class ProfileController {
    public static void CreateProfile(String name, String password, Register form) throws IOException{
        Model.CreateProfile(name, password, form);
    }
    
    public static String getData(String path) throws IOException,FileNotFoundException{
        String data = Model.getData(path);
        return data;
    }
    
    public static void modifyTasks(String name, Vector<String> TaskVector){
        Model.modifyTasks(name, TaskVector);
    }
    
    public static void checkDetails(String name, String password, Login form){
        Model.checkDetails(name, password, form);
        
    }
    
}
