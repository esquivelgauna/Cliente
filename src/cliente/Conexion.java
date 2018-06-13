package cliente;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.SigarException;

public class Conexion extends TimerTask {
    
    ObjectOutputStream DDatos;
    Info Datos;
    Socket s = null;
    String IP;
    int Puerto;
    Conexion(String IP, int Puerto) {
        this.IP = IP;
        this.Puerto = Puerto;
    }
    @Override
    public void run( ) {
        try {
            s = new Socket(IP, Puerto);
            DDatos = new ObjectOutputStream(s.getOutputStream());
            //System.out.println(Datos);
            Datos = new Info();
            DDatos.writeObject(Datos.PC());
            System.out.println("Se enviaron datos");
        } catch (IOException | SigarException ex) {
            System.out.println("No se conecto");
            //ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Conexion cerrada");
            System.out.println("Conectando....");
        }
    }
    

}
