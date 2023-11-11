package app;


import Objetos.*;
import Gestao.GestaoDados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class UtenteRMIClient {

    public static void main(String[] args) {


        GestaoUtentesInterface gu = null;
        try {
            gu = (GestaoUtentesInterface) Naming.lookup("rmi://localhost:8001/GM");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = null;
        try {
            int cnt = 0;

            br = new BufferedReader(
                    new FileReader("../Dados/utente.csv"));
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br.readLine();
                if (line != null) {
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        Utente u = new Utente();
                        u.setId(columns[0]);
                        u.setNome(columns[1]);
                        u.setContacto(columns[2]);
                        u.setGenero(columns[3]);
                        u.setData_nascimento(columns[4]);
                        gu.addUtente(u);
                        cnt++;
                    }
                    System.out.println("OBJECTO: " + cnt);
                }
            } while (line != null && cnt < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        BufferedReader br2 = null;
        try {
            int cnt2 = 0;
            br2 = new BufferedReader(
                    new FileReader("../Dados/consultas.csv"));
            String header = br2.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br2.readLine();
                if (line != null) {
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        Consulta c = new Consulta();
                        c.setId_consulta(columns[0]);
                        c.setId_medico(columns[1]);
                        c.setId_utente(columns[2]);
                        c.setData(columns[3]);
                        c.setHora(columns[4]);
                        c.setUpcs(columns[5]);
                        gu.addConsulta(c);
                        cnt2++;
                    }
                    System.out.println("OBJECTO: " + cnt2);
                }
            } while (line != null && cnt2 < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br3 = null;
        try {
            int cnt3 = 0;
            br3 = new BufferedReader(
                    new FileReader("../Dados/exames.csv"));
            String header = br3.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br3.readLine();
                if (line != null) {
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        Exame e = new Exame();
                        e.setId_exame(columns[0]);
                        e.setId_utente(columns[1]);
                        e.setData_realizacao(columns[2]);
                        e.setNome_exame(columns[3]);
                        e.setResultado(columns[4]);
                        gu.addExame(e);
                        cnt3++;
                    }
                    System.out.println("OBJECTO: " + cnt3);
                }
            } while (line != null && cnt3 < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader br4 = null;
        try {
            int cnt4 = 0;
            br4 = new BufferedReader(
                    new FileReader("../Dados/prescricao.csv"));
            String header = br4.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br4.readLine();
                if (line != null) {
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        Prescricao pres = new Prescricao();
                        pres.setIdp(columns[0]);
                        pres.setId_medico(columns[1]);
                        pres.setId_utente(columns[2]);
                        pres.setNome_medicamento(columns[3]);
                        pres.setInicio_toma(columns[4]);
                        pres.setDuracao(columns[5]);
                        pres.setDose_diaria(columns[6]);
                        gu.addPrescricao(pres);
                        cnt4++;
                    }
                    System.out.println("OBJECTO: " + cnt4);
                }
            } while (line != null && cnt4 < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader br5 = null;
        try {
            int cnt5 = 0;
            br5 = new BufferedReader(
                    new FileReader("../Dados/medicoes.csv"));
            String header = br5.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            String line = null;
            do {
                line = br5.readLine();
                if (line != null) {
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        Medicao medicao = new Medicao();
                        medicao.setIdmedicao(columns[0]);
                        medicao.setId_utente(columns[1]);
                        medicao.setTipo(columns[2]);
                        medicao.setValor(columns[3]);
                        medicao.setUnidades(columns[4]);

                        gu.addMedicao(medicao);
                        cnt5++;
                    }
                    System.out.println("OBJECTO: " + cnt5);
                }
            } while (line != null && cnt5 < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}