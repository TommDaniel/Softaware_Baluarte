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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author danie
 */
public class Cliente implements Serializable{
    private String nome;
    private String endereco;
    private String numero;
    private int quantidade;
    private Map<Produto, Integer> compras = new HashMap<>();
    private double totalPedido = 0;
    private double totalGasto;
    public Cliente(String nome, String numero, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
    }
    
    public void setTotalPedido(double t){
        totalPedido = t;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }
    public void addCompra(int id, int quantidade){
        Produto produto = Produtos.getProduto(id);
        if (produto != null) {
            produto.subProduto(quantidade);
            compras.put(produto, compras.getOrDefault(produto, 0) + quantidade);
            totalPedido += produto.getPreco() * quantidade;
            Produtos.SalvarProdutos();
            salvarGasto();
        }
    }
    public void setCompras(Map<Produto, Integer> compras) {
        this.compras = compras;
    }
    public double totalPedido(){
        return totalPedido;
    } 
    public void Pagar(double pago){
        
        totalPedido -= pago;
        if(totalPedido<0){
            totalPedido = 0;
        }
        salvarGasto();
    }
    public boolean pagou(){
        if(totalPedido == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Produto> getItensCompra(){
        return new ArrayList<>(compras.keySet());
    }
    public int getQuantidade(Produto produto) {
        return compras.getOrDefault(produto, 0);
    }
    public double getTotalGasto(){
        totalGasto = 0;
        for (Map.Entry<Produto, Integer> entry : compras.entrySet()) {
            totalGasto += entry.getKey().getPreco() * entry.getValue();
        }
        return totalGasto;
    }
    public void salvarCompras() {
        try (FileOutputStream fileOut = new FileOutputStream("save/dadosItens"+nome+".ser"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(compras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void salvarGasto() {
        try (FileOutputStream fileOut = new FileOutputStream("save/dadosDivida"+nome+".ser"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(totalPedido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
