package Trabalho_AD_JAVA.Gestao;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.app.GestaoUtentesInterface;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestaoDados implements Serializable, GestaoUtentesInterface {
    private static final long serialVersionUID = 2271773781997413728L;
    private List<Utente> utentes;
    private List<Profissional> profissionais;

    //
    private List<Consulta>  consultas;
    private List<Exame> exames;
    private List<Medicao> medicaos;
    private List<Prescricao> prescricaos;

    //
    private Map<String, Utente> utentesPorId;
    private Map<String, Profissional> profissionaisPorId;
    private Map<String, Familiar> familiaresPorId;




    public GestaoDados() {
        this.utentes = new ArrayList<>();
        this.utentesPorId = new HashMap<>();
        this.profissionaisPorId = new HashMap<>();
        this.profissionais = new ArrayList<>();
        this.familiaresPorId = new HashMap<>();

        this.readExternalData();

        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
        this.medicaos = new ArrayList<>();
        this.prescricaos = new ArrayList<>();
    }

    private void readExternalData() {
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

    //acho q nao ha exceptions (a nao ser que seja para por cenas relacionadas com as datas e assim?
    //Secalhar de serem so os medicos a darem consultas ou algo do genero?
    //e preciso meter na interface e depois importar para o cliente
    public void addConsulta(Consulta c){
        consultas.add(c);

    }

    public void addExame(Exame e){
        exames.add(e);
    }

    public void addPrescricao(Prescricao pre){
        prescricaos.add(pre);

    }

    public void addMedicao(Medicao medicao){
        medicaos.add(medicao);
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
        Medico resultado = (Medico) profissionaisPorId.get(id);
        if (resultado != null) {                                 // se encontrou, atualiza genero
            lc = resultado.getConsultas();
        }
        else {
            throw new ObjectNotFound();
        }
        return lc;
    }


    public List<Prescricao> encontraPrescricao_medico(String id) throws ObjectNotFound {
        List<Prescricao> lc = new ArrayList<>();
        Medico resultado = (Medico) profissionaisPorId.get(id);
        if (resultado != null) {                                 // se encontrou, atualiza genero
            lc = resultado.getPrescricoes();
        }
        else {
            throw new ObjectNotFound();
        }
        return lc;
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

    public boolean alterarEspecialidade_Medico(String id, String especialidade) throws ObjectNotFound {
        boolean res;
        Medico resultado = (Medico) profissionaisPorId.get(id);
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






