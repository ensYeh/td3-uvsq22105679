package fr.uvsq.cprog.collex;

import java.util.Objects;

public class AdresseIp {
    private String adresse;
    public AdresseIp(String adresse){
        this.adresse=adresse;
    }
    public String toString() { return adresse; }
    @Override
    public boolean equals (Object obj){
        if (this==obj) return true;
        if (!(obj instanceof AdresseIp)) return false;
        AdresseIp that=(AdresseIp) obj;
        return Objects.equals(adresse,that.adresse);

    }
    @Override
    public int hashCode(){
        return Objects.hash(adresse);
    }
}
