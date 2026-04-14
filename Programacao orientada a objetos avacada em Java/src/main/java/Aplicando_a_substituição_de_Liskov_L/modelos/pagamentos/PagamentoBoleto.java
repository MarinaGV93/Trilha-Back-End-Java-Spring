package Aplicando_a_substituição_de_Liskov_L.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
