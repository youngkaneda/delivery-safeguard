/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.client;

import delivery.sender.service.Sender;
import delivery.sender.service.SenderService;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        SenderService proxy = new SenderService();
        Sender sender = proxy.getSenderImplPort();
        sender.post("my final message 2 you");
    }
}
