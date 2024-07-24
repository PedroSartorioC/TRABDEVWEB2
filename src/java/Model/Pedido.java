/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kener_000
 */
public class Pedido {
    private int id_pedido;
    private Cliente cliente;
    private String data_pedido;
    private Double valor_total;
    private int quantidade;

       public Pedido() {
       
    }

    public Pedido(int id_pedido, Cliente cliente, String data_pedido, Double valor_total, int quantidade) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.valor_total = valor_total;
        this.quantidade = quantidade;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean addPedido_Cliente(Lanche lanche) {
        if(lanche.getValor_lanche() == this.getValor_total()){
            return true;
        } else{
            return false;
        }
    }

    public boolean checkQuantidade() {
        if(this.getQuantidade() > 0){
            return true;
        } else{
            return false;
        }
    }

}
