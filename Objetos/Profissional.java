package Objetos;

import java.io.Serializable;
import java.util.List;
public class Profissional extends Person implements Serializable {
    private String especialidade;
    private List<Consulta> Consultas;
    private List<Medicoes> Medicoes;
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

    public List<Medicoes> getMedicoes() {
        return Medicoes;
    }

    public void setMedicoes(List<Medicoes> medicoes) {
        Medicoes = medicoes;
    }

    public void setConsultas(List<Consulta> consultas) {
        Consultas = consultas;
    }
}