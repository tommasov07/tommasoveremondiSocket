import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int porta;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(int porta) {
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket attendi() {
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientSocket;
    }

    public void leggi() {
        try {
            InputStream inputStream = clientSocket.getInputStream();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("CLIENT:" + testo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrivi() {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println("SCRITTURA DEL SERVER");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void chiudi(){

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void termina(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
