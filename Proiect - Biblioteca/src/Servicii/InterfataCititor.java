package servicii;

import entitati.Cititor;

import java.util.Set;

public interface InterfataCititor {
    public Set<Cititor> getCititori();

    public Cititor getCititorById(int idx) throws Exception;

    public Cititor adaugaCititor(Cititor cititor) throws Exception;

    public void updateCititor(int idx, Cititor cititor) throws Exception;

    public void stergeCititor(int idx) throws Exception;
}