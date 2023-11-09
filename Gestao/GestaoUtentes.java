package Gestao;

import Objetos.Profissional;
import Objetos.Utente;
import exception.IdAlreadyExists;

import java.io.Serializable;
import java.util.*;

public class GestaoUtentes implements Serializable {
    private List<Utente> Utentes;
    private Map<String,Utente> utentesPorId;
    private Map<String, Profissional> medicosPorId;
    public GestaoUtentes() {             //construtor
        this.utentesPorId = new HashMap<>();
        this.medicosPorId = new HashMap<>();
        this.Utentes = new ArrayList<>();
    }

    public void addUtente(Utente u) throws IdAlreadyExists {
        Utentes.add(u);
        if(! utentesPorId.containsKey(u.getId())) {
            utentesPorId.put(u.getId(), u);
        }
        else {
            throw new IdAlreadyExists();
        }
    }






}
