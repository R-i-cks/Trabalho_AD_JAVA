package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class EnfermeiroRMIClient {

    public static void main(String[] args) {
        GestaoEnfermeirosInterface ge = null;
        try {
            ge = (GestaoEnfermeirosInterface) Naming.lookup("rmi://localhost:5001/GE");
            ge.load();
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
                        "5 - Alterar o seu contacto\n" +
                        "6 - Alterar o seu nome\n" +
                        "0 - exit\n");
                op = Integer.parseInt(scanner.nextLine());

                if (op == 1) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ge.encontraConsultas_utente(idu));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 2) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ge.encontraPrescricoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 3) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ge.encontraMedicoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 4) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(ge.encontraExames_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 5) {
                    try {
                        System.out.println("Insira os dados da seguinte forme: id do enfermeiro, novo contacto");
                        String info = scanner.nextLine();
                        String[] dados = info.split(",");
                        System.out.println(ge.alterarContacto_Profissional(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }
                } else if (op == 6) {
                    try {
                        System.out.println("Insira os dados da seguinte forme: id do enfermeiro, novo nome");
                        String info = scanner.nextLine();
                        String[] dados = info.split(",");
                        System.out.println(ge.alterarNome_Profissional(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new RuntimeException(e);
                    }} else {System.out.println("Opção inválida! Tente de novo!");}

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}