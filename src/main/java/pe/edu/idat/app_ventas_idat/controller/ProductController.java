package pe.edu.idat.app_ventas_idat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.app_ventas_idat.model.dto.ProductDto;
import pe.edu.idat.app_ventas_idat.model.dto.RespuestaGeneral;
import pe.edu.idat.app_ventas_idat.service.IProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductController {

    private IProductService iProductService;

    @GetMapping("")
    public String frmProducto(Model model){
        model.addAttribute("listproduct",
                iProductService.listarProductos());
        return "product/frmproducto";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<ProductDto> listarProductos(){
        return iProductService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarProducto(
            @RequestBody ProductDto productDto){
        String mensaje = "Producto registrado correctamente";
        boolean resultado = true;
        try {
            iProductService.guardarProducto(productDto);
        }catch (Exception ex){
            mensaje = "Error: Ocurrio un error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje)
                .resultado(resultado).build();
    }



}
