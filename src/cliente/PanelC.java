package cliente;

import javax.swing.*;
import java.awt.*;

public class PanelC extends JFrame {
    protected JLabel Conexion;
    protected JLabel JLIP;
    protected JLabel JLConPuerto;
    
    protected JButton BtnDesconectar;
    protected JButton BtnConectar;
    protected JTextField JTConexionIP;
    protected JTextField JTConexionPuerto;
    
    protected JLabel MSJ;
    
    protected JLabel Servidor;
    protected JLabel JLFIbo;
    protected JLabel JLMiPuerto;
    protected JButton SBtnApagar;
    protected JButton BtnPedir;
    
    protected JTextField JTMiPuerto;
    protected JTextField Numeros;
    
    protected JLabel SMSJ;
    
    GridBagConstraints cons = new GridBagConstraints();

    public PanelC() {
        setBounds(100, 100, 400, 400);//Definir las dimensiones de la ventana
        setTitle("Cliente");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
        getContentPane().setLayout(new GridBagLayout());
        
        
        Conexion = new JLabel("Conexion:");
        Conexion.setForeground(Color.green);
        Conexion.setBackground(Color.black);
        Conexion.setOpaque(true);
        Conexion.setHorizontalAlignment(SwingConstants.CENTER);
        Conexion.setVerticalAlignment(SwingConstants.CENTER);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        cons.insets = new Insets(5,10,5, 10);
        cons.anchor = GridBagConstraints.LAST_LINE_END;
        cons.fill = GridBagConstraints.BOTH ;
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        getContentPane().add(Conexion, cons);
        
        
        JLIP = new JLabel("IP");
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JLIP, cons);
        
        JTConexionIP = new JTextField("127.0.0.1");
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JTConexionIP, cons);
        
        JLConPuerto = new JLabel("Puerto");
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JLConPuerto, cons);
        
        JTConexionPuerto = new JTextField("5432");
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JTConexionPuerto, cons);
        
        Servidor = new JLabel("Mi Canal:");
        Servidor.setForeground(Color.blue);
        Servidor.setBackground(Color.white);
        Servidor.setOpaque(true);
        Servidor.setHorizontalAlignment(SwingConstants.CENTER);
        Servidor.setVerticalAlignment(SwingConstants.CENTER);
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        getContentPane().add(Servidor, cons);
        
        JLMiPuerto = new JLabel("Mi Puerto:");
        cons.gridx = 0;
        cons.gridy = 7;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JLMiPuerto, cons);
        
        JTMiPuerto = new JTextField("5431");
        cons.gridx = 1;
        cons.gridy = 7;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JTMiPuerto, cons);
        
        JLFIbo = new JLabel("#Fibonacci:");
        cons.gridx = 0;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(JLFIbo, cons);
        
        Numeros = new JTextField("56556");
        cons.gridx = 1;
        cons.gridy = 9;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        getContentPane().add(Numeros, cons);
        
        JLabel JLPet = new JLabel("Mi Peticion");
        JLPet.setForeground(Color.green);
        JLPet.setBackground(Color.black);
        JLPet.setOpaque(true);
        JLPet.setHorizontalAlignment(SwingConstants.CENTER);
        JLPet.setVerticalAlignment(SwingConstants.CENTER);
        cons.gridx = 0;
        cons.gridy = 8;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        cons.insets = new Insets(5,10,5, 10);
        cons.anchor = GridBagConstraints.LAST_LINE_END;
        cons.fill = GridBagConstraints.BOTH ;
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        getContentPane().add(JLPet, cons);
        
        
        BtnPedir = new JButton("Pedir");
        cons.gridx = 0;
        cons.gridy = 10;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        getContentPane().add(BtnPedir, cons);
        
        SMSJ = new JLabel("En Espera");
        SMSJ.setForeground(Color.black);
        SMSJ.setBackground(Color.white);
        SMSJ.setOpaque(true);
        SMSJ.setHorizontalAlignment(SwingConstants.CENTER);
        SMSJ.setVerticalAlignment(SwingConstants.CENTER);
        cons.gridx = 0;
        cons.gridy = 11;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        getContentPane().add(SMSJ, cons);
        
        setVisible(true);
    }
    
    public void conectaControlador(  ControlC c  ){

        /*
        BtnDesconectar.addActionListener(c);
        BtnDesconectar.setActionCommand("Desconectar");
        BtnConectar.addActionListener(c);
        BtnConectar.setActionCommand("Conectar");*/
        
        BtnPedir.addActionListener(c);
        BtnPedir.setActionCommand("Pedir");
    }
}
