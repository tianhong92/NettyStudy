package com.tianhong.withoutNetty;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("客户端启动成功！");
                while(true){
                    try{
                        String message = "Hello World";
                        System.out.println("客户端发送数据: "+message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (IOException e) {
                        System.out.println("写数据出错！");
                    }
                    sleep();
                }
            }
        }).start();
    }

    private static void sleep(){
        try{
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
