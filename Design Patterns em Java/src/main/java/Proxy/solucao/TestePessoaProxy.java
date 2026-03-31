/*
Vantagem:
    Uma camada para fazer questoes de persistencias, tratar a persistencia.
 */

/*
Quando pensar em auditoria, usar o Logger
Quando pensar em performance, usar o Cache
Se nao puder mexer na classe, usar o Proxy
 */

package Proxy.solucao;

import Builder.Pessoa;
import Proxy.PessoaRepository;
import Proxy.PessoaService;

import java.time.LocalDate;

public class TestePessoaProxy {
    public static void main(String[] args) {
        PessoaRepositoryProxy pessoaRepositoryProxy = new PessoaRepositoryProxy();
        // PessoaService pessoaService = new PessoaService(new PessoaRepository());

        NovoPessoaRepositoryProxy novoPessoaRepositoryProxy = new NovoPessoaRepositoryProxy();

        //Para passar um novo proxy, precisa criar uma interface, pq em PessoaService esta amarrado em pessoaRepositoryProxy
        // PessoaService pessoaService = new PessoaService(pessoaRepositoryProxy);
        PessoaService pessoaService = new PessoaService(novoPessoaRepositoryProxy);

        //Cria uma pessoa
        Pessoa pessoa = new Pessoa.PessoaBuilder()
                .sobrenome("Ferreira")
                .dataNascimento(LocalDate.of(1990, 01, 01))
                .nome("Marina")
                .apelido("Mah")
                .documento("123456789")
                .build();

        //Salva a pessoa
        pessoaService.save(pessoa);

        //Busca a pessoa
        Pessoa pessoaRetornada = pessoaService.findById(1L);

        //Imprime a pessoa
        System.out.println(pessoaRetornada);

        //Busca a pessoa
        Pessoa pessoaRetornadaCache = pessoaService.findById(1L);

        //Imprime a pessoa
        System.out.println(pessoaRetornadaCache);
    }
}
