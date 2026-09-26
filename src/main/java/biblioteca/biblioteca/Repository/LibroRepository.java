package biblioteca.biblioteca.Repository;

import biblioteca.biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository <Libro, Long>{
}
