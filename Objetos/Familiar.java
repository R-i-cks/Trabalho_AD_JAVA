package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.util.List;

public class Familiar extends Person implements Serializable {
    private static final long serialVersionUID = 6444151406029224495L;
    private List<String> utentes;

    public List<String> getUtentes() {
        return utentes;
    }

    public void setUtentes(List<String> utentes) {
        this.utentes = utentes;
    }

    @Override
    public String toString() {
        return "[Familiar > id: " + getId() + ", nome: " + getNome()+ "]";
    }
}
