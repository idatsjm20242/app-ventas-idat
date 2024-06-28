package pe.edu.idat.app_ventas_idat.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaGeneral {
    private boolean resultado;
    private String mensaje;
}
