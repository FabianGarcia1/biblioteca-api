package biblioteca.biblioteca.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "libros")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false)
    private Autor autor;

    @Column(nullable = false, length = 80)
    private String editorial;

    @Column(nullable = false)
    private int anioPublicacion;

    @Column(nullable = false)
    private boolean disponible;

}
