package cliente;

public class cliente  {
    public static void main(String[] args) throws Exception {
        Panel MiPanel = new Panel();
        Server MiServer = new Server(MiPanel);
        MiPanel.conectaControlador(MiServer);
    }

}
