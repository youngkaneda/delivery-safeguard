/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.server;

import delivery.server.service.ServerImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author juan
 */
public class Loader {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/Server", new ServerImpl());
    }
}
