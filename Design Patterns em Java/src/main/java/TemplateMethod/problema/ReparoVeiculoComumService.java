package TemplateMethod.problema;

import TemplateMethod.VeiculoParaReparo;

public class ReparoVeiculoComumService {
    private VeiculoParaReparo veiculoParaReparo;

    public ReparoVeiculoComumService(VeiculoParaReparo veiculoParaReparo) {
        this.veiculoParaReparo = veiculoParaReparo;
    }

    public void reparaVeiculo() {
        entradaOfinina();
        analisarDanos();
        if (veiculoParaReparo()){
            repararVeiculo();
            notificarReparoParaSeguradora();
        } else {
            notificarPerdaTotalParaSeguradora();
        }
    }

    private boolean veiculoParaReparo() {
        return veiculoParaReparo.getPorcentagemDano() <= 70;
    }

    private void notificarPerdaTotalParaSeguradora() {
        System.out.println("Notificando perda total para a seguradora");
    }

    private void notificarReparoParaSeguradora(){
        System.out.println("Notificando reparo para a seguradora");
    }

    private void repararVeiculo() {
        System.out.println("Reparando veiculo");
    }

    private void analisarDanos() {
        System.out.println("Analisando danos");
    }

    private void entradaOfinina() {
        System.out.println("Veículo entrando na oficina");
    }
}