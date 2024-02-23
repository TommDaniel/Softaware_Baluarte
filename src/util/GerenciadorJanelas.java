/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author daniel
 */
public class GerenciadorJanelas {
    private static JDesktopPane jDesktopPane;
    
    public GerenciadorJanelas(JDesktopPane jDesktopPane){
        GerenciadorJanelas.jDesktopPane = jDesktopPane;
    }
    public void abrirTela2(JInternalFrame j){
        jDesktopPane.add(j);
        j.setVisible(true);
    }
    public void abrirTela(JInternalFrame j){
        
        jDesktopPane.add(j);
        j.setVisible(true);
        j.setSize(jDesktopPane.getSize());
        jDesktopPane.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension newSize = e.getComponent().getSize();
                j.setSize(newSize);
                j.revalidate();
            }
        });

        
        
    }
}
