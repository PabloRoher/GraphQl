package io.bootify.graph_ql.categoria;

import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(String nombre);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
    List<Categoria> obtenerTodasLasCategorias();
    Categoria buscarCategoriaPorId(Long id);
}
