package com.ibm.academia.restapi.productos.modelos.servicios;

import com.ibm.academia.restapi.productos.exepciones.NotFoundException;
import com.ibm.academia.restapi.productos.modelos.entidades.Producto;
import com.ibm.academia.restapi.productos.modelos.respositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceDAOImpl implements ProductoServiceDAO {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarTodos() {
        return (List<Producto>)productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(!producto.isPresent()){
            throw new NotFoundException(String.format("El producto con ID %d no existe", id));
        }
        return producto;
    }
}
