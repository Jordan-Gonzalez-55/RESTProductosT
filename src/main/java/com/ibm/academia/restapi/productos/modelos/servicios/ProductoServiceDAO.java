package com.ibm.academia.restapi.productos.modelos.servicios;

import com.ibm.academia.restapi.productos.modelos.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServiceDAO {

    public List<Producto> buscarTodos();
    public Optional<Producto> buscarPorId(Long id);

}
