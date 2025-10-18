package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {

    private final Scanner scanner;

    public DnsTUI() {
        this.scanner = new Scanner(System.in);
    }

    public Commande nextCommande() {
        System.out.print("dns> ");
        String ligne = scanner.nextLine().trim();
        if (ligne.isEmpty()) return null;

        String[] tokens = ligne.split("\\s+");
        String action = tokens[0].toLowerCase();

        switch (action) {
            case "ajouter":
                if (tokens.length != 3) {
                    System.out.println("Usage: ajouter <nom> <ip>");
                    return null;
                }
                return new CommandeAjouter(tokens[1], tokens[2]);
            case "chercher":
                if (tokens.length != 2) {
                    System.out.println("Usage: chercher <nom>");
                    return null;
                }
                return new CommandeChercher(tokens[1]);
            case "lister":
                if (tokens.length != 2) {
                    System.out.println("Usage: lister <domaine>");
                    return null;
                }
                return new CommandeLister(tokens[1]);
            case "quitter":
                return new CommandeQuitter();
            case "affichertout":
                return new CommandeAfficherTout();
            default:
                System.out.println("Commande inconnue : " + action);
                return null;
        }
    }

    public void affiche(String message) {
        System.out.println(message);
    }
}
