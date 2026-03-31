/*
    LAZY -> sempre que chamar a primeira vez, ele verifica se a instancia existe, se não, cria. Nas outras vezes, verá que a instancia já existe. Só vai criar a instancia, quando chamar o getInstance().
 */
package Singleton.solucao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AgendaSingletonLAZY {

    //Atributo estatico (só tera 1 na memoria)
    // Instancia
    private static  AgendaSingletonLAZY INSTANCE = null;

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();

    //Adicionar no Map
    private AgendaSingletonLAZY(){
        diasDisponiveis.put("Domingo", Boolean.TRUE);
        diasDisponiveis.put("Segunda", Boolean.TRUE);
        diasDisponiveis.put("Terça", Boolean.TRUE);
        diasDisponiveis.put("Quarta", Boolean.TRUE);
        diasDisponiveis.put("Quinta", Boolean.TRUE);
        diasDisponiveis.put("Sexta", Boolean.TRUE);
        diasDisponiveis.put("Sábado", Boolean.TRUE);
    }

    //Obter a instancia
    public static AgendaSingletonLAZY getInstance(){

        //Se a INSTANCE for nula
        if (Objects.isNull(INSTANCE)){

            //Cria uma instancia
            INSTANCE = new AgendaSingletonLAZY();

            return INSTANCE;
        }
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
