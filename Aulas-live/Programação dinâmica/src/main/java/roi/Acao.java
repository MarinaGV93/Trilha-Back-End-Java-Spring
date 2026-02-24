package roi;
/*Cada Ação (pequeno projeto) possui 3 atributos essenciais. O objetivo é selecionar o conjunto de ações que maximiza o ROI total sem ultrapassar o orçamento disponivel
Custo = Quanto a ação consome do orçamento disponivel
roi.Prioridade = Nível de importancia definido pelo gerente (1 a 3)
ROI = Retorno sobre o investimento esperado ao concluir a ação
* */

//Record = uma classe que também vai ter atributos que são utilizados somente para leitura (não modifica um estado dele) e ele vai ter formas de acessar os atributos, sem precisar declarar gets...
public record Acao(String id, int custo, int roi, Prioridade prioridade) {
    //O Financeiro exige maximizar o ROI, mas o negócio exige respeitar a prioridade.
    //O Valor Efetivo compõe ambas as restrições em um único score
    public int getValorEfetivo(){
        return roi * prioridade.peso;
    }
}
