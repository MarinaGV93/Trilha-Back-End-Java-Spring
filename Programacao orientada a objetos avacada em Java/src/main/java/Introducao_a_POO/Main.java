package Introducao_a_POO;

import Introducao_a_POO.contratos_herança_interface.ContratoAluguel;
import Introducao_a_POO.contratos_herança_interface.ContratoSeguro;
import Introducao_a_POO.pedidos_composiçao_herança.ItemPedido;
import Introducao_a_POO.pedidos_composiçao_herança.Pedido;
import Introducao_a_POO.pedidos_composiçao_herança.PedidoEspecial;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ola");


        ContratoAluguel contratoAluguel =  new ContratoAluguel();
        ContratoSeguro contratoSeguro = new ContratoSeguro();

        ContratoAluguel contratoAluguel2 =  new ContratoAluguel();
        ContratoSeguro contratoSeguro2 = new ContratoSeguro();

        contratoAluguel.assinar();
        contratoSeguro.assinar();

        contratoAluguel2.assinar();
        contratoSeguro2.assinar();

        System.out.println("Número contrato aluguel: " + contratoAluguel.getNumeroContrato());
        System.out.println("Número contrato seguro: " + contratoSeguro.getNumeroContrato());

        System.out.println("Número contrato aluguel 2: " + contratoAluguel2.getNumeroContrato());
        System.out.println("Número contrato seguro 2: " + contratoSeguro2.getNumeroContrato());

        System.out.println("---------------------------------------------");

        Pedido pedido = new Pedido();
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeItem("Panela");
        itemPedido.setValorItem(100.0);
        pedido.setNumeroPedido(1);

        //Criar uma lista de item pedido
        pedido.setItemPedidoList(List.of(itemPedido));

        System.out.println("Número pedido: " + pedido.getNumeroPedido());
        System.out.println("Item pedido: " + pedido.getItemPedidoList().getFirst().getNomeItem());

        PedidoEspecial pedidoEspecial = new PedidoEspecial();
        ItemPedido itemPedidoEspecial = new ItemPedido();

        //Dar o desconto
        pedidoEspecial.setDescontoEspecial(0.8);

        itemPedidoEspecial.setNomeItem("Panela");

        //Setar um valor a partir do valor do item anterior
        itemPedidoEspecial.setValorItem(pedidoEspecial.aplicarDesconto(itemPedido.getValorItem()));

        pedidoEspecial.setNumeroPedido(2);
        pedidoEspecial.setItemPedidoList(List.of(itemPedidoEspecial));

        System.out.println("Número pedido especial: " + pedidoEspecial.getNumeroPedido());
        System.out.println("Item pedido especial: " + pedidoEspecial.getItemPedidoList().getFirst().getNomeItem());
        System.out.println("Valor pedido especial: " + pedidoEspecial.getItemPedidoList().getFirst().getValorItem());
    }
}
