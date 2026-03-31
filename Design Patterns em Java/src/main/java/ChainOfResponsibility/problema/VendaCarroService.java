package ChainOfResponsibility.problema;

import ChainOfResponsibility.Carro;
import ChainOfResponsibility.Marca;

import java.math.BigDecimal;

public class VendaCarroService {
    public BigDecimal calculaValorVenda(Carro carro){
        BigDecimal valorVenda = carro.getPreco();

        //Se a marca for FIAT
        if (Marca.FIAT.equals(carro.getMarca())){

            //Desconto (subtrai) de 1000
            return valorVenda.subtract(new BigDecimal(1000));
        }

        //Se a marca for FORD
        if (Marca.FORD.equals(carro.getMarca())){

            //Desconto (subtrai) de 2000
            return valorVenda.subtract(new BigDecimal(2000));
        }


        //Se o preço for maior que 100000
        if (carro.getPreco().compareTo(new BigDecimal(100000.00)) > 0){

            //Desconto (subtrai) de 10000
            return valorVenda.subtract(new BigDecimal(10000));
        }

        //Retorna o valor original
        return valorVenda;
    }
}
