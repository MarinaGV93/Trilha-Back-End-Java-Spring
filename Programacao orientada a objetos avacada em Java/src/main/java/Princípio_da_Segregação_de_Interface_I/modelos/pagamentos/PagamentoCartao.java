package Princípio_da_Segregação_de_Interface_I.modelos.pagamentos;

import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.interfaces.Pagamento;
import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.interfaces.Parcelavel;

public class PagamentoCartao implements Pagamento, Parcelavel {
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

    @Override
    public void parcelarPagamento(Integer numeroParcelas) {

    }
}
