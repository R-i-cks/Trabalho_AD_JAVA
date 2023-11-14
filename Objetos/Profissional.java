package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.List;
public class Profissional extends Person implements Serializable {
    private static final long serialVersionUID = -578227530275157667L;
    private String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[Profissional > id: " + getId() + ", tipo: " + type + ", nome: " + getNome()+ "]";
    }
}

