import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    private int porta;
    private ServerSocket serverSocket;

    public server(int porta) {
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            System.err.println("");
        }
        public Socket attendi() {
            try{
                ClientSocket = serverSocket .accept();
            } catch (IOException e ){
             throw new RuntimeException(e);
            } finally {

            }

        }
    }
}
