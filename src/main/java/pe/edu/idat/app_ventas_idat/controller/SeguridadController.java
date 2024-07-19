package pe.edu.idat.app_ventas_idat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.app_ventas_idat.model.bd.Usuario;
import pe.edu.idat.app_ventas_idat.model.dto.RespuestaGeneral;
import pe.edu.idat.app_ventas_idat.service.IUsuarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    private IUsuarioService iUsuarioService;

    @GetMapping("/usuario/registro")
    public String frmUsuario(Model model){
        model.addAttribute("listausuario",
                iUsuarioService.listarUsuario());
        return "seguridad/frmusuario";
    }

    @PostMapping("/usuario")
    @ResponseBody
    public RespuestaGeneral registrarUsuario(
    ){
        return null;
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(
            @PathVariable("id") int id){
        return iUsuarioService.obtenerUsuarioxId(id);
    }

    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listarUsuario(){
        return iUsuarioService.listarUsuario();
    }
}
