package client;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.util.*;
public class CinemaClient {
    public static void main(String[] args){
        int SERVER_PORT = 16748;
        try {
            Socket socket = new Socket("localhost", SERVER_PORT);
            System.out.println("Подключен к серверу по порту " + SERVER_PORT);
            TicketsPerMonth inputData = generateData();
            System.out.println("tickets: " + inputData.getTicketsByDate());
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            writer.writeObject(inputData);
            writer.flush();
            ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
            var response = reader.readObject();
            System.out.println("Ответ: " + response);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static TicketsPerMonth generateData(){
        Map<LocalDate, Integer> ticketsByDate = new HashMap<>();
        for(int i = 1; i <= 30; i++){
            LocalDate movieDate = LocalDate.of(2023,11, i);
            int dailyTickets = new Random().nextInt(100);
            ticketsByDate.put(movieDate, dailyTickets);
        }
        return new TicketsPerMonth(ticketsByDate);
    }
}
