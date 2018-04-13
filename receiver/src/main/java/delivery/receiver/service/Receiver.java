/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.receiver.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author juan
 */
@WebService(
        name = "Receiver"
)
public interface Receiver extends Remote {
    @WebMethod
    void post(String message) throws RemoteException;
}
