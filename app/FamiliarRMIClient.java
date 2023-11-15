package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class FamiliarRMIClient {

    public static void main(String[] args) {
        GestaoFamiliarInterface gf = null;
        try {
            gf = (GestaoFamiliarInterface) Naming.lookup("rmi://localhost:5001/GF");
            gf.load();
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
                        String idm = scanner.nextLine();
                        System.out.println(gf.encontraConsultas_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 2) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idu = scanner.nextLine();
                        System.out.println(gf.encontraPrescricoes_utente(idu));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 3) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gf.encontraMedicoes_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 4) {
                    try {
                        System.out.println("Insira o id do utente:");
                        String idm = scanner.nextLine();
                        System.out.println(gf.encontraExames_utente(idm));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 5) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: id familiar, novo contacto");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        System.out.println(gf.alterarContacto_Familiar(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else if (op == 6) {
                    try {
                        System.out.println("Insira os dados da seguinte forma: id familiar, novo nome");
                        String info = scanner.nextLine();
                        String[] dados = info.split(", ");
                        System.out.println(gf.alterarNome_Familiar(dados[0], dados[1]));
                    } catch (ObjectNotFound e) {
                        throw new ObjectNotFound();
                    }
                } else {
                    if (op !=0) {System.out.println("Opção inválida! Tente de novo!");
                }
                }

            } while (op != 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


