package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;

import java.math.BigDecimal;

public class SemDireitoADesconto extends DescontoCarro{
    //Cria um contrutor que receba o proximo desconto
    public SemDireitoADesconto(DescontoCarro proximoDesconto) {
        super(proximoDesconto);
    }

    //Quando se tem uma classe concreta e implementa uma classe abstrata, é obrigado a implementar os metodos
    @Override
    public BigDecimal aplicarDesconto(Carro carro) {
        return BigDecimal.ZERO;
    }

}
