package io.bootify.graph_ql.libro;

import io.bootify.graph_ql.autor.Autor;
import io.bootify.graph_ql.autor.AutorRepository;
import io.bootify.graph_ql.autor.AutorService;
import io.bootify.graph_ql.categoria.Categoria;
import io.bootify.graph_ql.categoria.CategoriaService;
import io.bootify.graph_ql.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    @Autowired
    public LibroServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Libro crearLibro(String titulo, Long autorId, Long categoriaId) {
        Autor autor = autorRepository.findById(autorId).orElseThrow(/* excepción */);
        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(/* excepción */);

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setDisponible(true);

        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        // Lógica para actualizar el libro
        return libroRepository.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        // Lógica para eliminar el libro
        libroRepository.deleteById(id);
    }

    @Override
    public Libro obtenerLibroID(Long id) {
        // Lógica para obtener un libro
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> obtenerLibroPorTitulo(String titulo) {
        // Lógica para obtener un libro por su título
        return libroRepository.findByTitulo(titulo);
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        // Lógica para obtener todos los libros
        return libroRepository.findAll();
    }
}
