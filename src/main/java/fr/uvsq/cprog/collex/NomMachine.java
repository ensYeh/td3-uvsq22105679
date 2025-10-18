package fr.uvsq.cprog.collex;
import java.util.Objects;

public class NomMachine {
    private String nom;
    public NomMachine(String nom){
        this.nom=nom;
    }
    public String toString() { return nom; }
    @Override
    public boolean equals (Object obj){
        if (this==obj) return true;
        if (!(obj instanceof NomMachine)) return false;
        NomMachine that=(NomMachine) obj;
        return Objects.equals(nom,that.nom);

    }
    @Override
    public int hashCode(){
        return Objects.hash(nom);
    }
}
