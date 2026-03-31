package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;
import ChainOfResponsibility.Marca;

import java.math.BigDecimal;

public class DescontoCarroFIAT extends DescontoCarro{
    //Cria um contrutor que receba o proximo desconto
    public DescontoCarroFIAT(DescontoCarro proximoDesconto) {
        super(proximoDesconto);
    }

    //Quando se tem uma classe concreta e implementa uma classe abstrata, é obrigado a implementar os metodos
    @Override
    public BigDecimal aplicarDesconto(Carro carro) {
        BigDecimal valorVenda = carro.getPreco();

        if (Marca.FIAT.equals(carro.getMarca())){
            return valorVenda.subtract(new BigDecimal(1000));
        }

        //Chama o proximo desconto
        return proximoDesconto.aplicarDesconto(carro);
    }

}
