package com.tianhong.withoutNetty;

public class ServerBoot {
    public static void main(String[] args) {
        Server server = new Server(8000);
        server.start();
    }
}
