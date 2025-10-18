package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            Dns dns = new Dns(Paths.get("dns_test.txt"));
            DnsTUI tui = new DnsTUI();

            while (true) {
                Commande cmd = tui.nextCommande();
                if (cmd == null) continue;

                try {
                    cmd.execute(dns, tui); // passer dns et tui
                } catch (IOException e) {
                    tui.affiche("Erreur : " + e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
