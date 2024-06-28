package pe.edu.idat.app_ventas_idat.service;

import pe.edu.idat.app_ventas_idat.model.bd.Product;

import java.util.List;

public interface IProductService {

    List<Product> listarProductos();
    Product guardarProducto(Product product);
    Product obtenerProducto(Integer idproducto);
}
