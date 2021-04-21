/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author e127787
 */
public class Usuario {
    
    private String matricula;
    private String nome;
    private String lotacao;

    public Usuario(String matricula, String nome, String lotacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.lotacao = lotacao;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getLotacao() {
        return lotacao;
    }

    
    
}
