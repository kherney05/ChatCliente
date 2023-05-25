package vista;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import control.Cliente;
public class InicioSesion extends javax.swing.JFrame {
    Cliente cliente;
    private JButton btConectar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JLabel lAnuncio;
    private JTextField tfIP;
    private JTextField tfNombre;
    public InicioSesion(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
    }
    private void initComponents() {
        jPanel1 = new JPanel();
        tfNombre = new JTextField();
        tfIP = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        btConectar = new JButton();
        lAnuncio = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        tfIP.setText("localhost");
        jLabel1.setText("Nombre");
        jLabel2.setText("IP del Servidor");
        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });
        lAnuncio.setText("Ingrese su Nombre y la IP del Servidor");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfIP, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                                        .addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                                                        .addComponent(btConectar, GroupLayout.Alignment.TRAILING)))
                                        .addComponent(lAnuncio, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))

                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tfIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,

                                                GroupLayout.PREFERRED_SIZE))

                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConectar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,

                                        Short.MAX_VALUE)

                                .addComponent(lAnuncio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        pack();
    }
    //Escucha los eventos del boton conectar
    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {
        cliente.IP = tfIP.getText();
        cliente.nombre = tfNombre.getText();
        if(cliente.conectarse()){
            lAnuncio.setText("Ingres su Nombre y La IP del Servidor");
        }
        else{
            lAnuncio.setText("!!!!!EL SERVIDOR NO RESPONDE. REINTENTE");
        }
    }
}