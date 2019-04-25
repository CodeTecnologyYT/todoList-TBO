$(document).ready(function(){

    $("#modalAddTask").click(function(){
        getTask(0,"new");
    });
    $('.datepicker').datepicker({ dateFormat: 'dd/mm/yyyy' });

    $(".taskEditmodal").click(function(){
        //abrirModal("#registrar-tarea");
        var idTask=$(this).attr("data");
        getTask(idTask,"get");
    });

});
function getTask(id,metodo){
    var url="";
    if(metodo=="get"){
        url="/task/"+metodo+"/"+id;
    }else{
        url="/task/"+metodo;
    }

    $.ajax({
        url : url,
        error : function() {
            $('#modalTask').html('<p>An error has occurred</p>');
        },
        success : function(data) {
            $('#modalTask').html(data);
            abrirModal("#registrar-tarea");
        },
        type : 'GET'
    });
}
function abrirModal(etiqueta){
    $(etiqueta).modal('show');
}
