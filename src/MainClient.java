public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("client1");
        client.connetti("localhost", 12345);
        int esci = 0;
        while (esci == 0) {
            esci = client.scrivi();
            client.leggi();
        }
        client.chiudi();
    }
}
