/*
    EAGER -> assim que a classe for carregada, o carregador de classes (classloader), vai carregar a classe e ja inicializa os atributos.
 */
package Singleton.solucao;

import java.util.HashMap;
import java.util.Map;

public class AgendaSingletonEAGER {

    //Atributo estatico (só tera 1 na memoria)
    //final -> Garante que não pode ser alterada
    // Instancia
    private static final AgendaSingletonEAGER INSTANCE = new AgendaSingletonEAGER();

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();

    //Adicionar no Map
    private AgendaSingletonEAGER(){
        diasDisponiveis.put("Domingo", Boolean.TRUE);
        diasDisponiveis.put("Segunda", Boolean.TRUE);
        diasDisponiveis.put("Terça", Boolean.TRUE);
        diasDisponiveis.put("Quarta", Boolean.TRUE);
        diasDisponiveis.put("Quinta", Boolean.TRUE);
        diasDisponiveis.put("Sexta", Boolean.TRUE);
        diasDisponiveis.put("Sábado", Boolean.TRUE);
    }

    //Obter a instancia
    public static AgendaSingletonEAGER getInstance(){
        return INSTANCE;
    }

    public Map<String, Boolean> getDias() {
        return diasDisponiveis;
    }

   //Recebe uma string e faz um replace, que substitui o valor
    public void ocupa(String dia){
        diasDisponiveis.replace(dia, Boolean.FALSE);
    }
}
