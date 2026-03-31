package TemplateMethod.problema;

import TemplateMethod.VeiculoParaReparo;

public class TesteReparaVeiculo {
    public static void main(String[] args) {
        System.out.println("---------------------LUXO-----------------------");

        //Cria um veículo de luxo
        VeiculoParaReparo veiculoDeLuxo = new VeiculoParaReparo();

        //Coloca 50% de dano no veículo
        veiculoDeLuxo.setPorcentagemDano(49);

        //Cria o serviço de reparo para o veículo de luxo
        ReparoVeiculoDeLuxoService rpl = new ReparoVeiculoDeLuxoService(veiculoDeLuxo);

        //Chama o mét odo de reparo
        rpl.reparaVeiculo();

        System.out.println("---------------------COMUM-----------------------");

        //Cria um veiculo comum
        VeiculoParaReparo veiculoComum = new VeiculoParaReparo();

        //Coloca 71% de dano no veículo
        veiculoComum.setPorcentagemDano(71);

        //Cria o serviço de reparo para o veículo comum
        ReparoVeiculoComumService rpc = new ReparoVeiculoComumService(veiculoComum);

        //Chama o mét odo de reparo
        rpc.reparaVeiculo();
    }
}
