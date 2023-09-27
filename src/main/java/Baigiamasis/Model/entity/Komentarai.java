package Baigiamasis.Model.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Komentarai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 512)
    private String tekstas;

    private Date pridejimoData;

    @ManyToOne
    @JoinColumn(name = "filmo_id")
    private Filmai filmai;

    @ManyToOne
    @JoinColumn(name = "vartotojo_id")
    private Vartotojas vartotojas;

    public Komentarai() {
    }

    public Komentarai(long id, String tekstas, Date pridejimoData, Filmai filmai, Vartotojas vartotojas) {
        this.id = id;
        this.tekstas = tekstas;
        this.pridejimoData = pridejimoData;
        this.filmai = filmai;
        this.vartotojas = vartotojas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTekstas() {
        return tekstas;
    }

    public void setTekstas(String tekstas) {
        this.tekstas = tekstas;
    }

    public Date getPridejimoData() {
        return pridejimoData;
    }

    public void setPridejimoData(Date pridejimoData) {
        this.pridejimoData = pridejimoData;
    }

    public Filmai getFilmai() {
        return filmai;
    }

    public void setFilmai(Filmai filmai) {
        this.filmai = filmai;
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }

    @Override
    public String toString() {
        return "Komentarai{" +
                "id=" + id +
                ", tekstas='" + tekstas + '\'' +
                ", pridejimoData=" + pridejimoData +
                ", filmai=" + filmai +
                ", vartotojas=" + vartotojas +
                '}';
    }
}
