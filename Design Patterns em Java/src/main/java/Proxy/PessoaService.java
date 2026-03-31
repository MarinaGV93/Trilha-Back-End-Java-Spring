/*
Classe de serviço
 */

package Proxy;

import Builder.Pessoa;
import Proxy.solucao.PessoaRepositoryProxy;
import Proxy.solucao.ProxyPessoa;

public class PessoaService {
    // private PessoaRepositoryProxy pessoaRepositoryProxy;

    private ProxyPessoa proxyPessoa;

    public PessoaService(ProxyPessoa proxyPessoa){
        this.proxyPessoa = proxyPessoa;
    }

    //Salva uma pessoa no banco de dados
    public void save(Pessoa pessoa){
        proxyPessoa.save(pessoa);
    }

    public Pessoa findById(Long id){
        return proxyPessoa.findById(id);
    }
}
