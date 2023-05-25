package control;
import java.io.*;
import java.net.*;
import vista.InicioSesion;
import javax.swing.*;
import vista.VistaChat;
import java.util.Formatter;

public class Cliente{
    protected Socket socketCliente;
    protected PrintStream salida;
    public BufferedReader entrada;
    public String IP="localhost";
    public String nombre="anonimo";
    private InicioSesion inicioS;
    private VistaChat vistaChat;

    private String rutaConversacion = "C:\\Users\\vente\\Archivos Java\\chat-sockets.txt";
    public Cliente(){}

    public void iniciar(){
        //Mostrar la ventana de inicio de sesion
        inicioS = new InicioSesion(this);
        inicioS.setVisible(true);
    }

    public boolean conectarse(){
        boolean retorno=false;
        try {
            //Abre el socket en el mismo puerto que el servidor
            socketCliente = new Socket(IP,9002);
            salida = new PrintStream(
                    socketCliente.getOutputStream());
            entrada = new BufferedReader(
                    new InputStreamReader(
                            socketCliente.getInputStream()));

            //si la conexion es exitosa entonces:
            //Oculta la ventana de inicio de sesion
            inicioS.setVisible(false);
            //Muestra la vista principal del chat
            vistaChat = new VistaChat(this);
            vistaChat.setContentPane(vistaChat.getJpanelContenedor());
            vistaChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vistaChat.setVisible(true);
            vistaChat.pack();
            //Inicia la clase que recibe mensajes
            new Lector(this);
            //Envia el nombre ingresado al servidor
            salida.println(nombre);
            retorno=true;
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    //Este metodo permite enviar mensajes a un cliente
    public void escribirMensaje(String mensaje){
        mostar(mensaje);
        salida.println(mensaje);
    }
    //Este metodo actualiza los mensajes que se muestran en la ventana del chat
    public void mostar(String mensaje){
        vistaChat.actualizarMensajes(mensaje);
    }
    public static void main(String[] args)
            throws IOException, ConnectException{
            Cliente cliente = new Cliente();
            cliente.iniciar();//Crea al cliente
    }

    public void guardarConversacion(String conversacion){

        Formatter archivo = null;
        try {
            archivo = new Formatter(rutaConversacion);
            archivo.format(conversacion);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            archivo.close();
        }
    }

    public String getRutaConversacion() {
        return rutaConversacion;
    }
}