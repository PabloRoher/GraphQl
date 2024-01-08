package io.bootify.graph_ql.autor;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AutorControler {

    private final AutorService autorService;

    public AutorControler(AutorService autorService) {
        this.autorService = autorService;
    }
    @MutationMapping
    public Autor agregarAutor(@Argument String nombre) {
        return autorService.crearAutor(nombre);
    }

    @QueryMapping
    public Autor obtenerAutor(@Argument Long id) {
        return autorService.buscarAutorPorId(id);
    }

    @QueryMapping
    public List<Autor> obtenerTodosAutores() {
        return autorService.obtenerTodosLosAutores();
    }
}
