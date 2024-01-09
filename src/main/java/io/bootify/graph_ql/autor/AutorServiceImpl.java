package io.bootify.graph_ql.autor;

import io.bootify.graph_ql.autor.AutorRepository;
import io.bootify.graph_ql.libro.LibroRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService{
    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    @Autowired
    public AutorServiceImpl(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public Autor buscarAutorPorId(Long id) {
        return autorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Autor no encontrado con el ID: " + id)
        );
    }

    @Override
    public Autor crearAutor(String nombre) {
        Autor autor = new Autor(nombre);
        return autorRepository.save(autor);
    }

    @Override
    public Autor editarAutor(Long id, String nombre) {
        Autor autor = buscarAutorPorId(id);
        autor.setNombre(nombre);
        return autorRepository.save(autor);
    }


    @Override
    public String eliminarAutor(Long id) {
        // Primero, verifica si hay libros asociados con este autor
        boolean existeLibro = libroRepository.existsByAutorId(id);
        if (existeLibro) {
            // Si hay libros, no eliminar y retornar un mensaje
            return "El autor aún tiene libros en la biblioteca y no puede ser eliminado.";
        } else {
            // Si no hay libros, procede a eliminar el autor
            autorRepository.deleteById(id);
            return "Autor eliminado con éxito.";
        }
    }

    @Override
    public Autor obtenerAutor(Long id) {
        return null;
    }

    @Override
    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

}
