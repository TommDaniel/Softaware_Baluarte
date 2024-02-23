/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import Logic.Cliente;
import Logic.Clientes;
import Logic.Produto;
import Logic.Produtos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import util.GerenciadorJanelas;


/**
 *
 * @author danie
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private static GerenciadorJanelas Frame;

    private ImageIcon icon = new ImageIcon("Imagens/Icone.png");
    public static GerenciadorJanelas getInstance(){
        return Frame;
    }
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        Frame = new GerenciadorJanelas(jDesktopPane1);
        this.setIconImage(icon.getImage());
        importarDeArquivo();
    }
    
    public void importarDeArquivo() {
        String pathToFile1 = "save/dadosTabelaProdutos.ser";
        String pathToFile2 = "save/dadosClientes.ser";
        
        File file1 = new File(pathToFile1);
        File file2 = new File(pathToFile2);
        // Verifica se o arquivo existe antes de tentar lê-lo
        if (!file1.exists()) {
            return;
        }
        
        try (FileInputStream fileIn = new FileInputStream(pathToFile1); ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            ArrayList<Produto> nprodutos = (ArrayList<Produto>) objectIn.readObject();
            Produtos.setProdutos(nprodutos);
            if (!nprodutos.isEmpty()) {
                Produtos.setCount(nprodutos.get(nprodutos.size() - 1).getId() + 1); // Supondo que você queria definir o contador para o próximo ID disponível
            }
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!file2.exists()) {
            return;
        }
        try (FileInputStream fileIn1 = new FileInputStream(pathToFile2); ObjectInputStream objectIn1 = new ObjectInputStream(fileIn1)) {
            ArrayList<Cliente> nclientes = (ArrayList<Cliente>) objectIn1.readObject();
            Clientes.setClientes(nclientes);
            
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Cliente c : Clientes.getClientes()){
            String pathToFile3 = "save/dadosItens"+c.getNome()+".ser";
            File file3 = new File(pathToFile3);
            if (!file3.exists()) {
                return;
            }
            try (FileInputStream fileIn1 = new FileInputStream(pathToFile3); ObjectInputStream objectIn1 = new ObjectInputStream(fileIn1)) {
                Map<Produto, Integer> nCompras = (Map<Produto, Integer>) objectIn1.readObject();
                c.setCompras(nCompras);


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            pathToFile3 = "save/dadosDivida"+c.getNome()+".ser";
            file3 = new File(pathToFile3);
            if (!file3.exists()) {
                return;
            }
            try (FileInputStream fileIn1 = new FileInputStream(pathToFile3); ObjectInputStream objectIn1 = new ObjectInputStream(fileIn1)) {
                double Valor = (double) objectIn1.readObject();
                c.setTotalPedido(Valor);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jFrame1.setTitle("Baluarte");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Baluarte");
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 51));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(790, 596));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(646, 335));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(646, 335));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/cash-register.png"))); // NOI18N
        jButton3.setText("Caixa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/cash.png"))); // NOI18N
        jButton5.setText("Vendas");
        jButton5.setToolTipText("");
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setIconTextGap(5);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/novo-produto.png"))); // NOI18N
        jButton2.setText("Produtos");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/exit.png"))); // NOI18N
        jButton4.setText("Sair");
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Frame.abrirTela(TelaVendas.getInstancia());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        Frame.abrirTela(TelaProdutos.getInstancia());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Frame.abrirTela(TelaCaixa.getInstancia());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
