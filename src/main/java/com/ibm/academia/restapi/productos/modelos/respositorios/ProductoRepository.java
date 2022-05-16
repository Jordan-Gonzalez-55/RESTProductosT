package com.ibm.academia.restapi.productos.modelos.respositorios;

import com.ibm.academia.restapi.productos.modelos.entidades.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long> {
}
