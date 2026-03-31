/*
Uma camada que terá antes do Repository.
Service -> Proxy -> Repository
 */

package Proxy.solucao;

import Builder.Pessoa;
import Proxy.PessoaRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

//Implementa a interface ProxyPessoa
public class PessoaRepositoryProxy extends PessoaRepository implements ProxyPessoa{

    //Logger chamando o nome da classe
    private static Logger logg = Logger.getLogger(PessoaRepository.class.getName());

    //Criar o cache
    private Map<Long, Pessoa> cache= new HashMap<>();

    //Sobrescreve os métodos
    @Override
    public void save(Pessoa pessoa) {

        //Log
        logg.info("Iniciando chamada do método save");

        //Classe de serviço (pai)
        super.save(pessoa);
        logg.info("Chamada do método save finalizada");
    }

    @Override
    public Pessoa findById(Long id) {
        logg.info("Iniciando chamada do método findById");

        //Medir o tempo de execução
        long inicio = System.currentTimeMillis();

        Pessoa pessoa  = null;

        //Se o objeto existe no cache
        if (Objects.nonNull(cache.get(id))){
            logg.info("Está pegando do cache");

            // Pega do cache
            pessoa = cache.get(id);

        //Se não estiver no cache
        } else {
            logg.info("Está pegando do PessoaRepository");

            //Faz a chamada do banco de dados
            pessoa = super.findById(id);


            //Coloca no cache
            // cache.put(id, pessoa);
        }
        pessoa = super.findById(id);
        logg.info("Chamada do método findById finalizada");
        // return pessoa;

        long fim = System.currentTimeMillis();
        logg.info("Tempo gasto na chamada: " + (fim - inicio));
        return pessoa;
    }
}
