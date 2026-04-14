package E_se_algo_falhar.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
