package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Prescricao implements Serializable {

    private static final long serialVersionUID = 6613806181233316896L;
    private String idp;
    private String nome_medicamento;
    private String inicio_toma;
    private String duracao;
    private String dose_diaria;
    private String id_medico;
    private String id_utente;

    public Prescricao(String idp, String nome_medicamento, String inicio_toma, String duracao, String dose_diaria, String id_medico, String id_utente) {
        this.idp = idp;
        this.id_medico = id_medico;
        this.id_utente = id_utente;
        this.nome_medicamento = nome_medicamento;
        this.inicio_toma = inicio_toma;
        this.duracao = duracao;
        this.dose_diaria = dose_diaria;
    }

    public Prescricao() {

    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public String getInicio_toma() {
        return inicio_toma;
    }

    public void setInicio_toma(String inicio_toma) {
        this.inicio_toma = inicio_toma;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDose_diaria() {
        return dose_diaria;
    }

    public void setDose_diaria(String dose_diaria) {
        this.dose_diaria = dose_diaria;
    }
    public String getId_medico(){return id_medico;}
    public void setId_medico(String id_medico){this.id_medico = id_medico;}
    public String getId_utente(){return id_utente;}
    public void setId_utente(String id_utente){this.id_utente = id_utente;}

    @Override
    public String toString() {
        return "[Prescricao > id: " + getIdp() + ", utente: " + id_utente + ", medico: " + id_medico + ", medicamento: " + nome_medicamento + "]";
    }
}
