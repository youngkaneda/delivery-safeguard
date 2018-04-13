/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.server.service;

import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "ServerService",
        endpointInterface = "delivery.server.service.Server"
)
public class ServerImpl implements Server{
    
    @Override
    public void hello(String message) throws RemoteException {
        System.out.println("proccessed: " + message);
    }
    
}
