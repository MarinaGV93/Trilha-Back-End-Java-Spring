package Evitando_duplicação_de_código.modelos.pagamentos;

public class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Pix gerado com sucesso");
    }
}
