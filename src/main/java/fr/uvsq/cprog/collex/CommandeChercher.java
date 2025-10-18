package fr.uvsq.cprog.collex;

public class CommandeChercher implements Commande {

    private final String nom;

    public CommandeChercher(String nom) {
        this.nom = nom;
    }

    public boolean estAdresseIp(String entree){
        String[] parties=entree.trim().split("\\.");
        if (parties.length!=4) return false;
        for (String partie : parties){
            try {
                int n=Integer.parseInt(partie);
                if (n<0 || n> 255) return false;
            }
            catch (NumberFormatException e){return false;}
            
        }
        return true;

    }

    @Override
    public void execute(Dns dns,DnsTUI tui) {
        DnsItem item;
        if (estAdresseIp(nom)){
            AdresseIp ip=new AdresseIp(nom);
            item = dns.getItem(ip);
        }
        else{
            NomMachine nom_m=new NomMachine(nom);
            item = dns.getItem(nom_m);
        }
        if (item!= null){
            tui.affiche("Résultat: "+item);
        }
        else { tui .affiche ("Nom non trouvé: " + nom);}
    }
}
