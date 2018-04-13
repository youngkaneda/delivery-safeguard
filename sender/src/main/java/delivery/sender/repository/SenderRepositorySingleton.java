/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.sender.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author juan
 */
public class SenderRepositorySingleton {

    private static SenderRepositorySingleton instance;
    private List<String> messages;
    
    private SenderRepositorySingleton() {
        messages = new ArrayList<>();
    }
    
    public static SenderRepositorySingleton getInstance(){
        if(instance == null)
            return instance = new SenderRepositorySingleton();
        else
            return instance;
    }
    
    public boolean store(String message) {
        return messages.add(message);
    }
    
    public List<String> list() {
        return messages;
    }
    
    public boolean remove(String message) {
        return messages.remove(message);
    }
}
