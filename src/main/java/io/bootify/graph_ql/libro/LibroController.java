package io.bootify.graph_ql.libro;

import jakarta.persistence.criteria.Predicate;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    /*
    @QueryMapping
    public List<Libro> buscarLibros(String titulo, Long autorId, Long categoriaId) {
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
        return libroRepository.buscarPorTituloAutorYCategoria(titulo, autorId, categoriaId);
    }
    */
    @MutationMapping
    public Libro agregarLibro(@Argument String titulo, @Argument Long autorId, @Argument Long categoriaId) {
        return libroService.crearLibro(titulo, autorId, categoriaId);
    }

    @QueryMapping
    public List<Libro> buscarLibrosTitulo(@Argument String titulo) {
        return libroService.obtenerLibroPorTitulo(titulo);
    }

    @QueryMapping
    public Libro buscarLibrosID(@Argument Long id) {
        return libroService.obtenerLibroID(id);
    }

}

