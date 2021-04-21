package entidade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author E127787
 */
public class Hidrometro {

    public Hidrometro(String lacre, String hidrometro) {
        this.lacre = lacre;
        this.hidrometro = hidrometro;
    }

    public String getLacre() {
        return lacre;
    }

    public void setLacre(String lacre) {
        this.lacre = lacre;
    }

    public String getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(String hidrometro) {
        this.hidrometro = hidrometro;
    }
    
    private String lacre;
    private String hidrometro;
}
