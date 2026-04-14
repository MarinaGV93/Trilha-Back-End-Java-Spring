package Evitando_duplicação_de_código.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
