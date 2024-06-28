package pe.edu.idat.app_ventas_idat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_ventas_idat.model.bd.Product;
import pe.edu.idat.app_ventas_idat.repository.ProductRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> listarProductos() {
        return productRepository.findAll();
    }
    @Override
    public Product guardarProducto(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product obtenerProducto(Integer idproducto) {
        return productRepository
                .findById(idproducto).orElse(null);
    }
}
