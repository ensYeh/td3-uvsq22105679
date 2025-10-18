package fr.uvsq.cprog.collex;

import java.io.IOException;

public interface Commande {
    void execute(Dns dns,DnsTUI tui) throws IOException;
}
