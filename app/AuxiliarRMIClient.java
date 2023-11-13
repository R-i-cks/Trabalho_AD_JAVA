package Trabalho_AD_JAVA.app;



import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.Gestao.GestaoDados;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AuxiliarRMIClient {

    public static void main(String[] args) {
        GestaoAuxiliarInterface ga = null;
        try {
            ga = (GestaoAuxiliarInterface) Naming.lookup("rmi://localhost:5001/GA");
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
                        "5 - Alterar o nome de um utente por id"+
                        "6 - Alterar o género de um utente por id"+
                        "7 - Alterar o contacto de um utente por id"+
                        "8 - Adicionar uma consulta a um utente\n" +
                        "9 - Alterar a data de uma consulta de um utente"+
                        "10 - Alterar o nome de um familiar por id"+
                        "11 - Alterar o contacto de um familiar por id"+
                        "12 - Alterar o seu contacto\n" +
                        "13 - Alterar o seu nome\n" +
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
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ga.encontraPrescricoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 3) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ga.encontraMedicoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 4) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(gm.encontraPrescricoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 5) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gm.encontraMedicoes_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 6) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gm.encontraExames_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 7) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: idconsulta, dataconsulta, horaconsulta, upcs, idmedico, idutente");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Consulta c = new Consulta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                        gm.addConsulta(c);
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 8) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: idprescricao, nome_medicamento, inicio da toma, duracao, dose diaria, idmedico, idutente");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Prescricao p = new Prescricao(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
                        gm.addPrescricao(p);
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 9) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: idmedicao, tipo, valor, unidades, idutente");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Medicao m = new Medicao(dados[0], dados[1], dados[2], dados[3], dados[4]);
                        gm.addMedicao(m);
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 11) {
                    try {
                        System.out.println("\"Insira os dados da seguinte forme: id do medico, novo nome\"");
                        String info = scanner.nextLine();
                        String[] dados = info.split(",");
                        System.out.println(gm.alterarNome_Profissional(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }

                } else if (op == 10) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: idexame, data de realizacao, nome do exame, resultado, id_utente");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Exame e = new Exame(dados[0], dados[1], dados[2], dados[3], dados[4]);
                        gm.addExame(e);
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 12) {
                    try {
                        System.out.println("Insira os dados da seguinte forme: id do medico, novo contacto");
                        String info = scanner.nextLine();
                        String[] dados = info.split(",");
                        System.out.println(gm.alterarContacto_Profissional(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else {System.out.println("Opção inválida! Tente de novo!");}

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}