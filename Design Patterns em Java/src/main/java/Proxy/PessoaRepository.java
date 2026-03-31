/*
Faz um meio de campo com o Banco de Dados (antigamente era DAO)
 */

/*
Lugar ideal para adicionar logs, é na classe que tem a responsabilidade (lógica de negócio)
 */

package Proxy;

import Builder.Pessoa;

import java.util.HashMap;
import java.util.Map;

public class PessoaRepository {
    private Map<Long, Pessoa> banco = new HashMap<>();
    private static Long countId = 1L;

    //Salva uma pessoa no banco de dados
    public void save(Pessoa pessoa){
        banco.put(countId++, pessoa);
    }

    //Espera 3 segundos e pega o objeto do banco
    //Simula um banco de dados
    public Pessoa findById(Long id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return banco.get(id);
    }
}