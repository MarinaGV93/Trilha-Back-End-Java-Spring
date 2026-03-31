package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;

import java.math.BigDecimal;

//Não sera uma classe instanciada (usa o 'abstract')
public abstract class DescontoCarro {
    protected DescontoCarro proximoDesconto;

    public DescontoCarro(DescontoCarro proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }

    public abstract BigDecimal aplicarDesconto(Carro carro);
}
