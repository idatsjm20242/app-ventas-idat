package pe.edu.idat.app_ventas_idat.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.app_ventas_idat.model.bd.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET productname=:productname, " +
            "unitprice=:unitprice, categoryid=:categoryid, " +
            "supplierid=:supplierid, discontinued=:discontinued " +
            "where productid = :productid", nativeQuery = true)
    void actualizarProducto(@Param("productid") Integer productid,
                            @Param("productname") String productname,
                            @Param("unitprice") Double unitprice,
                            @Param("categoryid") Integer categoryid,
                            @Param("supplierid") Integer supplierid,
                            @Param("discontinued") boolean discontinued);
}
