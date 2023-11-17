package Trabalho_AD_JAVA.app;



import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.Gestao.GestaoDados;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class AuxiliarRMIClient {

    public static void main(String[] args) {
        GestaoAuxiliarInterface ga = null;
        try {
            ga = (GestaoAuxiliarInterface) Naming.lookup("rmi://localhost:5001/GA");
            ga.load();
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int op;
            do {
                System.out.print("Introduza o numero da açao que pretende realizar:\n" +
                        "1 - Consultar as consultas por id de utente\n" +
                        "2 - Consultar as prescricoes de um utente\n" +
                        "3 - Consultar as medicoes por id de utente\n" +
                        "4 - Consultar as exames por id de utente\n" +
                        "5 - Alterar o nome de um utente por id\n"+
                        "6 - Alterar o género de um utente por id\n"+
                        "7 - Alterar o contacto de um utente por id\n"+
                        "8 - Adicionar uma consulta a um utente\n" +
                        "9 - Alterar a data de uma consulta de um utente\n"+
                        "10 - Alterar o nome de um familiar por id\n"+
                        "11 - Alterar o contacto de um familiar por id\n"+
                        "12 - Alterar o seu contacto\n" +
                        "13 - Alterar o seu nome\n" +
                        "14 - Numero de consultas num dado periodo\n" +
                        "15 - Adicionar um utente\n" +
                        "16 - Medico com mais consultas\n" +
                        "17 - Medico com mais prescricoes\n" +
                        "18 - Percentagem de utentes sem consultas\n" +
                        "19 - Medicamento mais prescrito\n" +
                        "20 - Numero de consultas por utente\n" +
                        "0 - exit\n");
                op = Integer.parseInt(scanner.nextLine());

                if (op == 1) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ga.encontraConsultas_utente(idu));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 2) {
                    System.out.println("Insira o id do utente:");
                    String idu = scanner.nextLine();
                    System.out.println(ga.encontraPrescricoes_utente(idu));
                } else if (op == 3) {
                    System.out.println("Insira o id do utente:");
                    String idu = scanner.nextLine();
                    System.out.println(ga.encontraMedicoes_utente(idu));
                } else if (op == 4) {
                    System.out.println("Insira o id do utente:");
                    String idu = scanner.nextLine();
                    System.out.println(ga.encontraExames_utente(idu));
                } else if (op == 5) {
                    System.out.println("Insira a informação sobre a forma id_utente, nome");
                    String info = scanner.nextLine();
                    String dados[] =info.split(",");
                    System.out.println(ga.alterarNome_utente(dados[0], dados[1]));
                } else if (op == 6) {
                    System.out.println("Insira a informação sobre a forma: id_utente, género");
                    String info = scanner.nextLine();
                    String dados[] =info.split(",");
                    System.out.println(ga.alterarGenero_utente(dados[0],dados[1]));
                } else if (op == 7) {
                    System.out.println("Insira a informação sobre a forma: id_utente, contacto");
                    String info = scanner.nextLine();
                    String[] dados = info.split(", ");
                    System.out.println(ga.alterarContacto_utente(dados[0],dados[1]));
                } else if (op == 8) {
                    System.out.println("Insira os dados da seguinte forma: idconsulta, dataconsulta, horaconsulta, upcs, idmedico, idutente");
                    String info = scanner.nextLine();
                    String[] dados = info.split(", ");
                    Consulta c = new Consulta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                    ga.addConsulta(c);
                } else if (op == 9) {
                    System.out.println("Insira os dados da seguinte forma: id consulta, data ");
                    String info = scanner.nextLine();
                    String[] dados = info.split(", ");
                    System.out.println(ga.alterarDataConsulta_utente(dados[0],dados[1]));
                } else if (op == 10) {
                    System.out.println("Insira os dados da seguinte forma: id familiar, novo nome");
                    String info = scanner.nextLine();
                    String[] dados = info.split(", ");
                    System.out.println(ga.alterarNome_Familiar(dados[0],dados[1]));
                }else if (op == 11) {
                    System.out.println("\"Insira os dados da seguinte forme: id do familiar, novo contacto\"");
                    String info = scanner.nextLine();
                    String[] dados = info.split(",");
                    System.out.println(ga.alterarContacto_Familiar(dados[0],dados[1]));

                } else if (op == 12) {
                    System.out.println("Insira os dados da seguinte forme: id do auxiliar, novo contacto");
                    String info = scanner.nextLine();
                    String[] dados = info.split(",");
                    System.out.println(ga.alterarContacto_Profissional(dados[0], dados[1]));
                } else if (op == 13) {
                    System.out.println("Insira os dados da seguinte forme: id do auxiliar, novo nome");
                    String info = scanner.nextLine();
                    String[] dados = info.split(",");
                    System.out.println(ga.alterarNome_Profissional(dados[0], dados[1]));
                } else if (op ==14) {
                    System.out.println("Insira o inicio do período:");
                    String i = scanner.nextLine();
                    System.out.println("Insira o fim do período:");
                    String f = scanner.nextLine();
                    System.out.println("Foram dadas "+ga.consultasNumDadoPeriodo(i,f) + " consultas, nesse intervalo de tempo.");
                } else if (op==16) {
                    System.out.println("O medico com mais consultas dadas é: " + ga.medicoComMaisConsultas());
                }
                else if (op == 15) {
                    System.out.println("Insira os dados da seguinte forma: id utente, nome, contacto, data de nascimento, genero");
                    String info = scanner.nextLine();
                    String[] dados = info.split(", ");
                    Utente u = new Utente();
                    u.setId(dados[0]);
                    u.setNome(dados[1]);
                    u.setContacto(dados[2]);
                    u.setData_nascimento(dados[3]);
                    u.setGenero(dados[4]);
                    ga.addUtente(u);
                }
                else if (op==17) {
                    System.out.println("O medico que passou mais prescricoes é: " + ga.medicoComMaisPrescicoes());
                }
                else if (op==18) {
                    System.out.println("A percentagem de utentes sem consultas é: " + ga.PercentagemUtentesSemConsultas());
                }
                else if (op==19) {
                    System.out.println(ga.medicamentoMaisPrescrito());
                }
                else if (op==20) {
                    System.out.println("Insira o id do utente: ");
                    String info = scanner.nextLine();
                    System.out.println("O paciente teve " + ga.numeroConsultasPorUtente(info)+ " consultas!");
                }
                else {System.out.println("Opção inválida! Tente de novo!");
                }

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}