package pe.edu.idat.app_ventas_idat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.idat.app_ventas_idat.service.IProductService;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductController {

    private IProductService iProductService;

    public String frmProducto(Model model){
        model.addAttribute("listproduct",
                iProductService.listarProductos());
        return "product/frmproducto";
    }



}
