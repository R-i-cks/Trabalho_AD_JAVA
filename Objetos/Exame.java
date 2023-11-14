package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Exame implements Serializable {
    private static final long serialVersionUID = -5845602409231319927L;
    private String id_exame;
    private String data_realizacao;
    private String nome_exame;
    private String resultado;
    private String id_utente;

    public Exame(String id_exame, String data_realizacao, String nome_exame, String resultado, String id_utente) {
        this.id_exame = id_exame;
        this.data_realizacao = data_realizacao;
        this.id_utente = id_utente;
        this.nome_exame = nome_exame;
        this.resultado = resultado;
    }

    public Exame() {

    }

    public String getId_exame() {
        return id_exame;
    }

    public void setId_exame(String id_exame) {
        this.id_exame = id_exame;
    }

    public String getData_realizacao() {
        return data_realizacao;
    }

    public void setData_realizacao(String data_realizacao) {
        this.data_realizacao = data_realizacao;
    }

    public void setNome_exame(String nome_exame) {
        this.nome_exame = nome_exame;
    }

    public String getNome_exame() {
        return nome_exame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getId_utente(){return id_utente;}
    public void setId_utente(String id_utente){this.id_utente = id_utente;}

    @Override
    public String toString() {
        return "[Exame > id: " + getId_exame() + ", utente: " + id_utente+ "]";
    }
}
