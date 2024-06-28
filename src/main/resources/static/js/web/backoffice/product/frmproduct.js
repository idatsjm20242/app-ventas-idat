$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitprice").val("");
    $("#switchproduct").hide();
    $("#cbdiscontinued").prop("checked", false);
    $("#hddcodprod").val("0");
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
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
    $("#modalproduct").modal("show");
})