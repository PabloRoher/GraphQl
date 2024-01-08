package io.bootify.graph_ql.autor;

import io.bootify.graph_ql.autor.AutorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService{
    private final AutorRepository autorRepository;

    @Autowired
    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
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
    public Autor actualizarAutor(Long id, Autor autor) {
        return null;
    }

    @Override
    public void eliminarAutor(Long id) {

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
