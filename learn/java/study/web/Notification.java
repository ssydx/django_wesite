package study.web;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class Notification extends Thread {
    String weather = "节目预报：八点有大型晚会，请收听";
    int port = 9898;
    InetAddress iAddress = null;
    MulticastSocket socket = null;
    Notification() {
        try {
            iAddress = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.setTimeToLive(1);
            NetworkInterface netIf = NetworkInterface.getByName("eth0");
            if (netIf == null) {
                netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            }
            socket.joinGroup(new InetSocketAddress(iAddress, port), netIf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        while (true) {
            DatagramPacket packet = null;
            byte[] data = weather.getBytes();
            packet = new DatagramPacket(data, data.length, iAddress, port);
            try {
                socket.send(packet);
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Notification w = new Notification();
        w.start();
    }
}
