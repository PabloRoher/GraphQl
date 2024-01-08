package io.bootify.graph_ql.libro;

import java.util.List;

public interface LibroService {
    Libro crearLibro(String titulo, Long autorId, Long categoriaId);
    Libro actualizarLibro(Long id, Libro libro);
    void eliminarLibro(Long id);
    Libro obtenerLibroID(Long id);
    List<Libro> obtenerLibroPorTitulo(String titulo);
    List<Libro> obtenerTodosLosLibros();
}