package Baigiamasis.Model.repository;

import Baigiamasis.Model.entity.Filmai;
import Baigiamasis.Model.entity.FilmoKategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmoKategorijaRepository extends JpaRepository<FilmoKategorija, Long> {
    FilmoKategorija findById(long id);
}
