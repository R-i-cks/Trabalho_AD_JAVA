package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Profissional implements Serializable {

    private String especialidade;
    private List<String> Consultas = new ArrayList<>();
    private List<String> Prescricoes = new ArrayList<>();

    public List<String> getPrescricoes() {
        return Prescricoes;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<String> getConsultas() {
        return Consultas;
    }

    public void addConsulta(String id) {
        Consultas.add(id);
    }

    public void addPrescricao(String id) {
        Prescricoes.add(id);
    }

    @Override
    public String toString() {
        return "[Medico > id: " + getId() + ", nome: " + getNome() + ", especialidade: " + especialidade + "]";
    }
}