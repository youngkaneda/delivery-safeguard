/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.sender.service;

import delivery.sender.repository.SenderRepositorySingleton;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "SenderService",
        endpointInterface = "delivery.sender.service.Sender"
)
public class SenderImpl implements Sender{

    SenderRepositorySingleton repo;
    
    public SenderImpl() {
        repo = SenderRepositorySingleton.getInstance();
    }
    
    @Override
    public void post(String message) throws RemoteException {
        repo.store(message);
    }
    
}
