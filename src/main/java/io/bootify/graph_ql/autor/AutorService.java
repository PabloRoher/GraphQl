package io.bootify.graph_ql.autor;

import java.util.List;

public interface AutorService {
    Autor crearAutor(String nombre);
    Autor editarAutor(Long id, String nombre);
    String eliminarAutor(Long id);
    List<Autor> obtenerTodosLosAutores();
    Autor buscarAutorPorId(Long id);
}
