package Princípio_da_Segregação_de_Interface_I.modelos.pagamentos;

import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.interfaces.Pagamento;

public class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento(String tipoPagamento) {
        System.out.println("Boleto gerado com sucesso");
    }
}
