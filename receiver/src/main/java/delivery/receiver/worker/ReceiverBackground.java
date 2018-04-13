/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.receiver.worker;

import delivery.receiver.repository.ReceiverRepositorySingleton;
import delivery.server.service.Server;
import delivery.server.service.ServerService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class ReceiverBackground implements Runnable {

    ReceiverRepositorySingleton repo;
    Server server;
    List<String> toRemove;
    
    public ReceiverBackground() {
        server = new ServerService().getServerImplPort();
        repo = ReceiverRepositorySingleton.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            if (repo.list().isEmpty()) {
                try {
                    Thread.sleep(5000);
                    continue;
                } catch (InterruptedException ex) {
                    System.out.println("an error occured in ReceiverBackgroun sleep: " + ex.getMessage());
                }
            }
            toRemove = new ArrayList<>(repo.list()); 
            toRemove.forEach((message) -> {
                forward(message);
            });
        }
    }

    public boolean forward(String message) {
        server.hello(message);
        return repo.remove(message);
    }
}
