$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitprice").val("");
    $("#switchproduct").hide();
    $("#cbdiscontinued").prop("checked", false);
    $("#hddcodprod").val("0");
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCateProv(0,0)
    $("#modalproduct").modal("show");
})
$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunitprice").val($(this).attr("data-produnitprice"));
    $("#switchproduct").show();
    if ($(this).attr("data-proddiscontinued") === "true"){
        $("#cbdiscontinued").prop("checked", true);
    }else{
        $("#cbdiscontinued").prop("checked", false);
    }
    $("#hddcodprod").val($(this).attr("data-prodcod"));
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCateProv($(this).attr("data-prodcategory"),
                    $(this).attr("data-prodsupplier"));
    $("#modalproduct").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/producto/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            productid: $("#hddcodprod").val(),
            productname: $("#txtnomproduct").val(),
            unitprice: $("#txtunitprice").val(),
            categoryid: $("#cbocategory").val(),
            supplierid: $("#cbosupplier").val(),
            discontinued: $("#cbdiscontinued").prop("checked")
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarProductos()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalproduct").modal("hide");
});

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/producto/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproduct > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproduct > tbody").append("<tr>"+
                `<td>${value.productid}</td>`+
                `<td>${value.productname}</td>`+
                `<td>${value.unitprice}</td>`+
                `<td>${value.categoryname}</td>`+
                `<td>${value.companyname}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-prodcod="${value.productid}" `+
                ` data-prodname="${value.productname}" `+
                ` data-produnitprice="${value.unitprice}" `+
                ` data-proddiscontinued="${value.discontinued}" `+
                ` data-prodcategory="${value.categoryid}" `+
                ` data-prodsupplier="${value.supplierid}">Actualizar</button></td></tr>`
                )

            })
        }
    })
}


function listarCateProv(idcate, idprov){
    $.ajax({
    type: "GET",
    url: "/category/listar",
    dataType: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cbocategory").append(
            `<option value="${value.categoryid}">${value.categoryname}</option>`
            )
        });
        if(idcate > 0)
            $("#cbocategory").val(idcate);
        $.ajax({
                type: "GET",
                url: "/supplier/listar",
                dataType: "json",
                success: function(resultado){
                    $.each(resultado, function(index, value){
                        $("#cbosupplier").append(
                        `<option value="${value.supplierid}">${value.companyname}</option>`
                        )
                    });
                    if(idprov > 0)
                        $("#cbosupplier").val(idprov)
                }
                })
    }
    });
}