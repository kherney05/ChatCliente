package vista;

import control.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

public class VistaChat extends JFrame {
    Cliente cliente;
    private JTextArea taEnviar;
    private JButton btBorrar;
    private JButton btEnviar;
    private JButton btGuardar;
    private JTextArea taPrincipal;
    private JScrollPane spPrinciapal;
    private JScrollPane jScrollPane2;
    private JPanel JpanelContenedor;
    private JTextField textEstado;
    private JTextField textRutaConver;


    public void actualizarMensajes(String mensaje){
        taPrincipal.append("\n"+mensaje);
    }

    private void initComponents() {
        spPrinciapal.setViewport(null);
        taPrincipal.setColumns(20);
        taPrincipal.setEditable(false);
        taPrincipal.setRows(5);
        spPrinciapal.setViewportView(taPrincipal);
        taEnviar.setColumns(20);
        taEnviar.setRows(5);
        jScrollPane2.setViewportView(taEnviar);
    }


    public VistaChat(Cliente cliente) {
        this.cliente = cliente;
        initComponents();


        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.escribirMensaje(taEnviar.getText());
                actualizarMensajes(cliente.nombre +" "+ (new Date().toString())+" dice > "+taEnviar.getText());
                taEnviar.setText("");
                textEstado.setText("Sin guardar");
            }
        });

        btBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taEnviar.setText("");
            }
        });

        btGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = cliente.getRutaConversacion();

                cliente.saveConversation(taPrincipal.getText());
                textEstado.setText("Guardado");
                textRutaConver.setText(ruta);
                cliente.guardarConversacion(taPrincipal.getText());


            }
        });
    }

    //metodo Getter para mostrar la  vista
    public JPanel getJpanelContenedor() {
        return JpanelContenedor;
    }
}
