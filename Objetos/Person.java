package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -8778211987477324203L;
    private String id;
    private String nome;
    private String contacto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
