package cliente;

public class Main  {
    public static void main(String[] args) throws Exception {
        PanelC MiPanel = new PanelC();
        ControlC MiServer = new ControlC(MiPanel);
        MiPanel.conectaControlador(MiServer);
    }
}
    