package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Gestao.GestaoDados;
import Trabalho_AD_JAVA.Objetos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//  C:\Users\monic\.jdks\openjdk-21\bin\rmiregistry.exe -J-D"sun.rmi.registry.registryFilter=*" 5001
public class GestaoRMIServer {
    public static void main(String[] args) {
        BufferedReader br1 = null;
        GestaoDados gd = new GestaoDados();
        try {
            int cnt = 0;

            ///////////////////////////////// LER UTENTES /////////////////////////////////////////////

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
                        Utente u = new Utente();
                        u.setId(columns2[0]);
                        u.setNome(columns2[1]);
                        u.setContacto(columns2[2]);
                        u.setGenero(columns2[3]);
                        u.setData_nascimento(columns2[4]);

                        gd.addUtente(u);
                        ++cnt;
                    }
                    System.out.println(cnt);
                }
            } while (line != null && cnt < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ///////////////////////////////// LER MEDICOS /////////////////////////////////////////////

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
                            Medico m = new Medico();
                            m.setId(columns8[0]);
                            m.setType(columns8[1]);
                            m.setNome(columns8[2]);
                            m.setContacto(columns8[3]);
                            m.setEspecialidade(columns8[4]);
                            gd.addMedico(m);
                        } else {
                            Profissional p = new Profissional();
                            p.setId(columns8[0]);
                            p.setType(columns8[1]);
                            p.setNome(columns8[2]);
                            p.setContacto(columns8[3]);
                            gd.addProfissional(p);
                            ++cnt7;
                        }
                    }
                    System.out.println(cnt7);
                }
            } while (line7 != null && cnt7 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }


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
                        Consulta c = new Consulta();
                        c.setId_consulta(columns3[0]);
                        c.setId_medico(columns3[1]);
                        c.setId_utente(columns3[2]);

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            Date dataFormatada = formato.parse(columns3[3]);
                            c.setData(dataFormatada);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        c.setHora(columns3[4]);
                        c.setUpcs(columns3[5]);
                        gd.addConsulta(c);
                        ++cnt2;
                    }
                    System.out.println(cnt2);
                }
            } while (line2 != null && cnt2 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                        Exame e5 = new Exame();
                        e5.setId_exame(columns4[0]);
                        e5.setId_utente(columns4[1]);
                        e5.setData_realizacao(columns4[2]);
                        e5.setNome_exame(columns4[3]);
                        e5.setResultado(columns4[4]);
                        gd.addExame(e5);
                        ++cnt3;
                    }
                    System.out.println(cnt3);
                }
            } while (line3 != null && cnt3 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                        Prescricao pres = new Prescricao();
                        pres.setIdp(columns5[0]);
                        pres.setId_medico(columns5[1]);
                        pres.setId_utente(columns5[2]);
                        pres.setNome_medicamento(columns5[3]);
                        pres.setInicio_toma(columns5[4]);
                        pres.setDuracao(columns5[5]);
                        pres.setDose_diaria(columns5[6]);
                        gd.addPrescricao(pres);
                        ++cnt4;
                    }
                    System.out.println(cnt4);
                }
            } while (line4 != null && cnt4 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                        Medicao medicao = new Medicao();
                        medicao.setIdmedicao(columns6[0]);
                        medicao.setId_utente(columns6[1]);
                        medicao.setTipo(columns6[2]);
                        medicao.setValor(columns6[3]);
                        medicao.setUnidades(columns6[4]);
                        gd.addMedicao(medicao);
                        ++cnt5;
                    }
                    System.out.println(cnt5);
                }
            } while (line5 != null && cnt5 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                        Familiar f = new Familiar();
                        f.setId(columns7[0]);
                        f.setNome(columns7[1]);
                        f.setContacto(columns7[2]);
                        List<String> uf = List.of(columns7[3].split(";"));
                        f.setUtentes(uf);
                        gd.addFamiliar(f);
                        ++cnt6;
                    }
                    System.out.println(cnt6);
                }
            } while (line6 != null && cnt6 < 100000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            GestaoUtentesInterface serverU = gd;
            Naming.rebind("rmi://localhost:5001/GU", serverU);

            GestaoAuxiliarInterface serverA = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverA);

            GestaoEnfermeirosInterface serverE = gd;
            Naming.rebind("rmi://localhost:5001/GE", serverE);

            GestaoFamiliarInterface serverF = gd;
            Naming.rebind("rmi://localhost:5001/GF", serverF);

            GestaoMedicosInterface serverM = gd;
            Naming.rebind("rmi://localhost:5001/GM", serverM);

            System.out.println("Running");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}