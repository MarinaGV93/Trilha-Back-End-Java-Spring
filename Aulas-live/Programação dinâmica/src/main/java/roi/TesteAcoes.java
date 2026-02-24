package roi;

import java.util.*;

public class TesteAcoes {
    public static void main(String[] args){
        int volumeAcoes = 35;
        int orcamentoTotal = 200;
        List<Acao> acoes = gerarMassaDeDados(volumeAcoes);

        System.out.println("Processando " + volumeAcoes + " ações. Orçamento: " + orcamentoTotal + "k\n");

        //Execução Ruim
        OtimizacaoRuim ruim = new OtimizacaoRuim();
        long inicioRuim = System.nanoTime();
        int maxRuim = ruim.calcularMaximo(acoes, orcamentoTotal, acoes.size() - 1);
        long fimRuim= (System.nanoTime());
        System.out.printf("[ABORDAGEM RUIM] Score Máximo: %d | Tempo: %.2f ms%n", maxRuim, (fimRuim - inicioRuim) / 1_000_000.0);

        //Execução Otimizada
        OtimizadorDinamico dinamico = new OtimizadorDinamico();
        long inicioDin = System.nanoTime();
        int maxDin = dinamico.calcularMaximo(acoes, orcamentoTotal, acoes.size() - 1);
        long fimDin = System.nanoTime();
        System.out.printf("[ABORDAGEM DINÂMICA] Score Máximo: %d | Tempo: %.2f ms%n", maxDin, (fimDin - inicioDin) / 1_000_000.0);
    }

    private static List<Acao> gerarMassaDeDados(int quantidade){
        List<Acao> lista = new ArrayList<>();
        Random rng = new Random(42); //Seed fixa para previsibilidade no benchmark
        Prioridade[] prioridades = Prioridade.values();

        for (int i = 0; i < quantidade; i++){
            lista.add(new Acao(
                    "ACT-" +i,
                    rng.nextInt(40) + 5, //Custo entre 5 e 45
                    rng.nextInt(100) + 10, //ROI entre 10 e 110
                    prioridades[rng.nextInt(prioridades.length)]
            ));
        }
        return lista;
    }
}
