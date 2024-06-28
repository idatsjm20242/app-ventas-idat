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
    $("#modalproduct").modal("show");
})