package Baigiamasis.Model.repository;
import Baigiamasis.Model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByPavadinimas(String pavadinimas);

}