package Como_evitar_o_uso_excessivo_de_condicionais.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
