package io.bootify.graph_ql.autor;

public interface AutorService {
    Autor crearAutor(String nombre, String apellido);
    Autor actualizarAutor(Long id, Autor autor);
    void eliminarAutor(Long id);
    Autor obtenerAutor(Long id);
    Iterable<Autor> obtenerTodosLosAutores();
    Autor buscarAutorPorId(Long id);
}
