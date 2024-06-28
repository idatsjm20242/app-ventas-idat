package pe.edu.idat.app_ventas_idat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.app_ventas_idat.model.bd.Supplier;
import pe.edu.idat.app_ventas_idat.service.ISupplierService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    private ISupplierService iSupplierService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Supplier> listarProveedores(){
        return iSupplierService.listarProveedores();
    }
}
