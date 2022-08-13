package co.edu.utp.misiontic2022.c2.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import co.edu.utp.misiontic2022.c2.controller.RequerimientoController;
import co.edu.utp.misiontic2022.c2.model.vo.AsesorPorCiudadVo;
import co.edu.utp.misiontic2022.c2.model.vo.CompraPorProveedorVo;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoCasaCampestre;

public class RequerimientoView extends JFrame{
    
    public static final RequerimientoController controlador = new RequerimientoController();

    private static final long serialVersionUID = 1L;

    private JPanel contenPane;
    private JTextArea textArea;

    public RequerimientoView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 800, 650); // modificar

        contenPane = new JPanel();
        contenPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // revisar
        setContentPane(contenPane);
        contenPane.setLayout(null);

        JLabel lbTitulo = new JLabel("Solucion Reto 5");
        lbTitulo.setBounds(28, 6, 161, 16); //modificar el 161
        contenPane.add(lbTitulo);

        JScrollPane scrollPane = new JScrollPane(); // area de texto
        scrollPane.setBounds(28, 60, 747, 455);
        contenPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Consulta 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
               consulta1();
            }
        });
        btnConsulta1.setBounds(28, 537, 133, 29);
        contenPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Consulta 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                consulta2();
            }
        });
        btnConsulta2.setBounds(164, 537, 133, 29);
        contenPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Consulta 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                consulta3();
            }
        });
        btnConsulta3.setBounds(302, 537, 133, 29);
        contenPane.add(btnConsulta3);

    }

    public void consulta1(){
        try {
            ArrayList<AsesorPorCiudadVo> asesores = controlador.consultPorCiudad();//revisar
            String salida =" Asesor Por Ciudad  \n\nId Lider \t Nombre \t Primer Apellido \t Residencia\n\n";
            for (AsesorPorCiudadVo asesor: asesores){
                salida += asesor.getIdLider() + " \t ";
                salida += asesor.getNombre() + " \t ";
                salida += asesor.getPrimerApellido() + " \t\t ";
                salida += asesor.getCiudadResidencia() + " \n ";
            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.err.println("Las cosas no estan saliendo como se esperaba " + e.getMessage());
        }
    }

    public void consulta2(){
        try {
            ArrayList<ProyectoCasaCampestre> casas = controlador.consulProyectoCasaCampestre();
            String salida = " Proyecto Casa Campestre \n\nID Proyecto \t Constructora \t\t Habitaciones \t Ciudad \n\n";
            for(ProyectoCasaCampestre casa: casas){
                salida += casa.getIdProyecto() + "\t";
                salida += casa.getConstructora();
                if (casa.getConstructora().length() <= 11) {
                    salida += " \t\t ";
                } else{
                    salida += " \t ";
                }
                salida += casa.getNumeroHabitaciones() + " \t ";
                salida += casa.getCiudad() + "\n";
            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.err.println("Las cosas no estan saliendo como se esperaba " + e.getMessage());
        }
    }

    public void consulta3(){
        try{
            ArrayList<CompraPorProveedorVo> compras = controlador.compraPorProveedor();
            String salida =" Compras por Proveedor \n\n Compra \t Constructora \t\t banco Vinculado \n\n";
            for (CompraPorProveedorVo compra: compras) {
                salida += compra.getIdCompra() + "\t";
                salida += compra.getConstructora();
                if (compra.getConstructora().length() <= 11) {
                    salida += " \t\t ";
                } else{
                    salida += " \t ";
                }
                salida += compra.getBancoVinculado() + "\n";
            }
            textArea.setText(salida);
        } catch (Exception e){
            System.err.println("Las cosas no estan saliendo como se esperaba " + e.getMessage());
        }
        //holaaaa
    }
    
}
