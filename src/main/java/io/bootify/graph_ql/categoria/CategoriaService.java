package io.bootify.graph_ql.categoria;

public interface CategoriaService {
    Categoria crearCategoria(String nombre);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
    Categoria obtenerCategoria(Long id);
    Iterable<Categoria> obtenerTodasLasCategorias();
    Categoria buscarCategoriaPorId(Long id);
}
