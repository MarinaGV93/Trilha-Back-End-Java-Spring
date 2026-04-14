package Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
