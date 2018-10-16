package com.tianhong.withoutNetty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Server(int port){
        try{
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功,端口: "+port);
        }  catch (IOException e) {
            System.out.println("服务端启动失败");
        }
    }

    public void start(){
        // 不希望创建端口监听server程序阻塞server boot主线程
         new Thread(new Runnable() {
             public void run() {
                 doStart();
             }
         }).start();
    }

    public void doStart(){
        while(true){
            try{
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }
    }
}
