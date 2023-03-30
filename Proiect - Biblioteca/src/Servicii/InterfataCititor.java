package Servicii;

import Entitati.Cititor;
import java.util.List;

public interface InterfataCititor {
    public List<Cititor> getCititori();
    public Cititor getCititorById(int idx);
    public void adaugaCititor(Cititor cititor);
    public void updateCititor(int idx, Cititor cititor);
    public void stergeCititor(int idx);
}