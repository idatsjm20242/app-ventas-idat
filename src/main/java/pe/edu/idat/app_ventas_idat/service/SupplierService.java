package pe.edu.idat.app_ventas_idat.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.app_ventas_idat.model.bd.Category;
import pe.edu.idat.app_ventas_idat.model.bd.Supplier;
import pe.edu.idat.app_ventas_idat.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> listarProveedores() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier guardarProveedor(Supplier supplier) {
        return supplierRepository.save(supplier);


    }
}
