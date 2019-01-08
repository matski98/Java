package serwer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


class MultiThread implements Runnable{
    Socket clientSocket = null;

    public MultiThread(Socket s){
        clientSocket =s;
    }
    public void run(){
        try {
            Baza baza = new Baza();
            if(!baza.connect()){
                System.out.println("nie udalo sie polaczyc");
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            baza.connect();
            while ((inputLine = in.readLine()) != null) {
                baza.add(inputLine);
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}