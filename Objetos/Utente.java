package Objetos;

import java.io.Serializable;
import java.util.*;
public class Utente extends Person implements Serializable {

    private String data_nascimento;
    private String genero;
    private List<Exames> Exames;

    private List<Consulta> Consultas;
    private List<Prescricao> Prescricao;

    private List<Medicoes> Medicoes;

    public Objetos.Medicoes getMedicoes() {
        return (Objetos.Medicoes) Medicoes;
    }

    public void setMedicoes(List<Medicoes> medicoes) {
        Medicoes = medicoes;
    }

    public Objetos.Prescricao getPrescricao() {
        return (Objetos.Prescricao) Prescricao;
    }

    public void setPrescricao(List<Prescricao> prescricao) {
        Prescricao = prescricao;
    }

    public void setConsultas(List<Consulta> Consultas) {
        Consultas = Consultas;
    }

    public Consulta getConsultas() {
        return (Consulta) Consultas;
    }

    public Objetos.Exames getExames() {
        return (Objetos.Exames) Exames;
    }

    public void setExames(List<Exames> exames) {
        Exames = exames;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
