package com.aluracursos.literactura.literactura.repository;


import com.aluracursos.literactura.literactura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros,Long> {
   Optional findByTituloContainsIgnoreCase(String nombreLibro);
   Optional<Libros> findByTituloContainingIgnoreCase(String nombreLibro);
   List<Libros> findTop5ByOrderByEvaluacionDesc();
   List<Libros> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);
   @Query("SELECT s FROM Serie s " + "JOIN s e " + "GROUP BY s " + "ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
   List<Libros> lanzamientosMasRecientes();
   @Query("SELECT * FROM libros l WHERE l.librosRegistrados")
   List<Libros>librosRegistrados();
   List<Libros>idiomasLibros();
}
