/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import com.mysql.jdbc.Statement;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.koneksi;

/**
 *
 * @author Alherani Junivia
 */
public class form_detail_stok_barang extends javax.swing.JFrame {

    /**
     * Creates new form form_detail_stok_barang
     */
    
        ResultSet resultset;
    Statement statement;
    koneksi con;
    public form_detail_stok_barang() {
  
        initComponents();
        setTitle("Stok Barang");
         con = new koneksi();
        String sqlSearch="select*from barang";
        select(sqlSearch);
    }

     private void select(String sql){
        String header[]={"ID_BARANG","KATEGORI","NAMA_BARANG","STOK"};
        DefaultTableModel defaultTableModel=new DefaultTableModel(null,header);
        TabelStok.setModel(defaultTableModel);

        for (int i=0;i<TabelStok.getRowCount();i++){
            defaultTableModel.removeRow(i);
          }
        try {
            statement=(Statement) con.connection.createStatement();
            resultset=statement.executeQuery(sql);


            while(resultset.next()){
                String id=resultset.getString(1);
                String kategori=resultset.getString(2);
                String nama=resultset.getString(3);
                int stok=resultset.getInt(4);

                Object baris[]={id,kategori,nama,stok};
                defaultTableModel.addRow(baris);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelStok = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        add_barang = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("League Spartan", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETAIL STOK BARANG");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 20, 370, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 80);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        TabelStok.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabelStok);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(90, 70, 452, 108);

        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchKeyTyped(evt);
            }
        });
        jPanel2.add(Search);
        Search.setBounds(200, 10, 149, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Search By Nama Barang");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 180, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 610, 200);

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setLayout(null);

        add_barang.setText(" Barang");
        add_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_barangActionPerformed(evt);
            }
        });
        jPanel3.add(add_barang);
        add_barang.setBounds(40, 10, 100, 30);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(160, 10, 100, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 280, 610, 50);

        setSize(new java.awt.Dimension(623, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyTyped
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_SearchKeyTyped

    private void add_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_barangActionPerformed
        // TODO add your handling code here:
        new form_barang().show();              
        this.dispose();
    }//GEN-LAST:event_add_barangActionPerformed

    private void SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyPressed
        // TODO add your handling code here:
        String sqlSearch="select*from barang where NAMA_BARANG like '"+Search.getText()+"%'";
        select(sqlSearch);
    }//GEN-LAST:event_SearchKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new penjualan().show();              
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(form_detail_stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_detail_stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_detail_stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_detail_stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_detail_stok_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JTable TabelStok;
    private javax.swing.JButton add_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
