package pe.edu.idat.app_ventas_idat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_ventas_idat.model.bd.Product;
import pe.edu.idat.app_ventas_idat.model.dto.ProductDto;
import pe.edu.idat.app_ventas_idat.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> listarProductos() {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product prod :
                productRepository.findAll()) {
            ProductDto productDto = ProductDto.builder()
                    .productid(prod.getProductid())
                    .productname(prod.getProductname())
                    .discontinued(prod.isDiscontinued())
                    .unitprice(prod.getUnitprice())
                    .categoryid(prod.getCategory().getCategoryid())
                    .categoryname(prod.getCategory().getCategoryname())
                    .supplierid(prod.getSupplier().getSupplierid())
                    .companyname(prod.getSupplier().getCompanyname())
                    .build();
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
    @Override
    public Product guardarProducto(ProductDto product) {
        return productRepository.save(new Product());
    }
    @Override
    public Product obtenerProducto(Integer idproducto) {
        return productRepository
                .findById(idproducto).orElse(null);
    }
}
