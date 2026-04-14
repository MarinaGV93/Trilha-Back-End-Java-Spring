package Introducao_a_POO.pedidos_composiçao_herança;

import java.util.List;

public class Pedido {
    private Integer numeroPedido;
    private List<ItemPedido> itemPedidoList;

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }
}
