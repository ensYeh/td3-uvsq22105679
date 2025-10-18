package fr.uvsq.cprog.collex;

import java.io.IOException;

public class CommandeAjouter implements Commande {

    private final String nom;
    private final String ip;

    public CommandeAjouter(String nom, String ip) {
        this.nom = nom;
        this.ip = ip;
    }

    @Override
    public void execute(Dns dns,DnsTUI tui) throws IOException {
        dns.addItem(nom, ip);
        tui.affiche("Ajout réussi : " + nom + " -> " + ip);
    }
}
