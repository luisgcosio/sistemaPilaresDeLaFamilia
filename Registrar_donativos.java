
package Frames;

import Clases.Conectar;
import static Frames.Gestion_infantes.idinfante;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class Registrar_donativos extends javax.swing.JFrame {

    DefaultTableModel modelo=new DefaultTableModel();
    
    int idinfante=0;
    
    public static int iddonativo=0;
    
    
    public Registrar_donativos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtcantidad.setEditable(false);
        txttelefono.setEditable(false);
        txtcantidad.setEditable(false);
        cmbedad.setEditable(false);
        idinfante=Gestion_infantes.idinfante;
          
        try {
            Connection cn=con.conexion();
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM infantes WHERE id_infante='"+idinfante+"'");
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                setTitle("Informacion de donativos"+rs.getString("nombre"));
                lbl_registro.setText("Informacion de donativo"+rs.getString("nombre"));
                txtnombre.setText(rs.getString("nombre"));
                txtapellido.setText(rs.getString("apellido"));
                cmbedad.setSelectedItem(rs.getString("edad"));
                txttelefono.setText(rs.getString("telefono"));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al cargar");
        }
        
        try {
            PreparedStatement pst=cn.prepareStatement(
            "SELECT id_donativo, id_infante_donativo,id_sede_donativo,donante,cantidad FROM donativo WHERE"
                    + "id_infante_donativo='"+idinfante+"'");
            ResultSet rs=pst.executeQuery();
            
            tabla_donativos=new JTable();
            jScrollPane1.setViewportView(tabla_donativos);
            
            modelo.addColumn("ID donativo");
            modelo.addColumn("Sede");
            modelo.addColumn("Cantidad");
            
            while(rs.next()){
                Object[] fila=new Object[3];
                for(int i=0;i<3;i++){
                    fila[i]=rs.getObject(i+1);
                }
            modelo.addRow(fila);
            }
            
            int filax=0;
            int total=0;
            
            for(int i=0;i<tabla_donativos.getRowCount();i++){
                filax=Integer.parseInt(tabla_donativos.getValueAt(i,2).toString());
                total+=filax;
                
                txtcantidad.setText(""+total);
            }
            int cantidad=Integer.parseInt(txtcantidad.getText());
            
            
            
        } catch (SQLException e) {
            System.err.println("Error al llenar los datos ");
            JOptionPane.showMessageDialog(null,"");
        }
        tabla_donativos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point=tabla_donativos.rowAtPoint(e.getPoint());
                int columna_point=0;
                
                if(fila_point>-1){
                    iddonativo=(int)modelo.getValueAt(fila_point, columna_point);
                    Registrar_donativos registrar_donativos=new Registrar_donativos();
                    registrar_donativos.setVisible(true);
                    dispose();
                }
            }
                
         });
        
    }
    
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                
                public void windowClosing(WindowEvent e){      
                    confirmarsalida();   
                }
            });
        } catch(Exception e){
            
        }
    }
    
    public void confirmarsalida(){
        int valor=JOptionPane.showConfirmDialog
        (this,"¿Desea salir?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Hasta pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_registro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbedad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_donativos = new javax.swing.JTable();
        btnimprimir = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_registro.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        lbl_registro.setText("REGISTRO DE DONATIVOS");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Edad");

        cmbedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        jLabel5.setText("Telefono");

        tabla_donativos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_donativos);

        btnimprimir.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnvolver.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver png.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btnregistrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinero.png"))); // NOI18N
        btnregistrar.setText("Registrar donativo");
        btnregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre)
                    .addComponent(jLabel3)
                    .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(cmbedad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttelefono)
                    .addComponent(btnvolver))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbl_registro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 61, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnregistrar)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcantidad))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbl_registro)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnvolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnregistrar)
                            .addComponent(jLabel7)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Principal principal=new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed


    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_donativos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmbedad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_registro;
    private javax.swing.JTable tabla_donativos;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    Conectar con=new Conectar();
    Connection cn=con.conexion();
    
}
