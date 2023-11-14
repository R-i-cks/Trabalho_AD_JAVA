package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.*;
public class Utente extends Person implements Serializable {

    private static final long serialVersionUID = 4446909773217803202L;
    private String data_nascimento;
    private String genero;

    private List<String> Exames = new ArrayList<>();
    private List<String> Consultas = new ArrayList();
    private List<String> Prescricoes = new ArrayList<>();
    private List<String> Medicoes = new ArrayList();

    public List<String> getMedicoes() {
        return Medicoes;
    }

    public List<String> getPrescricoes() {
        return Prescricoes;
    }

    public void addConsulta(String id) {
        Consultas.add(id);
    }

    public void addMedicao(String id) {
        Medicoes.add(id);
    }

    public void addPrescricao(String id) {
        Prescricoes.add(id);
    }

    public void addExame(String id) {
        Exames.add(id);
    }

    public List<String> getConsultas() {
        return Consultas;
    }

    public List<String> getExames() {
        return Exames;
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

    @Override
    public String toString() {
        return "[Utente > id: " + super.getId() + ", nome: " + super.getNome() + "]";
    }
}