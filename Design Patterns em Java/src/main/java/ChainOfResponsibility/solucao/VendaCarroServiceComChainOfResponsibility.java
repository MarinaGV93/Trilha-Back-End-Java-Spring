package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;
import ChainOfResponsibility.Marca;

import java.math.BigDecimal;

public class VendaCarroServiceComChainOfResponsibility {
    public BigDecimal calculaValorVenda(Carro carro){
        DescontoCarro desconto = new DescontoCarroFIAT(
                //Passa o proximo deconto
                new DescontoCarroFORD(
                        //Passa o proximo desconto
                        new DescontoCarroValorMaiorQueCemMil(
                                //Passa o proximo desconto
                                new SemDireitoADesconto(
                                        //Passa o proximo desconto
                                        null)
                        )
                )
        );

        //Retorna desconto passando o carro
        return desconto.aplicarDesconto(carro);
    }
}
