package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class PuertoC implements Runnable {

    int Puerto;
    Boolean Activo = true;
    ServerSocket Server;
    Socket Socket = null;
    ObjectInputStream Datos;

    PuertoC(int Puerto) {
        this.Puerto = Puerto;
        try {
            Server = new ServerSocket(this.Puerto);
        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (Activo) {
            
            System.out.println("Esperando Instruciones");
            try {
                // ServerSocket me da el Socket
                Socket = Server.accept();
                Datos = new ObjectInputStream(Socket.getInputStream());
                Datos.readObject();
                // instancio un Thread
                //(new Cliente(s, this.view )).start();
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }

    }

    public void close() throws IOException {
        Server.close();
        Activo = false;
        System.out.println("Servidor Apagado");
    }

}
