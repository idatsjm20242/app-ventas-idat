package pe.edu.idat.app_ventas_idat.model.dto;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}
