package io.bootify.graph_ql.libro;

import net.bytebuddy.implementation.bind.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LibroController {

    private final LibroService libroService;

    private final LibroRepository libroRepository;

    public LibroController(LibroService libroService, LibroRepository libroRepository) {
        this.libroService = libroService;
        this.libroRepository = libroRepository;
    }
    @QueryMapping
    public List<Libro> buscarLibros(String titulo, Long autorId, Long categoriaId) {
        return libroRepository.buscarPorTituloAutorYCategoria(titulo, autorId, categoriaId);
    }
    @MutationMapping
    public Libro agregarLibro(String titulo, Long autorId, Long categoriaId) {
        return libroService.crearLibro(titulo, autorId, categoriaId);
    }



    //agregar más métodos
}

