package Objetos;

import java.io.Serializable;

public class Medicao implements Serializable {

    private String idmedicacao;
    private String tipo;
    private String valor;
    private String unidades;

    public String getIdmedicacao() {
        return idmedicacao;
    }

    public void setIdmedicacao(String idmedicacao) {
        this.idmedicacao = idmedicacao;
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

}
