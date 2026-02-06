public class client {
    private String nome;
    private String color;
    private Socket socket;

    public client(String nome) {
        this.nome = nome;
    }
    public int connetti(String nomeServer, int portaServer){
        socket = new Socket (nomeServer, portaServer);
    }
}
