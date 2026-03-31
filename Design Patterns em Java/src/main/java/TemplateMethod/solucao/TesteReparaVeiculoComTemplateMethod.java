/*
Vantagens:
    Reaproveita um template, que foi definida uma classe abstrata e somente os comportamentos específicos, fica em cada subclasse.
    Ao colocar abstrato no met odo, obriga que as subclasse implemente o mét odo.
    Ao colocar somente o protected, deixa como opcional que as subclasse implemente o mét odo, sobreescrevendo o met odo
 */

package TemplateMethod.solucao;

import TemplateMethod.VeiculoParaReparo;
import TemplateMethod.problema.ReparoVeiculoComumService;
import TemplateMethod.problema.ReparoVeiculoDeLuxoService;

public class TesteReparaVeiculoComTemplateMethod {
    public static void main(String[] args) {
        System.out.println("---------------------LUXO-----------------------");

        //Cria um veículo de luxo
        VeiculoParaReparo veiculoDeLuxo = new VeiculoParaReparo();

        //Coloca 50% de dano no veículo
        veiculoDeLuxo.setPorcentagemDano(49);

        //Cria o serviço de reparo para o veículo de luxo
        ReparoVeiculoService rpl = new ReparoVeiculoLuxoServiceComTemplateMethod(veiculoDeLuxo);

        //Chama o mét odo de reparo
        rpl.reparaVeiculo();

        System.out.println("---------------------COMUM-----------------------");

        //Cria um veiculo comum
        VeiculoParaReparo veiculoComum = new VeiculoParaReparo();

        //Coloca 71% de dano no veículo
        veiculoComum.setPorcentagemDano(71);

        //Cria o serviço de reparo para o veículo comum
        ReparoVeiculoService rpc = new ReparoVeiculoComumServiceComTemplateMethod(veiculoComum);

        //Chama o mét odo de reparo
        rpc.reparaVeiculo();
    }
}
