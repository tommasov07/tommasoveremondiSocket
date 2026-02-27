public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(12345);
        server.attendi();
        int esci = 0;
        while(esci == 0){
            server.leggi();
            esci =server.scrivi();
        }
         server.chiudi();
         server.termina();
    }
}
