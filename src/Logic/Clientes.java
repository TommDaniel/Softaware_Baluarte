/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author danie
 */
public class Clientes implements Serializable{
    private static ArrayList<Cliente>clientes = new <Cliente>ArrayList();
    public static void addCliente(Cliente p){
        clientes.add(p);
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });

    }
    public static Cliente getCliente(String nome) {
        
        for(Cliente c : clientes){
            if(c.getNome().equals(nome))
                return c;
        }
        return null;
    }

    public static void removeCliente(Cliente c){
        clientes.remove(c);
    }

    
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public static void setClientes(ArrayList<Cliente> nclientes) {
        clientes = nclientes ;
    }
    public static void salvarClientes(){
        try (FileOutputStream fileOut = new FileOutputStream("save/dadosClientes.ser"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void salvarCompras(){
        for(Cliente c : clientes){
            c.salvarCompras();
        }
    }
    
}
