package Como_modificar_um_sistema_da_forma_correta_O;

import Como_modificar_um_sistema_da_forma_correta_O.modelos.pagamentos.PagamentoBoleto;
import Como_modificar_um_sistema_da_forma_correta_O.modelos.pagamentos.PagamentoCartao;
import Como_modificar_um_sistema_da_forma_correta_O.modelos.pagamentos.PagamentoPix;
import Como_modificar_um_sistema_da_forma_correta_O.services.PagamentoService;

public class Main {
    public static void main(String[] args) {
        gerenciaContratos();
        System.out.println("----------------------------------------");
        gerenciaPessoas();
        System.out.println("----------------------------------------");
        gerenciaPagamentos();
    }

    private static void gerenciaPagamentos() {
        System.out.println("Serviço de pagamento!");

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao(6);
        PagamentoPix pagamentoPix = new PagamentoPix();

        PagamentoService pagamentoService = new PagamentoService();

        pagamentoService.processarPagamento();
        pagamentoService.processarPagamento();
        pagamentoService.processarPagamento();
    }

    private static void gerenciaPessoas() {
        System.out.println("Serviço de pessoas");

    }

    private static void gerenciaContratos() {
        System.out.println("Serviço de contratos");
    }

}
