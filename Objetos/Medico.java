package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.List;

public class Medico extends Profissional implements Serializable {

    private String especialidade;
    private List<Consulta> Consultas;
    private List<Medicao> Medicoes;
    private List<Prescricao> Prescricoes;

    public void setPrescricoes(List<Prescricao> prescricoes) {
        Prescricoes = prescricoes;
    }

    public List<Prescricao> getPrescricoes() {
        return Prescricoes;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas() {
        return Consultas;
    }

    public List<Medicao> getMedicoes() {
        return Medicoes;
    }

    public void setMedicoes(List<Medicao> medicoes) {
        Medicoes = medicoes;
    }

    public void setConsultas(List<Consulta> consultas) {
        Consultas = consultas;
    }
}