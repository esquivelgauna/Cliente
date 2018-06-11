package cliente;

import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame {
    
    public Panel() {
        super("Conexion");
        setBounds(100, 100, 400, 150);
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        JLabel JLTitulo = new JLabel("Ingresa tu IP");
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        // El area de texto debe estirarse en ambos sentidos.
        //cons.anchor = GridBagConstraints.NORTHWEST;
        cons.fill = GridBagConstraints.HORIZONTAL ;
        //constraints.insets=new Insets(10,5,10,5);
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        this.getContentPane().add(JLTitulo, cons);
        
        JTextField IP = new JTextField("Ingresa tu IP");
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        //constraints.weightx = 1.0;
        this.getContentPane().add(IP, cons);
        
        JLabel JLPuerto = new JLabel("Puerto");
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        this.getContentPane().add(JLPuerto, cons);
        
        JTextField JTPuerto = new JTextField("Puerto");
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        this.getContentPane().add(JTPuerto, cons);
        
        
        
        JButton BtnConectar = new JButton("Conectar");
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        this.getContentPane().add(BtnConectar, cons);
        
        
        JButton BtnDesconectar = new JButton("Conectar");
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        this.getContentPane().add(BtnDesconectar, cons);
        
        this.setVisible(true);
    }
}
