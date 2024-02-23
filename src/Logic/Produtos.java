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
public class Produtos implements Serializable{
    private static ArrayList<Produto> produtos = new <Produto>ArrayList();
    private static ArrayList<String> Categorias = new <String>ArrayList();
    private static int count=0;
    public static void addProduto(Produto p){
        
        produtos.add(p);
        Collections.sort(produtos, new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return Integer.compare(p1.getId(), p2.getId());
            }
        });
    }
    public static Produto getProduto(int id) {
        
        for(Produto p : produtos){
            if(p.getId()==id)
                return p;
        }
        return null;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public static void setProdutos(ArrayList<Produto> novoP) {
        produtos = novoP;
    }
    public static int getCount() {
        return count++;
    }
    public static void setCount(int idl) {
        count = idl;
    }
    public static void removeProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
        
    }
    
    public static void removeCategoria(String cat){
        Categorias.remove(cat);
    }
    
    public static void addCategoria(String cat){
        // Converte a categoria para minúsculas (ou maiúsculas) antes de verificar
        String catLowerCase = cat.toLowerCase(); // ou use toUpperCase()

        // Verifica se a lista já contém a categoria (ignorando maiúsculas/minúsculas)
        boolean alreadyExists = Categorias.stream().anyMatch(existingCat -> existingCat.toLowerCase().equals(catLowerCase));
        
        // Se não contém, adiciona à lista
        if (!alreadyExists) {
            Categorias.add(cat);
        }
        
    }
    
    public static ArrayList<String> getCategorias(){
        return Categorias;
    }
    
    public static void setCategorias(ArrayList<String> nCategorias){
        Categorias = nCategorias;
    }
    
    public static void SalvarProdutos(){
        try (FileOutputStream fileOut = new FileOutputStream("save/dadosTabelaProdutos.ser"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(getProdutos());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void SalvarCategorias(){
        try (FileOutputStream fileOut = new FileOutputStream("save/dadosCategorias.ser"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(getCategorias());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
