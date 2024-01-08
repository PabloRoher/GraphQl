package io.bootify.graph_ql.categoria;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(String nombre) {
        return null;
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {

    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        return null;
    }

    @Override
    public Iterable<Categoria> obtenerTodasLasCategorias() {
        return null;
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con el ID: " + id));
    }
}
