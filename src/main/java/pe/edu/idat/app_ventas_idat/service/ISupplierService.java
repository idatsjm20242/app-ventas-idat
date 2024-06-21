package pe.edu.idat.app_ventas_idat.service;

import pe.edu.idat.app_ventas_idat.model.bd.Category;
import pe.edu.idat.app_ventas_idat.model.bd.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> listarProveedores();

    Supplier guardarProveedor(Supplier supplier);
}
