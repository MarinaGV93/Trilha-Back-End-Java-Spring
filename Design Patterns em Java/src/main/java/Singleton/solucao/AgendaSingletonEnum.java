/*
    Enum ->
 */
package Singleton.solucao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum AgendaSingletonEnum {

    //Atributo
    INSTANCE;

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();

    //Adicionar no Map
    private AgendaSingletonEnum(){
        diasDisponiveis.put("Domingo", Boolean.TRUE);
        diasDisponiveis.put("Segunda", Boolean.TRUE);
        diasDisponiveis.put("Terça", Boolean.TRUE);
        diasDisponiveis.put("Quarta", Boolean.TRUE);
        diasDisponiveis.put("Quinta", Boolean.TRUE);
        diasDisponiveis.put("Sexta", Boolean.TRUE);
        diasDisponiveis.put("Sábado", Boolean.TRUE);
    }

    public static AgendaSingletonEnum getInstance(){
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
