/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.receiver.service;

import delivery.receiver.repository.ReceiverRepositorySingleton;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "ReceiverService",
        endpointInterface = "delivery.receiver.service.Receiver"
)
public class ReceiverImpl implements Receiver{

    private ReceiverRepositorySingleton repo;
    
    public ReceiverImpl() {
        repo = ReceiverRepositorySingleton.getInstance();
    }
    
    @Override
    public void post(String message) throws RemoteException {
        repo.store(message);
    }
    
}
