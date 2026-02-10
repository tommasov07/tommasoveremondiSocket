import java.io.IOException;
import java.net.Socket;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client");
    }
}
