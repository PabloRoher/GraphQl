package io.bootify.graph_ql.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.bootify.graph_ql.autor.Autor;
import io.bootify.graph_ql.autor.AutorRepository;
import io.bootify.graph_ql.categoria.Categoria;
import io.bootify.graph_ql.categoria.CategoriaRepository;
import io.bootify.graph_ql.libro.Libro;
import io.bootify.graph_ql.libro.LibroRepository;
import io.bootify.graph_ql.reserva.Reserva;
import io.bootify.graph_ql.reserva.ReservaRepository;
import io.bootify.graph_ql.usuario.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public Query(LibroRepository libroRepository, AutorRepository autorRepository,
                 CategoriaRepository categoriaRepository, ReservaRepository reservaRepository,
                 UsuarioRepository usuarioRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Métodos para las consultas GraphQL

    public Iterable<Libro> buscarLibros(String titulo, Long autorId, Long categoriaId) {
        return libroRepository.buscarPorTituloAutorYCategoria(titulo, autorId, categoriaId);
    }

    public Autor obtenerAutor(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Categoria obtenerCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Iterable<Reserva> obtenerReservas(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

}

