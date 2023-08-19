
package Frames;

import Clases.Conectar;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Registrar_infante extends javax.swing.JFrame {

    public Registrar_infante() {
        initComponents();
        
        TextPrompt nombre=new TextPrompt("Escribe el nombre",txtnombre);
        TextPrompt apellidos=new TextPrompt("Escribe el apellido",txtapellido);
        TextPrompt telefono=new TextPrompt("Escribe el telefono",txttelefono);
        TextPrompt buscar=new TextPrompt("Buscar",txtbuscar);   
        this.setLocationRelativeTo(null);
        
        limpiar();
        txtid_infante.setEnabled(false);
        txtcantidad.setEditable(false  );
        mostrartabla("");
        cerrar();
        cargarcombosede(cmb_sede);
        
        for(int i=0;i<=tabla_registro_infantes.getRowCount();i++){
           txtcantidad.setText(" "+i);
        }
        
    }
    
    void limpiar(){
        txtid_infante.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txttelefono.setText("");
        cmb_sede.setSelectedIndex(0);
        cmb_edad.setSelectedIndex(0);
    }
    
    void mostrartabla(String valor){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Sede/Ciudad");
        
        tabla_registro_infantes.setModel(modelo);
        String sql="SELECT * FROM infantes WHERE CONCAT (nombre, ' ',apellido,' ',edad,' ', id_sede) LIKE '%"+valor+"%'";
        String datos[]=new String[6];
        Statement st;
        
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                
                modelo.addRow(datos);
                
            }
            
            tabla_registro_infantes.setModel(modelo);
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
    
    public void cargarcombosede(JComboBox combodesede){
        try {
            String sql="SELECT nomnre_sede FROM casahogar";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                combodesede.addItem(rs.getString("nombre_sede"));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid_infante = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmb_sede = new javax.swing.JComboBox<>();
        txtapellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmb_edad = new javax.swing.JComboBox<>();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_infantes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();

        popeliminar.setText("Eliminar");
        popeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeliminarActionPerformed(evt);
            }
        });
        popborrar.add(popeliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setText("REGISTRO DE INFANTES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Infantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setText("ID Infante");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Sede");

        jLabel6.setText("Telefono");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        cmb_sede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona la sede", " " }));

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        jLabel9.setText("Edad");

        cmb_edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Edad", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid_infante)
                    .addComponent(txtnombre)
                    .addComponent(txttelefono)
                    .addComponent(cmb_sede, 0, 1, Short.MAX_VALUE)
                    .addComponent(txtapellido)
                    .addComponent(cmb_edad, 0, 155, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid_infante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmb_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnagregar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save png.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualiza png.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnvolver.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver png.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        tabla_registro_infantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_registro_infantes.setComponentPopupMenu(popborrar);
        tabla_registro_infantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_infantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_infantes);

        jLabel7.setText("BUSCAR");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("Registros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnagregar)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnactualizar))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(btnvolver)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnagregar)
                            .addComponent(btnactualizar))
                        .addGap(18, 18, 18)
                        .addComponent(btnvolver)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void popeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeliminarActionPerformed
        
        try {
            PreparedStatement ps=cn.prepareStatement("DELETE FROM infantes WHERE id_infante='"+txtid_infante.getText()+"'");
            
            int respuesta=ps.executeUpdate();
            
            if(respuesta>0){
                JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
                limpiar();
                mostrartabla("");
            
                for(int i=0;i<=tabla_registro_infantes.getRowCount();i++){
                    txtcantidad.setText(" "+i);
                }
            
            } else{
                JOptionPane.showMessageDialog(null,"No ha seleccionado una fila");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al eliminar");
        }
        
    }//GEN-LAST:event_popeliminarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        
        String id_sede=cmb_sede.getSelectedItem().toString();
        String edad=(String) cmb_edad.getSelectedItem();
        String sede=(String) cmb_sede.getSelectedItem();
        
        try {
            if(txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vaacio el nombre");
            }
            else if(txtapellido.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vaacio el apellido");
            }
            else if(txttelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vaacio el telefono");
            }
            else if(edad.equals("Seleccione edad")){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una edad");
            }
            else if(sede.equals("Seleccione sede")){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una sede");
            }
            
            else{
                PreparedStatement ps=cn.prepareStatement("INSERT INTO infantes (nombre,apellido,sede,edad,telefono,id_sede) VALUES(?,?,?,?,?)");
                ps.setString(1,txtnombre.getText());
                ps.setString(2,txtapellido.getText());
                ps.setString(3, cmb_sede.getSelectedItem().toString());
                ps.setString(4, cmb_edad.getSelectedItem().toString());
                ps.setString(5, txttelefono.getText());
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Infante registrado con exito");
                mostrartabla("");
                limpiar();
                
                for(int i=0;i<=tabla_registro_infantes.getRowCount();i++){
                    txtcantidad.setText(" "+i);
                }
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        String sede=(String) cmb_sede.getSelectedItem();
        String edad=(String) cmb_edad.getSelectedItem();
        try {
            if(txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vacio el nombre");
            }
            else if(txtapellido.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vaacio el apellido");
            }
            else if(txttelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No puedes dejar vaacio el telefono");
            }
            else if(edad.equals("Seleccione edad")){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una edad");
            }
            else if(sede.equals("Seleccione sede")){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una sede");
            }
            else{
                PreparedStatement ps=cn.prepareStatement("UPDATE infantes SET nombre='"+txtnombre.getText()                     +"',apllido='"+txtapellido.getText()
                        +"',sede='"+cmb_sede.getSelectedItem().toString()+"',edad='"
                        +cmb_edad.getSelectedItem().toString()+"',telefono='"+txttelefono.getText().toString()
                        +"' WHERE id_infante='"+txtid_infante.getText()+"'");                
                
                int respuesta=ps.executeUpdate();
                if(respuesta>0){
                    JOptionPane.showMessageDialog(null,"Datos modificados");
                    limpiar();
                    mostrartabla("");    
                }else{
                    JOptionPane.showMessageDialog(null,"No ha seleccionado una fila");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al actualizar");
        }
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void tabla_registro_infantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_infantesMouseClicked
        
        int fila=this.tabla_registro_infantes.getSelectedRow();
        this.txtid_infante.setText(this.tabla_registro_infantes.getValueAt(fila,0).toString());
        this.txtnombre.setText(this.tabla_registro_infantes.getValueAt(fila,1).toString());
        this.txtapellido.setText(this.tabla_registro_infantes.getValueAt(fila,2).toString());
        this.cmb_sede.setSelectedItem(this.tabla_registro_infantes.getValueAt(fila,3).toString());
        this.txttelefono.setText(this.tabla_registro_infantes.getValueAt(fila,5).toString());
        this.cmb_edad.setSelectedItem(this.tabla_registro_infantes.getValueAt(fila,4).toString());
        
    }//GEN-LAST:event_tabla_registro_infantesMouseClicked

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Principal principal=new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrartabla(txtbuscar.getText());
        for(int i=0;i<=tabla_registro_infantes.getRowCount();i++){
            txtcantidad.setText(" "+i);
        }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' | c>'Z') && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' | c>'Z') && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c=evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txttelefonoKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Registrar_infante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_infante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_infante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_infante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_infante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmb_edad;
    private javax.swing.JComboBox<String> cmb_sede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popborrar;
    private javax.swing.JMenuItem popeliminar;
    private javax.swing.JTable tabla_registro_infantes;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtid_infante;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
    Conectar con=new Conectar();
    Connection cn=con.conexion();

}
