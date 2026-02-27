import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;
    public Client(String nome) {
        this.nome = nome;
    }
    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore= colore;
    }
    public void connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket (nomeServer, portaServer);
        } catch (ConnectException e){
            System.err.println("ERROREE!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client");

    }
    public void leggi(){
       if (socket!= null) {
           try {
               InputStream inputStream = socket.getInputStream();

               BufferedReader br = new BufferedReader(
                       new InputStreamReader(inputStream));
               String testo = br.readLine();
               System.out.println("SERVER:" + testo);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
    public int scrivi() {
        String messaggio = "";
        if (socket!= null) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(outputStream);
                Scanner scanner= new Scanner(System.in);
                messaggio= scanner.nextLine();
                pw.println(messaggio);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messaggio.equalsIgnoreCase("esci") ? 1 : 0;
    }
    public void chiudi(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
