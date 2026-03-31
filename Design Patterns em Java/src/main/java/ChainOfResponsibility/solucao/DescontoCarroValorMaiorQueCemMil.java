package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;

import java.math.BigDecimal;

public class DescontoCarroValorMaiorQueCemMil extends DescontoCarro{
    //Cria um contrutor que receba o proximo desconto
    public DescontoCarroValorMaiorQueCemMil(DescontoCarro proximoDesconto) {
        super(proximoDesconto);
    }

    //Quando se tem uma classe concreta e implementa uma classe abstrata, é obrigado a implementar os metodos
    @Override
    public BigDecimal aplicarDesconto(Carro carro) {
        BigDecimal valorVenda = carro.getPreco();

        if (carro.getPreco().compareTo(new BigDecimal(100000.00)) > 0){
            return valorVenda.subtract(new BigDecimal(10000));
        }

        //Chama o proximo desconto
        return proximoDesconto.aplicarDesconto(carro);
    }

}
