/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.receiver;

import delivery.receiver.service.ReceiverImpl;
import delivery.receiver.worker.ReceiverBackground;
import javax.xml.ws.Endpoint;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9091/Receiver", new ReceiverImpl());
        //
        ReceiverBackground rb = new ReceiverBackground();
        Thread t = new Thread(rb);
        t.start();
    }
}
