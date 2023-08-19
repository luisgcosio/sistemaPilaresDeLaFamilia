
package Frames;

import Clases.Conectar;
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

public class Gestion_infantes extends javax.swing.JFrame {
    
    public static int idinfante=0;
    DefaultTableModel model=new DefaultTableModel();

    public Gestion_infantes() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        cerrar();
        try {
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM infantes");
            ResultSet rs=ps.executeQuery();
            
            tabla_gestion_infantes=new JTable(model);
            jScrollPane1.setViewportView(tabla_gestion_infantes);
            
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Edad");
            model.addColumn("Telefono");
            model.addColumn("Sede");
            
            while(rs.next()){
                Object[] fila=new Object[5];
                for(int i=0;i<5;i++){
                    fila[i]=rs.getObject(i+1);
                }
                model.addRow(fila);
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al llenar tabla");
        }
        
        tabla_gestion_infantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point=tabla_gestion_infantes.rowAtPoint(e.getPoint());
                int columna_point=0;
                
                if(fila_point>-1){
                    idinfante=(int)model.getValueAt(fila_point, columna_point);
                    Informacion_infantes informacion_infantes=new Informacion_infantes();
                    informacion_infantes.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_gestion_infantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setText("GESTION DE INFANTES");

        btnvolver.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver png.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        tabla_gestion_infantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_gestion_infantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnvolver)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(btnvolver)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
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
                new Gestion_infantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_gestion_infantes;
    // End of variables declaration//GEN-END:variables
    
    Conectar con=new Conectar();
    Connection cn=con.conexion();

}
