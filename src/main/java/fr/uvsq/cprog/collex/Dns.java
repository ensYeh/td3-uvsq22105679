package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Dns {
    private final Map<NomMachine, AdresseIp> base = new HashMap<>();
    private final Path lifePath;

    public Dns(Path fichier) throws IOException {
        this.lifePath = fichier;
        if (Files.exists(fichier)) {
            List<String> lignes = Files.readAllLines(fichier, StandardCharsets.UTF_8);
            for (String ligne : lignes) {
                String[] elements = ligne.split(";");
                if (elements.length == 2) {
                    NomMachine nom = new NomMachine(elements[0].trim());
                    AdresseIp ip = new AdresseIp(elements[1].trim());
                    base.put(nom, ip);
                }
            }
        }
        else{System.out.println("Fichier non trouve");}
    }

    public DnsItem getItem(AdresseIp ip) {
        for (Map.Entry<NomMachine, AdresseIp> elem : base.entrySet()) {
            if (elem.getValue().equals(ip)) {
                return new DnsItem(elem.getKey(), elem.getValue());
            }
        }
        return null;
    }

    public DnsItem getItem(NomMachine nom) {
        AdresseIp adresse = base.get(nom);
        if (adresse != null) {
            return new DnsItem(nom, adresse);
        }
        return null;
    }

    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> resultats = new ArrayList<>();
        for (Map.Entry<NomMachine, AdresseIp> entry : base.entrySet()) {
            NomMachine nom = entry.getKey();
            AdresseIp ip = entry.getValue();
            String[] parties = nom.toString().split("\\.");
            if (parties.length >= 2) {
                String nomDomaine = parties[parties.length - 2] + "." + parties[parties.length - 1];
                if (nomDomaine.equals(domaine)) {
                    resultats.add(new DnsItem(nom, ip));
                }
            }
        }
        return resultats;
    }

    public void addItem(String nomStr, String ipStr) throws IOException {
        NomMachine nom = new NomMachine(nomStr);
        AdresseIp ip = new AdresseIp(ipStr);

        if (base.containsKey(nom) || base.containsValue(ip)) {
            throw new IOException("L'entrée existe déjà dans la base de données.");
        }

        base.put(nom, ip);

        String ligne = nomStr + ";" + ipStr + System.lineSeparator();
        Files.write(lifePath, ligne.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public Map<NomMachine,AdresseIp> getBase(){
        return base;
    }
}
