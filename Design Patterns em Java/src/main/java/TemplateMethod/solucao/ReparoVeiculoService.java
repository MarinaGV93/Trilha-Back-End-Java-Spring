package TemplateMethod.solucao;

//Nao vai ser instanciado
//Vai ser somente um template para os serviços de reparo
public abstract class ReparoVeiculoService {
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

    //Protegido para implementar na subclasse (filha)
    protected abstract boolean veiculoParaReparo();

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
