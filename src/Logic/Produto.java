/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Logic;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Produto implements Serializable {
    private String descricao;
    private int quantidade;
    private double preco;
    private String categoria;
    private Color cor;
    private int id;
    public Produto(int id,String categoria, String descricao, int quantidade, double preco, Color cor){
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.cor = cor;
    }
    public void subProduto(int q){
        if(q<=quantidade){
            quantidade -= q;
        }else{
            JOptionPane.showMessageDialog(null, "Sem itens em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int getId() {
        return id;
    }
    public String getDescricao(){
        return descricao;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public double getPreco(){
        return preco;
    }
    public String toString(){
        return ""+categoria+"-"+descricao;
    }
    public String getCategoria(){
        return categoria;
    }
    public Color getCor(){
        return cor;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setcategoria(String categoria){
        this.categoria = categoria;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public void setPreco(long preco){
        this.preco = preco;
    }
    public void setCor(Color cor){
        this.cor = cor;
    }
    
}
