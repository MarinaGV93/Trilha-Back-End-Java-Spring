package Princípio_da_Segregação_de_Interface_I;

import Princípio_da_Segregação_de_Interface_I.enums.Acao;
import Princípio_da_Segregação_de_Interface_I.modelos.contratos.Contrato;
import Princípio_da_Segregação_de_Interface_I.modelos.contratos.ContratoSeguro;
import Princípio_da_Segregação_de_Interface_I.modelos.contratos.ContratoTrabalho;
import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.PagamentoBoleto;
import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.PagamentoCartao;
import Princípio_da_Segregação_de_Interface_I.modelos.pagamentos.PagamentoPix;
import Princípio_da_Segregação_de_Interface_I.services.PagamentoService;

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

        PagamentoCartao outroPagamentoCartao = new PagamentoCartao(10);

        PagamentoBoleto pagamentoBoleto1 = new PagamentoBoleto();

        pagamentoBoleto1.processarPagamento("Cartao");

        PagamentoPix pagamentoPix = new PagamentoPix();

        PagamentoService pagamentoServiceCartao = new PagamentoService(pagamentoCartao);
        PagamentoService pagamentoServiceBoleto = new PagamentoService(pagamentoBoleto1);
        PagamentoService pagamentoServicePix = new PagamentoService(pagamentoPix);

        pagamentoServiceCartao.processarPagamento();
        pagamentoServiceBoleto.processarPagamento();
        pagamentoServicePix.processarPagamento();
    }

    private static void gerenciaPessoas() {
        System.out.println("Serviço de pessoas");

    }

    private static void gerenciaContratos() {
        System.out.println("Serviço de contratos");
    }

}
