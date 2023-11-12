package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.*;
public class Utente extends Person implements Serializable {

    private String data_nascimento;
    private String genero;

    private List<Exame> Exames;
    private List<Consulta> Consultas;
    private List<Prescricao> Prescricoes;
    private List<Medicao> Medicoes;


    public List<Medicao> getMedicoes() { return Medicoes; }

    public void setMedicoes(List<Medicao> medicoes) {
        Medicoes = medicoes;
    }

    public List<Prescricao> getPrescricoes() {
        return Prescricoes;
    }

    public void setPrescricoes(List<Prescricao> prescricoes) {
        Prescricoes = prescricoes;
    }

    public void setConsultas(List<Consulta> consultas) {
        Consultas = consultas;
    }

    public List<Consulta> getConsultas() {
        return  Consultas;
    }

    public List<Exame> getExames() {
        return Exames;
    }

    public void setExames(List<Exame> exames) {
        Exames = exames;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String Data_nascimento) {
        this.data_nascimento = Data_nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
