
package Frames;

import Clases.Conectar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Registrar_sede extends javax.swing.JFrame {

    public Registrar_sede() {
        initComponents();
        
        TextPrompt nombre_sede=new TextPrompt("Escribe la sede",txtnombre);
        
        this.setLocationRelativeTo(null);
        mostrartabla("");
        limpiar();
        txtidsede.setEditable(false);
        
        cerrar();
    }

    void limpiar(){
        txtidsede.setText("");
        txtnombre.setText("");
    }
    
    void mostrartabla(String valor){
        DefaultTableModel modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Sede");
        
        tabla_registro_sede.setModel(modelo);
        
        String sql="SELECT * FROM casahogar";
        
        String datos[]=new String[2];
        Statement st;
        try{
            st=cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                
                modelo.addRow(datos);
                
            }
            
            tabla_registro_sede.setModel(modelo);
            
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error, contacte al administrador");
        }
        
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

        popborrar = new javax.swing.JPopupMenu();
        popeliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidsede = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_sede = new javax.swing.JTable();

        popeliminar.setText("Eliminar");
        popeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeliminarActionPerformed(evt);
            }
        });
        popborrar.add(popeliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel1.setText("REGISTRO DE SEDES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciudades", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N

        jLabel2.setText("ID Ciudaad");

        jLabel3.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidsede)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidsede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnguardar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save png.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualiza png.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnvolver.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver png.png"))); // NOI18N
        btnvolver.setText("VOLVER");
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        tabla_registro_sede.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_registro_sede.setComponentPopupMenu(popborrar);
        jScrollPane1.setViewportView(tabla_registro_sede);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addContainerGap(870, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardar)
                            .addComponent(btnactualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvolver)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Principal principal=new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        
        try{
            if(txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Debes llenar el campo");
            }else{
                PreparedStatement ps=cn.prepareStatement("INSERT INTO casahogar (nombre_sede) VALUES(?)");
                ps.setString(1, txtnombre.getText());
                JOptionPane.showMessageDialog(null, "Sede agregada con exito");
                mostrartabla("");
                limpiar();
                
            }
        } catch(SQLException e){
            System.err.println("e");
            JOptionPane.showMessageDialog(null,"Problema al guardar. Por favor contacte al administradors");
        }
                
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
              
        try {
            PreparedStatement ps=cn.prepareStatement("UPDATE casahogar SET nombre_sede='"+txtnombre.getText()+"' WHERE id_sede='"+txtidsede.getText()+"'");
            
            int respuesta=ps.executeUpdate();
            if(respuesta>0){
                JOptionPane.showMessageDialog(null,"Sede actualizada");
                limpiar();
                mostrartabla("");
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
            }
            
        } catch (SQLException e) {
            System.err.println("e");
            JOptionPane.showMessageDialog(null,"Error al actualizar");
        }
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void popeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeliminarActionPerformed
        
        try {
            PreparedStatement ps=cn.prepareStatement("DELETE FROM casahogar WHERE id_casahogar='"+txtidsede+"'");
            int respuesta=ps.executeUpdate();
            if(respuesta>0){
                JOptionPane.showMessageDialog(null, "Sede eliminada");
                limpiar();
                mostrartabla("");
            } else{
                JOptionPane.showMessageDialog(null,"No ha seleccionado una fila");
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al actualizar");
        }
        
    }//GEN-LAST:event_popeliminarActionPerformed

    private void tabla_registro_sedeMouseClicked(java.awt.event.MouseEvent evt){
        int fila=this.tabla_registro_sede.getSelectedRow();
        this.txtidsede.setText(this.tabla_registro_sede.getValueAt(fila,0).toString());
        this.txtnombre.setText(this.tabla_registro_sede.getValueAt(fila,1).toString());
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrar_sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_sede().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popborrar;
    private javax.swing.JMenuItem popeliminar;
    public javax.swing.JTable tabla_registro_sede;
    private javax.swing.JTextField txtidsede;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    Conectar con=new Conectar();
    Connection cn=con.conexion();

}
