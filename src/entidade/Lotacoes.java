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
public class Lotacoes {

    public static String lotacao(String lotacao) {

    switch (lotacao) {
            case "0":
                return null;
            case "MOV-GLGE":
                return "GLGE";
            case "MOV-FCOM":
                return "TRPA";
            case "MOV-UMB":
                return "UMB";
            case "MOV-UMC":
                return "UMC";
            case "MOV-UMF":
                return "UMF";
            case "MOV-UMJ":
                return "UMJ";
            case "MOV-UML":
                return "UML";
            case "MOV-UMS":
                return "UMS";
            case "MOV-UNA":
                return "UNA";
            case "MOV-UNB":
                return "UNB";
            case "MOV-UNE":
                return "UNE";
            case "MOV-UNF":
                return "UNF";
            case "MOV-UNI":
                return "UNI";
            case "MOV-UNP":
                return "UNP";
            case "MOV-UNS":
                return "UNS";            
            case "MOV-USA":
                return "USA";
            case "MOV-USC":
                return "USC";
            case "MOV-USI":
                return "USI";
            case "MOV-USJ":
                return "USJ";
            case "MOV-USU":
                return "USU";
            case "MOV-USV":
                return "USV";
            default: 
                return "TRPA";
        }       
    }

}
