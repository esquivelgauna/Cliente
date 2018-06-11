package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String IP = "127.0.0.1";
    int Puetro = 5432;
    Info Datos;
    Server() throws IOException {
        //Conexion();
        Inicio();
    }
    
    public void Inicio() throws IOException {
        
        Socket s = null;
        ServerSocket ss = new ServerSocket(5430);
        while (true) {
            Conexion();
            try {
                // ServerSocket me da el Socket
                //s = ss.accept();
                // instancio un Thread
                //(new Cliente(s, this.view )).start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Conexion() throws IOException {
        ObjectOutputStream DDatos = null;
        Socket s = null;

        try {
            s = new Socket(IP, Puetro);
            DDatos = new ObjectOutputStream(s.getOutputStream());
            //System.out.println(Datos);
            Datos = new Info();
            DDatos.writeObject(Datos.PC());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
            System.out.println("Conexion cerrada!");
        }

    }
}
