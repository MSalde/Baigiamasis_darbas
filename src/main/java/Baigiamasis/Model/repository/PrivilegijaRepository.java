package Baigiamasis.Model.repository;
import Baigiamasis.Model.entity.Privilegija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegijaRepository extends JpaRepository<Privilegija, Long> {
    Privilegija findByPavadinimas(String pavadinimas);
}