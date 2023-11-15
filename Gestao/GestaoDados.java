package Trabalho_AD_JAVA.Gestao;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.app.*;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import com.opencsv.CSVWriter;

import java.rmi.RemoteException;
import java.io.FileWriter;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class GestaoDados extends UnicastRemoteObject implements GestaoUtentesInterface, GestaoMedicosInterface, GestaoEnfermeirosInterface, GestaoAuxiliarInterface, GestaoFamiliarInterface {
    //private static final long serialVersionUID = 2271773781997413728L;
    private Map<String, Utente> utentesPorId;
    private Map<String, Medico> medicosPorId;
    private Map<String, Profissional> profissionaisPorId;
    private Map<String, Familiar> familiaresPorId;
    private Map<String, Consulta> consultasPorId;
    private Map<String, Prescricao> prescricoesPorId;
    private Map<String, Medicao> medicoesPorId;
    private Map<String, Exame> examesPorId;

    public GestaoDados() throws RemoteException {
        super();
        this.utentesPorId = new HashMap<>();
        this.medicosPorId = new HashMap<>();
        this.familiaresPorId = new HashMap<>();
        this.profissionaisPorId = new HashMap<>();

        this.medicoesPorId = new HashMap<>();
        this.prescricoesPorId = new HashMap<>();
        this.consultasPorId = new HashMap<>();
        this.examesPorId = new HashMap<>();
    }

    public void load() throws RemoteException {
        if (utentesPorId.isEmpty())
            carregaUtentes();
        if (profissionaisPorId.isEmpty() || medicosPorId.isEmpty())
            carregaProfissionais();
        if (consultasPorId.isEmpty())
            carregaConsultas();
        if (examesPorId.isEmpty())
            carregaExames();
        if (familiaresPorId.isEmpty())
            carregaFamiliares();
        if (medicoesPorId.isEmpty())
            carregaMedicoes();
        if (prescricoesPorId.isEmpty())
            carregaPrescricao();
    }


    public void carregaUtentes() {
        BufferedReader br1 = null;
        try {
            int cnt = 0;
            br1 = new BufferedReader(new FileReader("Dados/utentes.csv"));
            String header = br1.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br1.readLine();
                if (line != null) {
                    String[] columns2 = line.split(";");
                    if (columns2.length != 0) {
                        final Utente u = new Utente();
                        u.setId(columns2[0]);
                        u.setNome(columns2[1]);
                        u.setContacto(columns2[2]);
                        u.setGenero(columns2[3]);
                        u.setData_nascimento(columns2[4]);
                        addUtente(u);
                        ++cnt;
                        System.out.println(u);
                    }

                }
            } while (line != null && cnt < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaProfissionais() {

        BufferedReader br7 = null;
        try {
            int cnt7 = 0;
            try {
                br7 = new BufferedReader(new FileReader("Dados/profissionais.csv"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String header7 = null;
            try {
                header7 = br7.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (header7 != null) {
                String[] columns7 = header7.split(";");
                System.out.println(Arrays.toString(columns7));
            }
            String line7 = null;
            do {
                try {
                    line7 = br7.readLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (line7 != null) {
                    String[] columns8 = line7.split(";");
                    if (columns8.length != 0) {
                        if (Objects.equals(columns8[1], "medico")) {
                            final Medico m = new Medico();
                            m.setId(columns8[0]);
                            m.setType(columns8[1]);
                            m.setNome(columns8[2]);
                            m.setContacto(columns8[3]);
                            m.setEspecialidade(columns8[4]);
                            addMedico(m);
                            System.out.println(m);
                        } else {
                            final Profissional p = new Profissional();
                            p.setId(columns8[0]);
                            p.setType(columns8[1]);
                            p.setNome(columns8[2]);
                            p.setContacto(columns8[3]);
                            addProfissional(p);
                            ++cnt7;
                            System.out.println(p);
                        }
                    }

                }
            } while (line7 != null && cnt7 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaExames() {
        BufferedReader br3 = null;
        try {
            int cnt3 = 0;
            br3 = new BufferedReader(new FileReader("Dados/exames.csv"));
            String header3 = br3.readLine();
            if (header3 != null) {
                String[] columns3 = header3.split(";");
                System.out.println(Arrays.toString(columns3));
            }
            String line3 = null;
            do {
                line3 = br3.readLine();
                if (line3 != null) {
                    String[] columns4 = line3.split(";");
                    if (columns4.length != 0) {
                        final Exame e5 = new Exame();
                        e5.setId_exame(columns4[0]);
                        e5.setId_utente(columns4[1]);
                        e5.setData_realizacao(columns4[2]);
                        e5.setNome_exame(columns4[3]);
                        e5.setResultado(columns4[4]);
                        addExame(e5);
                        ++cnt3;
                        System.out.println(e5);
                    }
                }
            } while (line3 != null && cnt3 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaMedicoes() {
        BufferedReader br5 = null;
        try {
            int cnt5 = 0;
            br5 = new BufferedReader(new FileReader("Dados/medicoes.csv"));
            String header5 = br5.readLine();
            if (header5 != null) {
                String[] columns5 = header5.split(";");
                System.out.println(Arrays.toString(columns5));
            }
            String line5 = null;
            do {
                line5 = br5.readLine();
                if (line5 != null) {
                    String[] columns6 = line5.split(";");
                    if (columns6.length != 0) {
                        final Medicao medicao = new Medicao();
                        medicao.setIdmedicao(columns6[0]);
                        medicao.setId_utente(columns6[1]);
                        medicao.setTipo(columns6[2]);
                        medicao.setValor(columns6[3]);
                        medicao.setUnidades(columns6[4]);
                        addMedicao(medicao);
                        ++cnt5;
                        System.out.println(medicao);
                    }
                }
            } while (line5 != null && cnt5 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void carregaConsultas() {

        BufferedReader br2 = null;
        try {
            int cnt2 = 0;
            br2 = new BufferedReader(new FileReader("Dados/consultas.csv"));
            String header2 = br2.readLine();
            if (header2 != null) {
                String[] columns2 = header2.split(";");
                System.out.println(Arrays.toString(columns2));
            }
            String line2 = null;
            do {
                line2 = br2.readLine();
                if (line2 != null) {
                    String[] columns3 = line2.split(";");
                    if (columns3.length != 0) {
                        final Consulta c = new Consulta();
                        c.setId_consulta(columns3[0]);
                        c.setId_medico(columns3[1]);
                        c.setId_utente(columns3[2]);
                        c.setData(columns3[3]);
                        c.setHora(columns3[4]);
                        c.setUpcs(columns3[5]);
                        addConsulta(c);
                        ++cnt2;
                    }
                }
            } while (line2 != null && cnt2 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void carregaPrescricao() {
        BufferedReader br4 = null;
        try {
            int cnt4 = 0;
            br4 = new BufferedReader(new FileReader("Dados/prescricao.csv"));
            String header4 = br4.readLine();
            if (header4 != null) {
                String[] columns4 = header4.split(";");
                System.out.println(Arrays.toString(columns4));
            }
            String line4 = null;
            do {
                line4 = br4.readLine();
                if (line4 != null) {
                    String[] columns5 = line4.split(";");
                    if (columns5.length != 0) {
                        final Prescricao pres = new Prescricao();
                        pres.setIdp(columns5[0]);
                        pres.setId_medico(columns5[1]);
                        pres.setId_utente(columns5[2]);
                        pres.setNome_medicamento(columns5[3]);
                        pres.setInicio_toma(columns5[4]);
                        pres.setDuracao(columns5[5]);
                        pres.setDose_diaria(columns5[6]);
                        addPrescricao(pres);
                        ++cnt4;
                        System.out.println(pres);
                    }
                }
            } while (line4 != null && cnt4 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void carregaFamiliares() {

        BufferedReader br6 = null;
        try {
            int cnt6 = 0;
            try {
                br6 = new BufferedReader(new FileReader("Dados/familiar.csv"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String header6 = null;
            try {
                header6 = br6.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (header6 != null) {
                String[] columns6 = header6.split(";");
                System.out.println(Arrays.toString(columns6));
            }
            String line6 = null;
            do {
                try {
                    line6 = br6.readLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (line6 != null) {
                    String[] columns7 = line6.split(";");
                    if (columns7.length != 0) {
                        final Familiar f = new Familiar();
                        f.setId(columns7[0]);
                        f.setNome(columns7[1]);
                        f.setContacto(columns7[2]);
                        List<String> uf = Arrays.asList(columns7[3].split(","));
                        f.setUtentes(uf);
                        addFamiliar(f);
                        ++cnt6;
                        System.out.println(f);
                    }
                }
            } while (line6 != null && cnt6 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public synchronized void addUtente(Utente u) throws IdAlreadyExists {
        if (!utentesPorId.containsKey(u.getId())) {
            utentesPorId.put(u.getId(), u);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized void addFamiliar(Familiar f) throws IdAlreadyExists {
        if (!familiaresPorId.containsKey(f.getId())) {
            familiaresPorId.put(f.getId(), f);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized void addMedico(Profissional p) throws IdAlreadyExists {
        if (!medicosPorId.containsKey(p.getId())) {
            medicosPorId.put(p.getId(), (Medico) p);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized void addProfissional(Profissional p) throws IdAlreadyExists {
        if (!profissionaisPorId.containsKey(p.getId())) {
            profissionaisPorId.put(p.getId(), p);
        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized void addConsulta(Consulta c) throws RemoteException {
        if (!consultasPorId.containsKey(c.getId_consulta())) {
            consultasPorId.put(c.getId_consulta(), c);
            String idUtente = c.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addConsulta(c.getId_consulta());

            String idMedico = c.getIdMedico();
            Medico m = medicosPorId.get(idMedico);
            m.addConsulta(c.getId_consulta());
        } else {
            throw new RuntimeException();
        }

        System.out.println(c);
    }

    public synchronized void addExame(Exame e) throws IdAlreadyExists {

        if (!examesPorId.containsKey(e.getId_exame())) {
            examesPorId.put(e.getId_exame(), e);

            String idUtente = e.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addExame(e.getId_exame());

        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized void addPrescricao(Prescricao pre) throws RemoteException, IdAlreadyExists {

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


    public synchronized void addMedicao(Medicao medicao) throws IdAlreadyExists {
        if (!medicoesPorId.containsKey(medicao.getIdmedicao())) {
            medicoesPorId.put(medicao.getIdmedicao(), medicao);

            String idUtente = medicao.getId_utente();
            Utente u = utentesPorId.get(idUtente);
            u.addMedicao(medicao.getIdmedicao());
        } else {
            throw new IdAlreadyExists();
        }
    }

    public synchronized List<Consulta> encontraConsultas_utente(String id) throws RemoteException {
        List<Consulta> lc = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);
        if (resultado != null) {
            List<String> idsConsultas = resultado.getConsultas();
            for (String idConsulta : idsConsultas) {
                lc.add(consultasPorId.get(idConsulta));
            }
        } else {
            throw new RemoteException();
        }
        return lc;
    }

    public synchronized List<Prescricao> encontraPrescricoes_utente(String id) throws RemoteException {
        List<Prescricao> lp = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);
        if (resultado != null) {
            List<String> idsPrescricoes = resultado.getPrescricoes();
            for (String idPrescricao : idsPrescricoes) {
                lp.add(prescricoesPorId.get(idPrescricao));
            }
        } else {
            throw new RemoteException();
        }
        return lp;
    }

    public synchronized List<Medicao> encontraMedicoes_utente(String id) throws RemoteException {
        List<Medicao> lm = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);// a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsMedicoes = resultado.getMedicoes();
            for (String idMedicao : idsMedicoes) {
                lm.add(medicoesPorId.get(idMedicao));
            }
        } else {
            throw new RemoteException();
        }
        return lm;
    }


    public synchronized List<Exame> encontraExames_utente(String id) throws RemoteException {
        List<Exame> le = new ArrayList<>();
        Utente resultado = utentesPorId.get(id);                 // a variavel resultado fica com o valor do hashmap com a key id
        if (resultado != null) {
            List<String> idsExames = resultado.getExames();
            for (String idMedicao : idsExames) {
                le.add(examesPorId.get(idMedicao));
            }
        } else {
            throw new RemoteException();
        }
        return le;
    }

    public synchronized List<Consulta> encontraConsultas_medico(String id) throws RemoteException {
        List<Consulta> lc = new ArrayList<>();
        Medico resultado = medicosPorId.get(id);
        if (resultado != null) {
            List<String> idsConsultas = resultado.getConsultas();
            for (String idConsulta : idsConsultas) {
                lc.add(consultasPorId.get(idConsulta));
            }
        } else {
            throw new RemoteException();
        }
        return lc;
    }


    public synchronized List<Prescricao> encontraPrescricao_medico(String id) throws RemoteException {
        List<Prescricao> lc = new ArrayList<>();
        Medico resultado = medicosPorId.get(id);
        if (resultado != null) {
            List<String> idsPrescricoes = resultado.getPrescricoes();
            for (String idPrescricao : idsPrescricoes) {
                lc.add(prescricoesPorId.get(idPrescricao));
            }
        } else {
            throw new RemoteException();
        }
        return lc;
    }

    public synchronized boolean alterarNome_utente(String id, String nome) throws RemoteException {
        boolean res;
        Utente resultado = utentesPorId.get(id);

        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        } else {
            throw new RemoteException();
        }
        return res;
    }


    public synchronized boolean alterarGenero_utente(String id, String genero) throws RemoteException {
        boolean res;
        Utente resultado = utentesPorId.get(id);  // a variavel resultado fica com o valor do hashmap com a key id

        if (resultado != null) {
            resultado.setGenero(genero);
            res = true;
        } else {
            throw new RemoteException();
        }

        return res;
    }

    public synchronized boolean alterarContacto_utente(String id, String contacto) throws RemoteException {
        boolean res;
        Utente resultado = utentesPorId.get(id);

        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        } else {
            throw new RemoteException();
        }

        return res;
    }

    public synchronized boolean alterarContacto_Profissional(String id, String contacto) throws RemoteException {
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
            throw new RemoteException();
        }

        System.out.println(profissionaisPorId.values());

        return res;
    }

    public synchronized boolean alterarNome_Profissional(String id, String nome) throws RemoteException {
        boolean res;
        Profissional resultado = profissionaisPorId.get(id);

        if (resultado == null) {
            resultado = medicosPorId.get(id);
        }

        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        } else {
            throw new RemoteException();
        }
        return res;
    }

    public synchronized boolean alterarEspecialidade_Medico(String id, String especialidade) throws RemoteException {
        boolean res;
        Medico resultado = (Medico) medicosPorId.get(id);
        if (resultado != null) {
            resultado.setEspecialidade(especialidade);
            res = true;
        } else {
            throw new RemoteException();
        }
        return res;
    }

    public synchronized boolean alterarContacto_Familiar(String id, String contacto) throws RemoteException {
        boolean res;
        Familiar resultado = familiaresPorId.get(id);
        if (resultado != null) {
            resultado.setContacto(contacto);
            res = true;
        } else {
            throw new RemoteException();
        }
        return res;
    }

    public synchronized boolean alterarNome_Familiar(String id, String nome) throws RemoteException {
        boolean res;
        Familiar resultado = familiaresPorId.get(id);
        if (resultado != null) {
            resultado.setNome(nome);
            res = true;
        } else {
            throw new RemoteException();
        }

        return res;
    }

    public synchronized boolean alterarDataConsulta_utente(String idc, String data) throws RemoteException {
        boolean res = false;

        Consulta c = consultasPorId.get(idc);

        if (c != null) {
            c.setData(data);
            res = true;
        } else {
            throw new RemoteException();
        }

        return res;
    }

    public synchronized Medico medicoComMaisConsultas() throws RemoteException {
        int max = -1;
        Medico resultado = null;
        for (Medico m : medicosPorId.values()) {
            if (m.getConsultas().size() > max) {
                resultado = m;
                max = m.getConsultas().size();
            }
        }
        return resultado;
    }

    public synchronized int consultasNumDadoPeriodo(String inicial, String dfinal) throws RemoteException {
        int Num = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date datai = formato.parse(inicial);
            Date dataf = formato.parse(dfinal);
            for (Consulta c : consultasPorId.values()) {
                String data = c.getData();
                Date dataa = formato.parse(data);
                if (datai.compareTo(dataa) <= 0 && dataa.compareTo(dataf) <= 0) {
                    ++Num;
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return Num;
    }

    public synchronized void saveConsultas() {
        File file = new File("Dados/consultas.csv");
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"idcomsulta", "idm", "idu", "data", "hora", "UPCS"});
            for (Consulta c : consultasPorId.values()) {
                data.add(new String[]{c.getId_consulta(), c.getIdMedico(), c.getId_utente(), c.getData(), c.getHora(), c.getUpcs()});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized void saveExames() {

        File file2 = new File("Dados/exames.csv");
        try {
            FileWriter outputfile = new FileWriter(file2);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"idexame", "idutente", "data_realizacao", "nome_exame", "resultado"});
            for (Exame e : examesPorId.values()) {
                data.add(new String[]{e.getId_exame(), e.getId_utente(), e.getData_realizacao(), e.getNome_exame(), e.getResultado()});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void saveFamiliar() {

        File file3 = new File("Dados/familiar.csv");
        try {
            FileWriter outputfile = new FileWriter(file3);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"id", "nome", "contacto", "idutentes"});
            for (Familiar f : familiaresPorId.values()) {
                System.out.println(f.getUtentes());
                data.add(new String[]{f.getId(), f.getNome(), f.getContacto(),  String.join(",", f.getUtentes())});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public synchronized void saveMedicoes() {
        File file4 = new File("Dados/medicoes.csv");
        try {
            FileWriter outputfile = new FileWriter(file4);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"idmedicao", "idutente", "tipo", "valor", "unidades"});
            for (Medicao m : medicoesPorId.values()) {
                data.add(new String[]{m.getIdmedicao(), m.getId_utente(), m.getTipo(), m.getValor(), m.getUnidades()});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void savePrescricoes() {

        File file5 = new File("Dados/prescricao.csv");
        try {
            FileWriter outputfile = new FileWriter(file5);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"idprescricao", "idmedico", "idutente", "nome_medicamento", "inicio_toma", "duracao_prescricao", "dose_diaria"});
            for (Prescricao p : prescricoesPorId.values())
                data.add(new String[]{p.getIdp(), p.getId_medico(), p.getId_utente(), p.getNome_medicamento(), p.getInicio_toma(), p.getDuracao(), p.getDose_diaria()});
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void saveProfissionais() {
        File file6 = new File("Dados/profissionais.csv");
        try {
            FileWriter outputfile = new FileWriter(file6);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"id", "type", "nome", "contacto", "especialidade"});
            for (Profissional p : profissionaisPorId.values())
                data.add(new String[]{p.getId(), p.getType(), p.getNome(), p.getContacto(), String.valueOf(0)});
            for (Medico m : medicosPorId.values())
                data.add(new String[]{m.getId(), m.getType(), m.getNome(), m.getContacto(), m.getEspecialidade()});
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void saveUtentes() {
        File file7 = new File("Dados/utentes.csv");
        try {
            FileWriter outputfile = new FileWriter(file7);
            CSVWriter writer = new CSVWriter(outputfile, ';',CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"id","nome", "contacto","genero","data_nascimento"});
            for (Utente u : utentesPorId.values())
                data.add(new String[]{u.getId(), u.getNome(), u.getContacto(), u.getGenero(), u.getData_nascimento()});
            writer.writeAll(data);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}



