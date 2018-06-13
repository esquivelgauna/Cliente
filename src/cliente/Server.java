package cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.SigarException;

public class Server implements ActionListener {

    String IP;
    Boolean Conectado = false;
    int Puetro;
    Info Datos;
    Timer timer;
    Conexion MiConexion;
    protected Panel view;

    Server(Panel view) throws IOException {
        this.view = view;
    }

    public void Inicio() throws IOException {

        Socket s = null;
        ServerSocket ss = new ServerSocket(5430);
        while (true) {
            System.out.println("Esperando Instruciones");

            try {
                // ServerSocket me da el Socket
                s = ss.accept();
                // instancio un Thread
                //(new Cliente(s, this.view )).start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Boolean Test(String IP, int Puerto) throws IOException {
        Socket s = null;
        s = new Socket(IP, Puerto);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //COMANDO EJECTUADO
        String comando = arg0.getActionCommand();

        switch (comando) {
            case "Conectar":
                if ( Conectado == false) {
                    Texto("Conectando..", Color.green, Color.red);
                    
                    String IP = this.view.IP.getText();
                    int Puerto = Integer.valueOf(this.view.Puerto.getText());
                    System.out.println("Conectar a la IP:" + IP + " Puerto:" + Puerto);
                    Boolean Con;
                    try {
                        Con = Test(IP, Puerto);
                    } catch (IOException ex) {
                        Con = false;
                    }
                    if (Con) {
                        Texto("Conexion exitosa..", Color.green, Color.black);
                        MiConexion = new Conexion(IP, Puerto);
                        timer = new Timer();
                        timer.scheduleAtFixedRate(MiConexion, 0, 1000);
                        Conectado = true;
                    } else {
                        this.view.MSJ.setText("Error al conectar..");
                        this.view.MSJ.setForeground(Color.red);
                    }
                } else {
                    System.out.println("Duplicado evitado");
                    Texto("Tu ya estas conectado", Color.red, Color.black);
                    Texto("Conecatdo", Color.green, Color.black);
                }
                break;

            case "Desconectar":
                System.out.println("Desconectar");
                Texto("Desconectado", Color.blue, Color.gray);
                Conectado = false;
                timer.purge();
                timer.cancel();
                break;

            case "MODIFICAR":
                System.out.print("Comando MODIFICAR");
                break;

            default:
                System.err.println("Comando no definido");
                break;
        }
        //limpiar el formulario
        //limpia();

        //refrescar la tabla
        //cargarTabla();
    }

    public void Texto(String Msj, Color Fore, Color Back) {
        this.view.MSJ.setText(Msj);
        this.view.MSJ.setForeground(Fore);
        this.view.MSJ.setBackground(Back);
    }

}
