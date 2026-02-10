import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            //System.err.println("");
            e.printStackTrace();
        }

    }

    public Socket attendi() {
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return clientSocket;
    }

    public void leggi(){
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
}
