package E_se_algo_falhar;


import E_se_algo_falhar.enums.Acao;
import E_se_algo_falhar.excecao.ContratoInvalidoException;
import E_se_algo_falhar.modelos.contratos.Contrato;
import E_se_algo_falhar.modelos.contratos.ContratoAluguel;
import E_se_algo_falhar.modelos.contratos.ContratoSeguro;
import E_se_algo_falhar.modelos.contratos.ContratoTrabalho;
import E_se_algo_falhar.modelos.pagamentos.PagamentoBoleto;
import E_se_algo_falhar.modelos.pagamentos.PagamentoCartao;
import E_se_algo_falhar.modelos.pagamentos.PagamentoPix;
import E_se_algo_falhar.repository.ContratoRepositoryArquivo;
import E_se_algo_falhar.repository.ContratoRepositoryBD;
import E_se_algo_falhar.repository.interfaces.ContratoRepository;
import E_se_algo_falhar.services.ContratoService;
import E_se_algo_falhar.services.PagamentoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        gerenciaContratos();
        System.out.println("----------------------------------------");
        gerenciaPessoas();
        System.out.println("----------------------------------------");
        gerenciaPagamentos();
        System.out.println("----------------------------------------");
        gerenciaAcaoContratos();
        System.out.println("----------------------------------------");
        gerenciaRescisaoDeContratos();
        System.out.println("----------------------------------------");
        gerenciaSalvaContratos();
    }

    private static void gerenciaSalvaContratos() {
        System.out.println("Serviço de salvamento de contratos!");

        ContratoRepository contratoRepository = new ContratoRepositoryArquivo();
        ContratoService contratoService = new ContratoService(contratoRepository);

        ContratoAluguel contratoAluguel = new ContratoAluguel("Rua das peras, 123", "Casa");
        ContratoSeguro contratoSeguro = null;
        System.out.println(contratoAluguel);

        contratoService.salvarContrato(contratoAluguel);
        contratoService.salvarContrato(contratoSeguro);
    }

    private static void gerenciaRescisaoDeContratos() {
        System.out.println("Serviço de rescisão de contratos!");

        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(List.of("Gabriel", "Daniel"));
        contratoTrabalho.rescindirPorJustaCausa();
    }

    private static void gerenciaAcaoContratos() {
        System.out.println("Serviço de ação de contratos!");

        ContratoSeguro contratoSeguro = new ContratoSeguro(1500.0, List.of("Gabriel"));
        // System.out.println(contratoSeguro.toString());

        executarAcaoContrato(contratoSeguro, Acao.ACT);
    }

    private static void executarAcaoContrato(Contrato contrato, Acao acaoContrato) {
        // System.out.println("Executando ação de contrato: " + contrato.numeroContrato + " - " + acaoContrato);

        // if (contrato instanceof ContratoSeguro){
        //     if (acaoContrato.equals("Aceitar")){
        //         System.out.println("Contrato de Seguro aceito");
        //     } else if (acaoContrato.equals("Recusar")) {
        //         System.out.println("Contrato de Seguro recusado");
        //     } else {
        //         System.out.println("Ação de contrato inválida");
        //     }
        // } else if (contrato instanceof ContratoAluguel) {
        //     if (acaoContrato.equals("Aceitar")){
        //         System.out.println("Contrato de Seguro aceito");
        //     } else if (acaoContrato.equals("Recusar")) {
        //         System.out.println("Contrato de Seguro recusado");
        //     } else {
        //         System.out.println("Ação de contrato inválida");
        //     }
        // } else {
        //     System.out.println("Tipo de contrato inválido");
        // }

        contrato.executarAcao(acaoContrato);
    }

    private static void gerenciaPagamentos() {
        System.out.println("Serviço de pagamento!");

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao(6);
        PagamentoPix pagamentoPix = new PagamentoPix();

        PagamentoService pagamentoServiceBoleto = new PagamentoService(pagamentoBoleto);
        PagamentoService pagamentoServiceCartao = new PagamentoService(pagamentoCartao);
        PagamentoService pagamentoServicePix = new PagamentoService(pagamentoPix);

        pagamentoServiceBoleto.processarPagamento();
        pagamentoServiceCartao.processarPagamento();
        pagamentoServicePix.processarPagamento();
    }

    private static void gerenciaPessoas() {
        System.out.println("Serviço de pessoas");

    }

    private static void gerenciaContratos() {
        System.out.println("Serviço de contratos");
    }

}
