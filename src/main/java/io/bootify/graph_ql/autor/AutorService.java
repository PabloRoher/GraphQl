package io.bootify.graph_ql.autor;

import java.util.List;

public interface AutorService {
    Autor crearAutor(String nombre);
    Autor actualizarAutor(Long id, Autor autor);
    void eliminarAutor(Long id);
    Autor obtenerAutor(Long id);
    List<Autor> obtenerTodosLosAutores();
    Autor buscarAutorPorId(Long id);
}
