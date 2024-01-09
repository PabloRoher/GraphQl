package io.bootify.graph_ql.libro;

import io.bootify.graph_ql.autor.Autor;
import io.bootify.graph_ql.autor.AutorRepository;
import io.bootify.graph_ql.autor.AutorService;
import io.bootify.graph_ql.categoria.Categoria;
import io.bootify.graph_ql.categoria.CategoriaService;
import io.bootify.graph_ql.categoria.CategoriaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
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
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con el ID: " + autorId));
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con el ID: " + categoriaId));

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setDisponible(true);

        return libroRepository.save(libro);
    }


    @Override
    public Libro actualizarLibro(Long id, String titulo, Long autorId, Long categoriaId, Boolean disponible) {
        // Buscar el libro por ID para asegurarse de que existe
        Libro libroExistente = libroRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Libro no encontrado con el ID: " + id)
        );

        // Actualizar los detalles del libro
        libroExistente.setTitulo(titulo);
        libroExistente.setDisponible(disponible);
        libroExistente.setAutor(autorRepository.findById(autorId).orElseThrow(
                () -> new ResourceNotFoundException("Autor no encontrado con el ID: " + autorId)
        ));
        libroExistente.setCategoria(categoriaRepository.findById(categoriaId).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada con el ID: " + categoriaId)
        ));
        // Guardar y retornar el libro actualizado
        return libroRepository.save(libroExistente);
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
    public List<Libro> buscarTodosLibros() {
        // Lógica para buscar todos los libros
        return libroRepository.findAll();
    }
}
