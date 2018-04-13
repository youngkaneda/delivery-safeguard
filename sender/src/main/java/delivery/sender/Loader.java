/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.sender;

import delivery.sender.service.SenderImpl;
import delivery.sender.worker.SenderBackground;
import javax.xml.ws.Endpoint;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9092/Sender", new SenderImpl());
        //
        SenderBackground sb = new SenderBackground();
        Thread t = new Thread(sb);
        t.start();
    }
}
