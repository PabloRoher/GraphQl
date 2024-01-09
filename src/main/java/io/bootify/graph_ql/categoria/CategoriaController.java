package io.bootify.graph_ql.categoria;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoriaController {

        private final CategoriaService categoriaService;

        public CategoriaController(CategoriaService categoriaService) {
            this.categoriaService = categoriaService;
        }
        @MutationMapping
        public Categoria agregarCategoria(@Argument String nombre) {
            return categoriaService.crearCategoria(nombre);
        }
        @QueryMapping
        public Categoria obtenerCategoria(@Argument Long id) {
            return categoriaService.buscarCategoriaPorId(id);
        }
        @QueryMapping
        public List<Categoria> obtenerTodasCategorias() {
            return categoriaService.obtenerTodasLasCategorias();
        }

        @MutationMapping
        public Categoria editarCategoria(@Argument Long id, @Argument String nombre) {
            return categoriaService.actualizarCategoria(id, nombre);
        }

        @MutationMapping
        public String eliminarCategoria(@Argument Long id) {
            return categoriaService.eliminarCategoria(id);
        }
}
