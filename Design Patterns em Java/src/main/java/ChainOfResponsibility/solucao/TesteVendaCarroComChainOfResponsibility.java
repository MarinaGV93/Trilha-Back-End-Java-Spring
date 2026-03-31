/*
Vantagens:
    Cria classes que cada um irá ter uma tarefa e executa toda a cadeia de responsabilidades.
    Um sempre chama o próximo
 */

package ChainOfResponsibility.solucao;

import ChainOfResponsibility.Carro;
import ChainOfResponsibility.Marca;
import ChainOfResponsibility.problema.VendaCarroService;

import java.math.BigDecimal;

public class TesteVendaCarroComChainOfResponsibility {
    public static void main(String[] args) {
        VendaCarroServiceComChainOfResponsibility vendaCarroService = new VendaCarroServiceComChainOfResponsibility();

        //Criação do carro 1
        Carro carro1 = new Carro();
        carro1.setMarca(Marca.FORD);
        carro1.setModelo("Fiesta");
        carro1.setPreco(new BigDecimal(90000.00));

        System.out.println("Valor de venda " + carro1.getModelo() + ": " + carro1.getPreco());

        //Cálculo do valor de venda
        BigDecimal valorVenda1 = vendaCarroService.calculaValorVenda(carro1);
        System.out.println("Valor de venda " + carro1.getModelo() + " com desconto: " + valorVenda1);

        Carro carro2 = new Carro();
        carro2.setMarca(Marca.FIAT);
        carro2.setModelo("Uno");
        carro2.setPreco(new BigDecimal(40000.00));

        System.out.println("Valor de venda " + carro2.getModelo() + ": " + carro2.getPreco());

        BigDecimal valorVenda2 = vendaCarroService.calculaValorVenda(carro2);
        System.out.println("Valor de venda " + carro2.getModelo() + " com desconto: " + valorVenda2);

        Carro carro3 = new Carro();
        carro3.setMarca(Marca.CHEVROLET);
        carro3.setModelo("Camaro");
        carro3.setPreco(new BigDecimal(200000.00));

        System.out.println("Valor de venda " + carro3.getModelo() + ": " + carro3.getPreco());

        BigDecimal valorVenda3 = vendaCarroService.calculaValorVenda(carro3);
        System.out.println("Valor de venda " + carro3.getModelo() + " com desconto: " + valorVenda3);
    }
}
/*
Vantagens:
    Cria classes que cada um irá ter uma tarefa e cada um execute toda a cadeia de responsabilidades
 */
