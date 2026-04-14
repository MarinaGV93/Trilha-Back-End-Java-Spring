package Introducao_a_POO.pedidos_composiçao_herança;

public class PedidoEspecial extends Pedido{
    private Double descontoEspecial;

    public Double aplicarDesconto(Double valor){
        return descontoEspecial * valor;
    }

    public Double getDescontoEspecial() {
        return descontoEspecial;
    }

    public void setDescontoEspecial(Double descontoEspecial) {
        this.descontoEspecial = descontoEspecial;
    }
}
