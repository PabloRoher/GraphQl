package io.bootify.graph_ql.categoria;

import io.bootify.graph_ql.libro.LibroRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    private final LibroRepository libroRepository;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, LibroRepository libroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public Categoria crearCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Long id, String nombre) {
        Categoria categoria = buscarCategoriaPorId(id);
        categoria.setNombre(nombre);
        return categoriaRepository.save(categoria);
    }

    @Override
    public String eliminarCategoria(Long id) {
        // Primero, verifica si hay libros asociados con esta categoría
        boolean existeLibro = libroRepository.existsByCategoriaId(id);
        if (existeLibro) {
            // Si hay libros, no eliminar y retornar un mensaje
            return "La categoría aún tiene libros asociados y no puede ser eliminada.";
        } else {
            // Verifica si la categoría existe
            if (categoriaRepository.existsById(id)) {
                categoriaRepository.deleteById(id);
                return "Categoría eliminada con éxito.";
            } else {
                return "Categoría no encontrada.";
            }
        }
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
