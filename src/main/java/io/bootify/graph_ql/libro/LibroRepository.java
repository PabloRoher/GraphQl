package io.bootify.graph_ql.libro;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>, JpaSpecificationExecutor<Libro> {

    default List<Libro> buscarPorTituloAutorYCategoria(String titulo, Long autorId, Long categoriaId) {
        return findAll((Specification<Libro>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (titulo != null && !titulo.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%"));
            }
            if (autorId != null) {
                predicates.add(cb.equal(root.get("autor").get("id"), autorId));
            }
            if (categoriaId != null) {
                predicates.add(cb.equal(root.get("categoria").get("id"), categoriaId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}

