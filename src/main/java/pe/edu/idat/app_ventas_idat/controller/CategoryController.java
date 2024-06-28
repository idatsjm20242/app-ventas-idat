package pe.edu.idat.app_ventas_idat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.app_ventas_idat.model.bd.Category;
import pe.edu.idat.app_ventas_idat.service.ICategoryService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService iCategoryService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Category> listarCategorias(){
        return iCategoryService.listarCategorias();
    }
}
