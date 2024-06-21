package pe.edu.idat.app_ventas_idat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_ventas_idat.model.bd.Category;
import pe.edu.idat.app_ventas_idat.repository.CategoryRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService {
    private CategoryRepository categoryRepository;
    /*public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }*/
    @Override
    public List<Category> listarCategorias() {
        return categoryRepository.findAll();
    }

    @Override
    public Category guardarCategoria(Category category) {
        return categoryRepository.save(category);
    }
}
