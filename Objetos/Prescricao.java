package Trabalho_AD_JAVA.Objetos;

public class Prescricao {
    private String idp;
    private String nome_medicamento;
    private String inicio_toma;
    private String duracao;
    private String dose_diaria;
    private String id_medico;
    private String id_utente;

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
}
