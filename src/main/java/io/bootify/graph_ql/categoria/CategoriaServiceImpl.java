package io.bootify.graph_ql.categoria;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {

    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con el ID: " + id));
    }
}
