package Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos;

public class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Pix gerado com sucesso");
    }
}
