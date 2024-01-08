package io.bootify.graph_ql.libro;

import io.bootify.graph_ql.autor.AutorService;
import io.bootify.graph_ql.categoria.CategoriaService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

@Controller
public class LibroController {

    private final LibroService libroService;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    public LibroController(LibroService libroService, AutorService autorService, CategoriaService categoriaService) {
        this.libroService = libroService;
        this.autorService = autorService;
        this.categoriaService = categoriaService;
    }

    @QueryMapping
    public Libro libroById(@Argument Long id) {
        return libroService.obtenerLibro(id);
    }

    //agregar más métodos
}

