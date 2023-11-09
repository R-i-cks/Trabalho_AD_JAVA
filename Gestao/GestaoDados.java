package Gestao;

import Objetos.*;
import exception.IdAlreadyExists;
import exception.ObjectNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestaoDados {
    private List<Utente> utentes;
    private List<Profissional> profissionais;
    private Map<String, Utente> utentesPorId;
    private Map<String, Profissional> medicosPorId;
    private List<Consulta> consultas;



    public GestaoDados() {
        this.utentes = new ArrayList<>();
        this.utentesPorId = new HashMap<>();
        this.medicosPorId = new HashMap<>();
        this.profissionais = new ArrayList<>();
    }


    public void addUtente(Utente u) throws IdAlreadyExists {
        if(! utentesPorId.containsKey(u.getId())) {
            utentes.add(u);
            utentesPorId.put(u.getId(), new Utente());
        }
        else {
            throw new IdAlreadyExists();
        }
    }

    public void addProfissional(Profissional p) throws IdAlreadyExists {
        if(! medicosPorId.containsKey(p.getId())) {
            medicosPorId.put(p.getId(), new Profissional());
        }
        else {
            throw new IdAlreadyExists();
        }
    }

    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound {
        List<Consulta> lc = new ArrayList<>();
        for (Utente u: utentes) {
            if (u.getId().equals(id)){
                lc.add(u.getConsultas());
            }
        }
        if (lc.size()==0) {
            throw new ObjectNotFound();
        }
        return lc;
    }

    public List<Prescricao> encontraPrescricao_utente(String id) throws ObjectNotFound {
        List<Prescricao> lp = new ArrayList<>();
        for (Utente u: utentes) {
            if (u.getId().equals(id)){
                lp.add(u.getPrescricao());
            }
        }
        if (lp.size()==0) {
            throw new ObjectNotFound();
        }
        return lp;
    }

    public List<Medicoes> encontraMedicoes_utente(String id) throws ObjectNotFound {
        List<Medicoes> lm = new ArrayList<>();
        for (Utente u: utentes) {
            if (u.getId().equals(id)){
                lm.add(u.getMedicoes());
            }
        }
        if (lm.size()==0) {
            throw new ObjectNotFound();
        }
        return lm;
    }

    public List<Exames> encontraExames_utente(String id) throws ObjectNotFound {
        List<Exames> le = new ArrayList<>();
        for (Utente u: utentes) {
            if (u.getId().equals(id)){
                le.add(u.getExames());
            }
        }
        if (le.size()==0) {
            throw new ObjectNotFound();
        }
        return le;
    }

    public List<Consulta> encontraConsultas_medico(String id) throws ObjectNotFound {
        List<Consulta> lc = new ArrayList<>();
        for (Profissional p: profissionais) {
            if (p.getId().equals(id)){
                lc.add((Consulta) p.getConsultas());
            }
        }
        if (lc.size()==0) {
            throw new ObjectNotFound();
        }
        return lc;
    }



    public List<Prescricao> encontraPrescricao_medico(String id) throws ObjectNotFound {
        List<Prescricao> lp = new ArrayList<>();
        for (Profissional p: profissionais) {
            if (p.getId().equals(id)){
                lp.add((Prescricao) p.getMedicoes());
            }
        }
        if (lp.size()==0) {
            throw new ObjectNotFound();
        }
        return lp;
    }

    public boolean alterarNome_utente(String id, String nome) throws ObjectNotFound {
        boolean res = false;
        try {
            for (Utente u : utentes) {
                if (u.getId().equals(id)) {
                    u.setNome(nome);
                    res = true;
                }
            }
        }
        catch (ObjectNotFound){
            throw new ObjectNotFound();
        }
        return res;
    }

    public  alterarGenero_utente(String id, String genero) throws ObjectNotFound {
        try {
            for (Utente u : utentes) {
                if (u.getId().equals(id)) {
                    u.setId(nome);
                }
            }
        }
        catch (ObjectNotFound){
            throw new ObjectNotFound();
        };

    }
    }










