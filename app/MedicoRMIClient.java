package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.Objetos.Exame;
import Trabalho_AD_JAVA.Objetos.Medicao;
import Trabalho_AD_JAVA.Objetos.Prescricao;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MedicoRMIClient {

    public static void main(String[] args) {
        GestaoMedicosInterface gm = null;
        try {
            gm = (GestaoMedicosInterface) Naming.lookup("rmi://localhost:5001/GM");
            gm.load();

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
                        "1 - Consultar as consultas por id de medico\n" +
                        "2 - Consultar as prescricoes passadas por um medico\n" +
                        "3 - Consultar as consultas por id de utente\n" +
                        "4 - Consultar as prescricoes de um utente\n" +
                        "5 - Consultar as medicoes por id de utente\n" +
                        "6 - Consultar os exames por id de utente\n" +
                        "7 - Adicionar uma consulta a um utente\n" +
                        "8 - Adicionar uma prescricao para um utente\n" +
                        "9 - Adicionar uma medicao para um utente\n" +
                        "10 - Adicionar um exame para um utente\n" +
                        "11 - Alterar o seu contacto\n" +
                        "12 - Alterar o seu nome\n" +
                        "0 - exit\n");
                op = Integer.parseInt(scanner.nextLine());

                if (op == 1) {
                    try {
                        System.out.println("Insira o id do medico:");
                        String idm = scanner.nextLine();
                        System.out.println(gm.encontraConsultas_medico(idm));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 2) {
                    System.out.println("Insira o id do medico:");
                    String idm = scanner.nextLine();
                    System.out.println(gm.encontraPrescricao_medico(idm));
                } else if (op == 3) {
                    System.out.println("Insira o id do utente:");
                    String idm = scanner.nextLine();
                    System.out.println(gm.encontraConsultas_utente(idm));
                } else if (op == 4) {
                    System.out.println("Insira o id do utente:");
                    String idu = scanner.nextLine();
                    System.out.println(gm.encontraPrescricoes_utente(idu));
                } else if (op == 5) {
                    System.out.println("Insira o id do utente:");
                    String idm = scanner.nextLine();
                    System.out.println(gm.encontraMedicoes_utente(idm));
                } else if (op == 6) {
                    System.out.println("Insira o id do utente:");
                    String idm = scanner.nextLine();
                    System.out.println(gm.encontraExames_utente(idm));
                } else if (op == 7) {
                    try {
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Consulta c = new Consulta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                        gm.addConsulta(c);
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
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 11) {
                    System.out.println("\"Insira os dados da seguinte forme: id do medico, novo nome\"");
                    String info = scanner.nextLine();
                    String[] dados = info.split(",");
                    System.out.println(gm.alterarNome_Profissional(dados[0], dados[1]));

                } else if (op == 10) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: idexame, data de realizacao, nome do exame, resultado, id_utente");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        Exame e = new Exame(dados[0], dados[1], dados[2], dados[3], dados[4]);
                        gm.addExame(e);
                    } catch (IdAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 12) {
                    System.out.println("Insira os dados da seguinte forme: id do medico, novo contacto");
                    String info = scanner.nextLine();
                    String[] dados = info.split(",");
                    System.out.println(gm.alterarContacto_Profissional(dados[0], dados[1]));
                } else {System.out.println("Opção inválida! Tente de novo!");}

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}