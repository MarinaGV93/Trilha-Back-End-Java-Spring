package Como_modificar_um_sistema_da_forma_correta_O.modelos.pagamentos;

public class PagamentoBoleto implements Pagamento{

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
