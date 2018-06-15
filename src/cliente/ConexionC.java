package cliente;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionC {
    
    ObjectOutputStream Sender;
    Socket Socket = null;
    String IP;
    int Puerto;
    int MiPuerto;
    String Fiboo;
    protected PanelC view;
    HashMap<String, String> Datos = new HashMap<>();

    ConexionC(String IP, int Puerto,PanelC view, String Fibo, int p) {
        this.view = view;
        this.IP = IP;
        this.Puerto = Puerto;
        Fiboo = Fibo;
        this.MiPuerto = p;
        run();
    }

    public void run() {
        try {
            Socket = new Socket(IP, Puerto);
            Sender = new ObjectOutputStream(Socket.getOutputStream());
            //System.out.println(Datos);
            InetAddress ip = InetAddress.getLocalHost();
            String IPA = ip.getHostAddress();
            Datos.put("IP", (IPA));
            Datos.put("PUERTO", ( String.valueOf(MiPuerto) ));
            Datos.put("Fiboo", (Fiboo));
            Datos.put("Tipo", "Cliente" );
            //Datos = new Info();
            Sender.writeObject(Datos);

            Texto("Se envio la peticion", Color.green, Color.black);
            System.out.println("Se enviaron datos");

        } catch (IOException ex) {
            Texto("No se pudo conectar al servidor ", Color.red, Color.black);
            System.out.println("No se conecto");
            
            
        } finally {
            if (Socket != null) {
                try {
                    Socket.close();
                } catch (IOException ex) {
                    //Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Conexion cerrada");
            System.out.println("Esperando....");
            Texto("Esperando......", Color.orange, Color.black);
        }
    }

    public void Texto(String Msj, Color Fore, Color Back) {
        this.view.SMSJ.setText(Msj);
        this.view.SMSJ.setForeground(Fore);
        this.view.SMSJ.setBackground(Back);
    }

}
