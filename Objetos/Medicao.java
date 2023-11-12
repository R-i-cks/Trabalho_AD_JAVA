package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Medicao implements Serializable {

    private String idmedicao;
    private String tipo;
    private String valor;
    private String unidades;
    private String id_utente;

    public String getIdmedicao() {
        return idmedicao;
    }

    public void setIdmedicao(String idmedicao) {
        this.idmedicao = idmedicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
    public String getId_utente(){return id_utente;}
    public void setId_utente(String id_utente){this.id_utente = id_utente;}

    @Override
    public String toString() {
        return "[Medicao > id: " + getIdmedicao() + ", utente: " + id_utente+ "]";
    }
}
