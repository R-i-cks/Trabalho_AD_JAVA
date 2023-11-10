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
    private Map<String, Profissional> profissionaisPorId;
    private Map<String, Familiar> familiaresPorId;




    public GestaoDados() {
        this.utentes = new ArrayList<>();
        this.utentesPorId = new HashMap<>();
        this.profissionaisPorId = new HashMap<>();
        this.profissionais = new ArrayList<>();
        this.familiaresPorId = new HashMap<>();
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

    public void addFamiliar(Familiar f) throws IdAlreadyExists {
        if(! familiaresPorId.containsKey(f.getId())) {
            familiaresPorId.put(f.getId(), new Familiar());
        }
        else {
            throw new IdAlreadyExists();
        }
    }

    public void addProfissional(Profissional p) throws IdAlreadyExists {
        if(! profissionaisPorId.containsKey(p.getId())) {
            profissionaisPorId.put(p.getId(), new Profissional());
        }
        else {
            throw new IdAlreadyExists();
        }
    }

    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound {
        List<Consulta> lc;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            lc = resultado.getConsultas();
        }
        else {
            throw new ObjectNotFound();
        }
        return lc;
    }

    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound {
        List<Prescricao> lp;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            lp = resultado.getPrescricoes();
        }
        else {
            throw new ObjectNotFound();
        }
        return lp;
    }

    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound {
        List<Medicao> lm;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            lm = resultado.getMedicoes();
        }
        else {
            throw new ObjectNotFound();
        }
        return lm;
    }


    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound {
        List<Exame> le;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            le = resultado.getExames();
        }
        else {
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
        boolean res;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            resultado.setNome(nome);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarGenero_utente(String id, String genero) throws ObjectNotFound {
        boolean res;
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {                                 // se encontrou, atualiza genero
            resultado.setGenero(genero);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarContacto_utente(String id, String contacto) throws ObjectNotFound {
        boolean res;
        Utente resultado = utentesPorId.get(id);
        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarContacto_Profissional(String id, String contacto) throws ObjectNotFound {
        boolean res;
        Profissional resultado = profissionaisPorId.get(id);
        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarNome_Profissional(String id, String nome) throws ObjectNotFound {
        boolean res;
        Profissional resultado = profissionaisPorId.get(id);
        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarEspecialidade_Profissional(String id, String especialidade) throws ObjectNotFound {
        boolean res;
        Profissional resultado = profissionaisPorId.get(id);
        if (resultado != null) {
            resultado.setEspecialidade(especialidade);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarContacto_Familiar(String id, String contacto) throws ObjectNotFound {
        boolean res;
        Familiar resultado = familiaresPorId.get(id);
        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarNome_Familiar(String id, String nome) throws ObjectNotFound {
        boolean res;
        Familiar resultado = familiaresPorId.get(id);
        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarDataConsulta_utente(String idu, String idc, String data) throws ObjectNotFound {
        boolean res = false;
        Utente resultado = utentesPorId.get(idu);
        if (resultado != null) {
            for (Consulta c : resultado.getConsultas()) {
                if (c.getId_consulta().equals(idc)) {
                    c.setData(data);
                    res = true;
                }
            }
        }
        else {
            throw new ObjectNotFound();
        }
        return res;
    }

    }






