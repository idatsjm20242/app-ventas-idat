package pe.edu.idat.app_ventas_idat.service;

import pe.edu.idat.app_ventas_idat.model.bd.Product;
import pe.edu.idat.app_ventas_idat.model.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> listarProductos();
    Product guardarProducto(ProductDto product);
    Product obtenerProducto(Integer idproducto);
}
