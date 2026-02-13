import java.io.*;
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
    public void leggi(){
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
    public void scrivi() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println("SCRITTURA DEL SERVER");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void chiudi(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
