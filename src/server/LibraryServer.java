package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CinemaServer {
    public static void main(String[] args){
        try{
            int PORT = 27500;
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер работает на порту" + PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Соединение установлено");
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
