package fr.uvsq.cprog.collex;

public class DnsItem {
    private final NomMachine nom;
    private final AdresseIp adresse;

    public DnsItem(NomMachine nom, AdresseIp adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }
    public String toString() { return nom + ";" + adresse; }

}
