/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.sender.worker;

import delivery.receiver.service.Receiver;
import delivery.receiver.service.ReceiverService;
import delivery.sender.repository.SenderRepositorySingleton;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class SenderBackground implements Runnable {

    private SenderRepositorySingleton repo;
    private Receiver receiver;
    List<String> toRemove;

    public SenderBackground() {
        repo = SenderRepositorySingleton.getInstance();
        receiver = new ReceiverService().getReceiverImplPort();
    }

    @Override
    public void run() {
        while (true) {
            if (repo.list().isEmpty()) {
                try {
                    Thread.sleep(5000);
                    continue;
                } catch (InterruptedException ex) {
                    System.out.println("an error occured in SenderBackgroun sleep: " + ex.getMessage());
                }
            }
            toRemove = new ArrayList<>(repo.list());
            toRemove.forEach((message) -> {
                forget(message);
            });
        }
    }

    public boolean forget(String message) {
        receiver.post(message);
        return repo.remove(message);
    }
}
