package Entitati;

public class Carte {
    private int id;
    private String titlu;
    private String autor;
    private String editura;

    public Carte() {
    }

    public Carte(int id, String titlu, String autor, String editura) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", editura='" + editura + '\'' +
                '}';
    }
}
