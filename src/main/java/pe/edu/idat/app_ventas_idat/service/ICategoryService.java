package pe.edu.idat.app_ventas_idat.service;

import pe.edu.idat.app_ventas_idat.model.bd.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> listarCategorias();

    Category guardarCategoria(Category category);



}
