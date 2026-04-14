package Aplicando_a_substituição_de_Liskov_L.modelos.pagamentos;

public class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Pix gerado com sucesso");
    }
}
