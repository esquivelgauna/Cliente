package cliente;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class PuertoC implements Runnable {
    
    PanelC MiPanel;
    int Puerto;
    Boolean Activo = true;
    ServerSocket Server;
    Socket Socket = null;
    ObjectInputStream Datos;

    PuertoC(int Puerto, PanelC Panel) {
        MiPanel = Panel;        
        this.Puerto = Puerto;
        try {
            Server = new ServerSocket(this.Puerto);
        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run() {
        while (Activo) {
            Texto("Esperando resultados", Color.green, Color.black);
            System.out.println("Esperando Respuesta");
            try {
                // ServerSocket me da el Socket
                Socket = Server.accept();
                Datos = new ObjectInputStream(Socket.getInputStream());
                HashMap Lista = (HashMap) Datos.readObject();
                System.out.println( Lista );
                Texto("Resultado recibido: " + Lista.get("Res") + "Desde:"+ Lista.get("Desde") , Color.magenta, Color.black);
                MiPanel.BtnPedir.setEnabled(true);
                this.close();
                // instancio un Thread
                //(new Cliente(s, this.view )).start();
            } catch (Exception ex) {
                //this.close();
                //ex.printStackTrace();
            }
        }
    }
    public void close() throws IOException {
        Server.close();
        Activo = false;
        System.out.println("Servidor Apagado");
    }
    
    public void Texto(String Msj, Color Fore, Color Back) {
        this.MiPanel.SMSJ.setText(Msj);
        this.MiPanel.SMSJ.setForeground(Fore);
        this.MiPanel.SMSJ.setBackground(Back);
    }

}
