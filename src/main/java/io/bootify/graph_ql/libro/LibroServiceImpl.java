package io.bootify.graph_ql.libro;

import io.bootify.graph_ql.autor.AutorRepository;
import io.bootify.graph_ql.autor.AutorService;
import io.bootify.graph_ql.categoria.CategoriaService;
import io.bootify.graph_ql.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    public LibroServiceImpl(LibroRepository libroRepository, AutorService autorService, CategoriaService categoriaService) {
        this.libroRepository = libroRepository;
        this.autorService = autorService;
        this.categoriaService = categoriaService;
    }

    @Override
    public Libro crearLibro(String titulo, Long autorId, Long categoriaId) {
        // Crear y configurar una nueva instancia de Libro
        Libro libro = new Libro(titulo, autorService.buscarAutorPorId(autorId), categoriaService.buscarCategoriaPorId(categoriaId));
        // Guardar el libro en la base de datos
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
    public Libro obtenerLibro(Long id) {
        // Lógica para obtener un libro
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        // Lógica para obtener todos los libros
        return libroRepository.findAll();
    }
}
