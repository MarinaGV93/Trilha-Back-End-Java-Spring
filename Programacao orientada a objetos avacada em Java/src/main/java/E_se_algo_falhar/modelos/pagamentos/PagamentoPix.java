package E_se_algo_falhar.modelos.pagamentos;

public class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Pix gerado com sucesso");
    }
}
