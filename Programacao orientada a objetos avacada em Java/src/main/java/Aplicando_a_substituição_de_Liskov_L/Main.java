package Aplicando_a_substituição_de_Liskov_L;


import Aplicando_a_substituição_de_Liskov_L.enums.Acao;
import Aplicando_a_substituição_de_Liskov_L.modelos.contratos.ContratoTrabalho;
import Aplicando_a_substituição_de_Liskov_L.modelos.pagamentos.PagamentoBoleto;
import Aplicando_a_substituição_de_Liskov_L.modelos.pagamentos.PagamentoCartao;
import Aplicando_a_substituição_de_Liskov_L.modelos.pagamentos.PagamentoPix;
import Aplicando_a_substituição_de_Liskov_L.modelos.contratos.Contrato;
import Aplicando_a_substituição_de_Liskov_L.modelos.contratos.ContratoSeguro;
import Aplicando_a_substituição_de_Liskov_L.services.PagamentoService;

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
