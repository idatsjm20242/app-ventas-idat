package pe.edu.idat.app_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.app_ventas_idat.model.bd.Rol;

@Repository
public interface RolRepository
        extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(
            String nomrol);
}
