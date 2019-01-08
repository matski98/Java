package serwer;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    static int numberOfThreads = 1;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        while(true){
            MultiThread multiThread=new MultiThread(serverSocket.accept()) ;
            executorService.submit(multiThread);
        }
    }
}
