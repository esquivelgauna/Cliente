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
    Boolean Servidor = false;
    int Puetro;
    InfoC Datos;
    Timer timer;
    ConexionC Conexion;
    PuertoC MiPuerto;
    Thread MiHilo;
    protected PanelC Panel;

    ControlC(PanelC view) throws IOException {
        this.Panel = view;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //COMANDO EJECTUADO
        String comando = arg0.getActionCommand();

        switch (comando) {
            case "Pedir":
                if (Servidor == false) {
                    //Mi Puerto
                    int Puerto = Integer.valueOf(this.Panel.JTMiPuerto.getText());
                    /*this.MiPuerto = new PuertoC(Puerto, this.Panel);
                    MiHilo = new Thread(this.MiPuerto);
                    MiHilo.start();*/
                    //Conecion al servidor
                    String ConIP = this.Panel.JTConexionIP.getText();
                    int ConPuerto = Integer.valueOf(this.Panel.JTConexionPuerto.getText());
                    
                    Conexion = new ConexionC(ConIP, ConPuerto, this.Panel, this.Panel.Peticion.getText(), Puerto);
                    Conexion.run();
                    //Servidor= true;
                    
                    //Peticion = true;
                } else {
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Peticion en proceso, espere...");
                }

                break;

            default:
                System.err.println("Comando no definido");
                break;
        }
    }

    public void ST(String Msj, Color Fore, Color Back) {
        this.Panel.SMSJ.setText(Msj);
        this.Panel.SMSJ.setForeground(Fore);
        this.Panel.SMSJ.setBackground(Back);
    }
}
