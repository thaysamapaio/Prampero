/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class Pessoas {
    private String nome;
    private int idade;

    public Pessoas() {
        this.nome="Prampero";
        this.idade=123;
    }

    public Pessoas(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if(nome.length()>=2)
            this.nome = nome;
        else 
            throw new Exception("Nome muito pequeno.");
    }
    
    public void setIdade(int idade) throws Exception  {
        if((idade>0)&&(idade<200))
            this.idade = idade;
        else
            throw new Exception("Idade somente entre [1,199].");
    }
    
    public void setIdade (String idade) throws Exception {
        this.setIdade(Integer.parseInt(idade));
    }
     
}
