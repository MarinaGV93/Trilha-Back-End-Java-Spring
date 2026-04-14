package Como_modificar_um_sistema_da_forma_correta_O.modelos.pagamentos;

public class PagamentoCartao implements Pagamento{
    private int numeroParcelas;

    public PagamentoCartao(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Cartao gerado com sucesso em " + numeroParcelas + " parcelas");
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
