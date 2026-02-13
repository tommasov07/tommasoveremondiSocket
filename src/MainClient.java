public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("client1");
        client.connetti("localhost", 12345);
        client.leggi();
        client.scrivi();
        client.chiudi();
    }
}
