package Baigiamasis.Model.repository;
import Baigiamasis.Model.entity.Komentarai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarasRepository extends JpaRepository<Komentarai, Long> {
}