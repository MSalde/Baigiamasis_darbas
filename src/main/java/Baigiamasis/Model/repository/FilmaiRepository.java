package Baigiamasis.Model.repository;
import Baigiamasis.Model.entity.Filmai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmaiRepository extends JpaRepository<Filmai, Long> {

    List<Filmai> findByPavadinimasLike(String pavadinimas);
    Filmai findById(long id);

}
