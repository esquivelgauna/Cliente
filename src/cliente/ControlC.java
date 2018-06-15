package cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import javax.swing.JOptionPane;

public class ControlC implements ActionListener {

    String IP;
    Boolean Peticion = false;
    Boolean Servidor = false;
    int Puetro;
    InfoC Datos;
    Timer timer;
    ConexionC MiConexion;
    PuertoC MiServidor;
    Thread MiHilo;
    protected PanelC view;

    ControlC(PanelC view) throws IOException {
        this.view = view;
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
            case "Pedir":
                if (Peticion == false) {
                    //Mi Puerto
                    int MiPuerto = Integer.valueOf(this.view.JTMiPuerto.getText());
                    MiServidor = new PuertoC(MiPuerto);
                    MiHilo = new Thread(MiServidor);
                    MiHilo.start();
                    //Conecion al servidor
                    String ConIP = this.view.JTConexionIP.getText();
                    int ConPuerto = Integer.valueOf(this.view.JTConexionPuerto.getText());
                    MiConexion = new ConexionC(ConIP, ConPuerto, this.view, this.view.Numeros.getText(), MiPuerto);
                    Peticion = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Peticion en proceso, espere...");
                }

                break;

            default:
                System.err.println("Comando no definido");
                break;
        }
    }
    public void ST(String Msj, Color Fore, Color Back) {
        this.view.SMSJ.setText(Msj);
        this.view.SMSJ.setForeground(Fore);
        this.view.SMSJ.setBackground(Back);
    }
}
