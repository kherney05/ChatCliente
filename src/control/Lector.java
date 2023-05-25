package control;
import control.Cliente;
import java.io.*;
class Lector extends Thread {
    private Cliente clienteChat;
    public Lector(Cliente clienteChat){
        this.clienteChat = clienteChat;
        start();
    }
    public void run(){
        String linea = null;
        try {
            while ( (linea=clienteChat.entrada.readLine()) != null ) {
                clienteChat.mostar(linea+System.getProperty("line.separator"));

            }
        }
        catch (IOException e2){}
    }
}