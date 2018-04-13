/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.receiver.repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class ReceiverRepositorySingleton {

    private static ReceiverRepositorySingleton instance;
    private List<String> messages;
    
    private ReceiverRepositorySingleton() {
        messages = new ArrayList<>();
    }
    
    public static ReceiverRepositorySingleton getInstance(){
        if(instance == null)
            return instance = new ReceiverRepositorySingleton();
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
