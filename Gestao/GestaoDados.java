package Trabalho_AD_JAVA.Gestao;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.app.*;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestaoDados implements Serializable, GestaoUtentesInterface, GestaoMedicosInterface, GestaoEnfermeirosInterface, GestaoAuxiliarInterface, GestaoFamiliarInterface {
    private static final long serialVersionUID = 2271773781997413728L;
    private Map<String, Utente> utentesPorId;
    private Map<String, Medico> medicosPorId;
    private Map<String, Profissional> profissionaisPorId;
    private Map<String, Familiar> familiaresPorId;
    private Map<String, Consulta> consultasPorId;
    private Map<String, Prescricao> prescricoesPorId;
    private Map<String, Medicao> medicoesPorId;
    private Map<String, Exame> examesPorId;

    public GestaoDados() {
        this.utentesPorId = new HashMap<>();
        this.medicosPorId = new HashMap<>();
        this.familiaresPorId = new HashMap<>();
        this.profissionaisPorId = new HashMap<>();

        this.medicoesPorId = new HashMap<>();
        this.prescricoesPorId = new HashMap<>();
        this.consultasPorId = new HashMap<>();
        this.examesPorId = new HashMap<>();
    }


    public void addUtente(Utente u) throws IdAlreadyExists {
        if (!utentesPorId.containsKey(u.getId())) {
            utentesPorId.put(u.getId(), u);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addFamiliar(Familiar f) throws IdAlreadyExists {
        if (!familiaresPorId.containsKey(f.getId())) {
            familiaresPorId.put(f.getId(), f);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addMedico(Profissional p) throws IdAlreadyExists {
        if (!medicosPorId.containsKey(p.getId())) {
            medicosPorId.put(p.getId(), (Medico) p);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addProfissional(Profissional p) throws IdAlreadyExists {
        if (!profissionaisPorId.containsKey(p.getId())) {
            profissionaisPorId.put(p.getId(), p);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addConsulta(Consulta c) throws IdAlreadyExists {
        if (!consultasPorId.containsKey(c.getId_consulta())) {
            consultasPorId.put(c.getId_consulta(), c);
            String idUtente = c.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addConsulta(c.getId_consulta());

            String idMedico = c.getIdMedico();
            Medico m = medicosPorId.get(idMedico);
            m.addConsulta(c.getId_consulta());
        } else {
            throw new IdAlreadyExists();
        }
        System.out.println(c);
    }

    public void addExame(Exame e) throws IdAlreadyExists {
        if (!examesPorId.containsKey(e.getId_exame())) {
            examesPorId.put(e.getId_exame(), e);

            String idUtente = e.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addExame(e.getId_exame());

        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addPrescricao(Prescricao pre) throws ObjectNotFound, IdAlreadyExists {
        if (!prescricoesPorId.containsKey(pre.getIdp())) {
            prescricoesPorId.put(pre.getIdp(), pre);

            String idUtente = pre.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addPrescricao(pre.getIdp());

            String idMedico = pre.getId_medico();
            Medico m = medicosPorId.get(idMedico);
            m.addPrescricao(pre.getIdp());
        } else {
            throw new IdAlreadyExists();
        }
    }

    public void addMedicao(Medicao medicao) throws ObjectNotFound, IdAlreadyExists {
        if (!medicoesPorId.containsKey(medicao.getIdmedicao())) {
            medicoesPorId.put(medicao.getIdmedicao(), medicao);

            String idUtente = medicao.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addMedicao(medicao.getIdmedicao());
        } else {
            throw new IdAlreadyExists();
        }
    }

    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound {
        List<Consulta> lc = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsConsultas = resultado.getConsultas();

            for (String idConsulta : idsConsultas) {
                lc.add(consultasPorId.get(idConsulta));
            }
        } else {
            throw new ObjectNotFound();
        }
        return lc;
    }

    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound {
        List<Prescricao> lp = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsPrescricoes = resultado.getPrescricoes();

            for (String idPrescricao : idsPrescricoes) {
                lp.add(prescricoesPorId.get(idPrescricao));
            }
        } else {
            throw new ObjectNotFound();
        }
        return lp;
    }

    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound {
        List<Medicao> lm = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);// a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsMedicoes = resultado.getMedicoes();

            for (String idMedicao : idsMedicoes) {
                lm.add(medicoesPorId.get(idMedicao));
            }
        } else {
            throw new ObjectNotFound();
        }
        return lm;
    }

    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound {
        List<Exame> le = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsExames = resultado.getExames();

            for (String idMedicao : idsExames) {
                le.add(examesPorId.get(idMedicao));
            }
        } else {
            throw new ObjectNotFound();
        }
        return le;
    }

    public List<Consulta> encontraConsultas_medico(String id) throws ObjectNotFound {
        List<Consulta> lc = new ArrayList<>();
        Medico resultado = medicosPorId.get(id);
        if (resultado != null) {

            List<String> idsConsultas = resultado.getConsultas();

            for (String idConsulta : idsConsultas) {
                lc.add(consultasPorId.get(idConsulta));
            }
        } else {
            throw new ObjectNotFound();
        }
        return lc;
    }


    public List<Prescricao> encontraPrescricao_medico(String id) throws ObjectNotFound {
        List<Prescricao> lc = new ArrayList<>();
        Medico resultado = medicosPorId.get(id);
        if (resultado != null) {
            List<String> idsPrescricoes = resultado.getPrescricoes();

            for (String idPrescricao : idsPrescricoes) {
                lc.add(prescricoesPorId.get(idPrescricao));
            }
        } else {
            throw new ObjectNotFound();
        }
        return lc;
    }

    public boolean alterarNome_utente(String id, String nome) throws ObjectNotFound {
        boolean res;
        Utente resultado = utentesPorId.get(id);

        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        } else {
            throw new ObjectNotFound();
        }

        return res;
    }


    public boolean alterarGenero_utente(String id, String genero) throws ObjectNotFound {
        boolean res;
        Utente resultado = utentesPorId.get(id);  // a variavel resultado fica com o valor do hashmap com a key id

        if (resultado != null) {
            resultado.setGenero(genero);
            res = true;
        } else {
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
        } else {
            throw new ObjectNotFound();
        }

        return res;
    }

    public boolean alterarContacto_Profissional(String id, String contacto) throws ObjectNotFound {
        boolean res;
        System.out.println(profissionaisPorId.values());
        Profissional resultado = profissionaisPorId.get(id);

        if (resultado == null) {
            resultado = medicosPorId.get(id);
        }
        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        } else {
            throw new ObjectNotFound();
        }

        System.out.println(profissionaisPorId.values());

        return res;
    }
    public boolean alterarNome_Profissional(String id, String nome) throws ObjectNotFound {
        boolean res;
        Profissional resultado = profissionaisPorId.get(id);

        if (resultado == null) {
            resultado = medicosPorId.get(id);
        }

        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        } else {
            throw new ObjectNotFound();
        }
        return res;
    }

    public boolean alterarEspecialidade_Medico(String id, String especialidade) throws ObjectNotFound {
        boolean res;
        Medico resultado = (Medico) medicosPorId.get(id);
        if (resultado != null) {
            resultado.setEspecialidade(especialidade);
            res = true;
        } else {
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
        } else {
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
        } else {
            throw new ObjectNotFound();
        }

        return res;
    }

    public boolean alterarDataConsulta_utente(String idc, String data) throws ObjectNotFound {
        boolean res = false;
        
        Consulta c = consultasPorId.get(idc);

        if (c != null) {
            c.setData(data);
            res = true;
        } else {
            throw new ObjectNotFound();
        }

        return res;
    }

    public Medico medicoComMaisConsultas() {
        int minimo=Integer.MAX_VALUE;
        Medico resultado = null;
        for (Medico m :medicosPorId.values()) {
            if (m.getConsultas().size()<minimo) {
                resultado=m;
                minimo=m.getConsultas().size();
            }
        }
        return resultado;
    }

    public int consultasNumDadoPeriodo(String inicial, String dfinal) {
        int Num = 0;
        for (Consulta c: consultasPorId.values()) {
            String[] data= c.getData().split("/");
            String[] i = inicial.split("/");
            String[] f = dfinal.split("/");
            if (Integer.parseInt(i[2]) <= Integer.parseInt(data[2]) && Integer.parseInt(data[2]) <= Integer.parseInt(f[2])) {
                if (Integer.parseInt(i[1]) <= Integer.parseInt(data[1]) && Integer.parseInt(data[1]) <= Integer.parseInt(f[1])) {
                    if (Integer.parseInt(i[0]) <= Integer.parseInt(data[0]) && Integer.parseInt(data[0]) <= Integer.parseInt(f[0])) {
                        ++Num;
                    }
                }
            }
        }
        return Num;
    }
}

