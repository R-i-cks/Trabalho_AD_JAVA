package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.Gestao.GestaoDados;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

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
import java.util.Scanner;

public class UtenteRMIClient {

    public static void main(String[] args) {

        GestaoUtentesInterface gu = null;
        try {
            gu = (GestaoUtentesInterface) Naming.lookup("rmi://localhost:5001/GU");
            gu.load();
        } catch (Exception e) {
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
                        "7 - Alterar o seu genero\n" +
                        "0 - exit\n");
                op = Integer.parseInt(scanner.nextLine());

                if (op == 1) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gu.encontraConsultas_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 2) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(gu.encontraPrescricoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 3) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gu.encontraMedicoes_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 4) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gu.encontraExames_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 5) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: id utente, novo contacto");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        System.out.println(gu.alterarContacto_utente(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 6) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: id utente, novo nome");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        System.out.println(gu.alterarNome_utente(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 7) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: id utente, novo genero");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        System.out.println(gu.alterarGenero_utente(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                }
                else {
                    if (op !=0) {System.out.println("Opção inválida! Tente de novo!");
                    }
                }

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


