package io.bootify.graph_ql.libro;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> findByTitulo(String titulo);

    boolean existsByAutorId(Long id);

    boolean existsByCategoriaId(Long id);
}

