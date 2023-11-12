package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Exame implements Serializable {
    private String id_exame;
    private String data_realizacao;
    private String nome_exame;
    private String resultado;
    private String id_utente;

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
}
