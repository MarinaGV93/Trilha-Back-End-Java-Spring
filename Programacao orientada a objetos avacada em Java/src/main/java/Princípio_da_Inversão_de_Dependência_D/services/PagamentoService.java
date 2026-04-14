package Princípio_da_Inversão_de_Dependência_D.services;


import Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos.Pagamento;

public class PagamentoService {
    private Pagamento pagamento;
    
    public PagamentoService(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    //Fechar para nao ter que modificar o codigo
    public void processarPagamento() {
        pagamento.processarPagamento("cartao");

        // if (tipoPagamento.equals("boleto")){
        //     System.out.println("Pagamento com boleto realizado com sucesso");
        // } else if (tipoPagamento.equals("cartao")){
        //     System.out.println("Pagamento com cartao realizado com sucesso");
        // } else if (tipoPagamento.equals("pix")) {
        //     System.out.println("Pagamento com pix realizado com sucesso");
        // } else {
        //     System.out.println("Tipo de pagamento nao encontrado");
        // }
    }
}
