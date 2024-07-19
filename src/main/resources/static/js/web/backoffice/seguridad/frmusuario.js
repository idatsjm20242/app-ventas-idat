$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("")
    $("#txtapellido").val("")
    $("#txtemail").val("")
    $("#txtusuario").val("")
    $("#switchusuario").hide()
    $("#hddidusuario").val("0")
    $("#txtusuario").prop("readonly", false)
    $("#txtemail").prop("readonly", false)
    $("#divmensajepassword").show()
    $("#cbactivo").prop("checked", false)
    $("#btnenviar").hide()
    $("#modalNuevo").modal("show")
})

$(document).on("click", ".btnactualizar", function(){
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/"+$(this).attr("data-idusuario"),
        dataType: "json",
        success: function(resultado){
            $("#txtnombre").val(resultado.nombres)
            $("#txtapellido").val(resultado.apellidos)
            $("#txtemail").val(resultado.email)
            $("#txtemail").prop("readonly", true)
            $("#txtusuario").val(resultado.nomusuario)
            $("#txtusuario").prop("readonly", true)
            $("#switchusuario").show()
            $("#hddidusuario").val(resultado.idusuario)
            $("#divmensajepassword").hide()
            if(resultado.activo)
                $("#cbactivo").prop("checked", true)
            else $("#cbactivo").prop("checked", false)
            $("#btnenviar").show()
            $("#modalNuevo").modal("show")
        }
    })

})