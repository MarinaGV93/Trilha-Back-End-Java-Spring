package TemplateMethod.solucao;

import TemplateMethod.VeiculoParaReparo;

public class ReparoVeiculoComumServiceComTemplateMethod extends ReparoVeiculoService{
    private VeiculoParaReparo veiculoParaReparo;

    public ReparoVeiculoComumServiceComTemplateMethod(VeiculoParaReparo veiculoParaReparo) {
        this.veiculoParaReparo = veiculoParaReparo;
    }

    protected boolean veiculoParaReparo() {
        return veiculoParaReparo.getPorcentagemDano() <= 70;
    }

    protected void entradaOfinina() {
        System.out.println("Entrando na oficina, meu carro é simples mas esta quitado");
    }
}
