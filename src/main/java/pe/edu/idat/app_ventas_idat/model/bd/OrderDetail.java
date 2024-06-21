package pe.edu.idat.app_ventas_idat.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.idat.app_ventas_idat.model.bd.pk.ProductOrderId;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
public class OrderDetail {

    @EmbeddedId
    private ProductOrderId id;

    private Double unitprice;
    private Integer quantity;
    private Double discount;

    @ManyToOne
    @MapsId("productid")
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne
    @MapsId("orderid")
    @JoinColumn(name = "orderid")
    private Order order;

}
