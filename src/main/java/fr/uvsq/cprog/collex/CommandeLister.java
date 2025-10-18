package fr.uvsq.cprog.collex;

import java.util.List;

public class CommandeLister implements Commande {

    private final String domaine;

    public CommandeLister(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public void execute(Dns dns,DnsTUI tui) {
        List<DnsItem> items = dns.getItems(domaine);
        if (items.isEmpty()){
            tui.affiche("Aucune machine trouvé pour ce domaine");
                }
        else {
            for (DnsItem item : items){
                tui.affiche(item.toString());
            }
        }
    }
}
