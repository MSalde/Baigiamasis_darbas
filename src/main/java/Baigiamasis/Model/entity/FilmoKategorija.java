package Baigiamasis.Model.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Set;

@Entity
public class FilmoKategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;

    @OneToMany(mappedBy = "kategorija")
    private Set<Filmai> filmai;

    public FilmoKategorija() {
    }

    public FilmoKategorija(long id, String pavadinimas, Set<Filmai> filmai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.filmai = filmai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Filmai> getFilmai() {
        return filmai;
    }

    public void setFilmai(Set<Filmai> filmai) {
        this.filmai = filmai;
    }

    @Override
    public String toString() {
        return "FilmoKategorija{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", filmai=" + filmai +
                '}';
    }
}
