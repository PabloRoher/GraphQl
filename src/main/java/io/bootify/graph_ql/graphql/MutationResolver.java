package io.bootify.graph_ql.graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;

import io.bootify.graph_ql.autor.AutorService;
import io.bootify.graph_ql.libro.Libro;
import io.bootify.graph_ql.libro.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
/*
    // Suponiendo que tienes servicios que manejan la lógica de negocio para cada entidad
    private LibroService libroService;

    public MutationResolver(LibroService libroService) {
        this.libroService = libroService;
    }

    // Mutación para agregar un libro

    public Libro agregarLibro(String titulo, Long autorId, Long categoriaId) {
        return libroService.crearLibro(titulo, autorId, categoriaId);
    }
/*
    // Mutación para editar un libro
    public Libro editarLibro(Long id, String titulo, Long autorId, Long categoriaId, Boolean disponible) {
        return libroService.crearLibro(id, titulo, autorId, categoriaId, disponible);
    }

    // Mutación para eliminar un libro
    public Boolean eliminarLibro(Long id) {
        return libroService.eliminarLibro(id);
    }

    // Mutación para agregar un autor
    public Autor agregarAutor(String nombre, String biografia) {
        return autorService.agregarAutor(nombre, biografia);
    }

    // Mutación para editar un autor
    public Autor editarAutor(Long id, String nombre, String biografia) {
        return autorService.editarAutor(id, nombre, biografia);
    }

    // Mutación para eliminar un autor
    public Boolean eliminarAutor(Long id) {
        return autorService.eliminarAutor(id);
    }
*/
    // Agrega las mutaciones restantes de una manera similar...

    // Recuerda manejar las excepciones adecuadamente y validar los inputs.
}
