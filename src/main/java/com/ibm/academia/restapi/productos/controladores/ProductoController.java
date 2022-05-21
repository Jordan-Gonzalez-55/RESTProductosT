package com.ibm.academia.restapi.productos.controladores;

import com.ibm.academia.restapi.productos.modelos.entidades.Producto;
import com.ibm.academia.restapi.productos.modelos.servicios.ProductoServiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final static Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoServiceDAO productoServiceDAO;
    @Autowired
    private Environment environment;

    //Este es para acceder a los puertos de propperties, random
    //@Value("${server.port}")
    //private Integer puerto;
    /**
     * Endpoint para consultar todos los productos
     * @return una lista de productos
     * @author Jordan
     */
    @GetMapping("/listar")
    public ResponseEntity<?> consultarTodosProductos(){
        List<Producto> productos = productoServiceDAO.buscarTodos().
                stream().
                map(producto -> {
                    producto.setPuerto(Integer.parseInt(environment.getProperty("local.server.port")));
                    //producto.setPuerto(puerto);
                    return producto;
                }).collect(Collectors.toList());
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);

    }

    /**
     * Endpoint para consultar producto por id
     * @return parametro de un producto
     * @author Jordan
     */
    @GetMapping("/ver-detalle/id/{productoId}")
    public ResponseEntity<?> verDetalleProducto(@PathVariable Long productoId){
        Optional<Producto> producto = null;
        try{
            producto = productoServiceDAO.buscarPorId(productoId);
            producto.get().setPuerto(Integer.parseInt(environment.getProperty("local.server.port")));
            //producto.get().setPuerto(puerto);
        }
        catch (Exception e){
            logger.info("mensaje: " + e.getMessage() + "Causa: " + e.getCause());
            throw e;
        }

        /*
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            logger.info("mensaje: " + e.getMessage() + "Causa: " + e.getCause());
            e.printStackTrace();
        }

         */


        return new ResponseEntity<Producto>(producto.get(), HttpStatus.OK);

    }
}
