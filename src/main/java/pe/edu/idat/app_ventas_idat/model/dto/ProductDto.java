package pe.edu.idat.app_ventas_idat.model.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ProductDto {
    private Integer productid;
    private String productname;
    private Double unitprice;
    private boolean discontinued;
    private Integer supplierid;
    private String companyname;
    private Integer categoryid;
    private String categoryname;
}
