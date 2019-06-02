<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapValidator.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapValidator.min.css"/>" rel="stylesheet">


<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/index.js" />"></script>


<script type="text/javascript" src="<c:url value="/resources/sweetalert/sweetalert.min.js" />"></script>



<title>Medicamento</title>
<style>
	.btn-primary{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
		text-align: center;
		font-size: 14px;
	}
	.btn-primary:hover{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
	}
	.btn-primary:focus{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
	}	
</style>


</head>
<body>
	<div class="container">
		<h3 align="center">Lista Medicamento</h3>
					<button type="button" data-toggle='modal' onclick="modalMedicamento();"  
					class='btn btn-primary' id="validateBtnw2" >Nuevo Medicamento</button><br>&nbsp;<br>		
			<div id="divMedicamento">
		 								<table id="id_table" class="table table-striped table-bordered" >
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Laboratorio</th>
															<th>Tipo</th>
															<th>Stock</th>
															<th>Precio</th>
															<th>Fecha</th>
															<th></th>
															<th></th>
														</tr>
												</thead>
												<tbody>
																									
												</tbody>
											</table>	
			</div>	
			 
		<!-- Nuevo y Acualizar -->
		<div class="modal fade" id="exampleModal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Medicamento</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title" id="id_mensaje">Registra Medicamento</div>
					</div>
					<div class="panel-body">
						<form action="#" class="form-horizontal" id="id_registra"
								method="post"  data-toggle="validator" role="form"  enctype="multipart/form-data">
							<input type="hidden"  id="id_codigo" name="codigo">
							<div class="form-group">
								<label for="i_nombre" class="col-lg-3 control-label">Nombre</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_nombre" 
										name="nombre" placeholder="Ingresar nombre"/>
								</div>
							</div>
							<div class="form-group">
								<label for="i_laboratorio" class="col-lg-3 control-label">Laboratorio</label>
								<div class="col-lg-9">
									<select id="id_laboratorio" name="laboratorio" 
									class='form-control' onchange="mostarTipoMedicamentoXLaboratorio()">
											  <option value=" ">[SELECCIONE]</option>
												<c:forEach var="labo" items="${dataLaboratorio}">
										              <option value="${labo.codLaboratorio}" >
														${labo.desLaboratorio}</option>
										        </c:forEach>      
								    </select>
								</div>
							</div>
							<div class="form-group">
								<label for="i_tipoMedicamento" class="col-lg-3 control-label">Tipo</label>
								<div class="col-lg-9">
									<select id="id_tipo" name="tipo" class='form-control'>
											  <option value=" ">[SELECCIONE]</option>     
								    </select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="i_stock" class="col-lg-3 control-label">Stock</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_stock" name="stock"/>
								</div>
							</div>
							<div class="form-group">
								<label for="i_precio" class="col-lg-3 control-label">Precio</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_precio" name="precio"/>
								</div>
							</div>
							<div class="form-group">
						        <label class="col-lg-3 control-label">Seleccione Foto</label>
						        <div class="col-lg-9">
						             <input type="file" name="file" id="id_foto"/>
						        </div>
						   </div>
							<div class="form-group">
								<label for="i_fecha" class="col-lg-3 control-label">Fecha</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_fecha" name="fecha"/>
								</div>
							</div>												
						</form>
					</div>
			</div>
			</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick="postValidarRegistra()">Guardar</button>
                 <button type="button" class="btn btn-danger" id="resetBtn">Cerrar</button>
		        
		      </div>
		    </div>
		  </div>
		</div>
		<!-- FIN Nuevo y Acualizar-->	
	
	</div>

<script type="text/javascript">
	function listarMedicamentos(){
		$('#divMedicamento').load("listaMedicamentos");	
	}
	function modalMedicamento(){
		$('#id_registra').trigger("reset");
		$("#id_codigo").val(0);
		$("#id_mensaje").text("Registrar Medicamento");
		$('#exampleModal').modal({backdrop: 'static', keyboard: false,show:true});  
	}
	function postValidarRegistra() {
		var validator = $('#id_registra').data('bootstrapValidator');
        validator.validate();
        if (validator.isValid()) {
        	registrarMedicamento();
        }
	}
	function registrarMedicamento(){
		var formData = new FormData($("#id_registra")[0]);
		swal({
			  title: "Seguro de Guardar?",
			  text: "",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willSave) => {
			  if (willSave) {
				  $.ajax({
						url:  'saveMedicamento',
						type: 'POST',
						dataType: "html",
			            data: formData,
			            cache: false,
			            contentType: false,
			     		processData: false,
						success:function(data){
							listarMedicamentos();
						  	$('#id_registra').data('bootstrapValidator').resetForm(true);
					    	swal("Sistema","Registro Guardado...","success");
							$('#exampleModal').modal("hide");
						},
						error: function (e) { 
							swal("Sistema", "Disculpe, existió un problema", "error");
				    	}
					})
			  } 
			});
	}
	function eliminarMedicamento(id){		
		swal({
			  title: "Seguro de Eliminar?",
			  text: "Eliminar el medicamento con Código : "+id,
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  $.ajax({
						url:'deleteMedicamento',
						type:'POST',
						data:{codigo:id},
						success: function(data){
							listarMedicamentos();
							swal("Sistema","Registro eliminado...","success");
						},
						error: function (e) { 
							swal("Sistema", "Disculpe, existió un problema "+e, "error");
				    	}
					});
			  }
			});
	}
	function mostarTipoMedicamentoXLaboratorio(){
		var cod;
		cod=$("#id_laboratorio").val();
		$("#id_tipo").empty().append("<option value=' '>[SELECCIONE]</select>")
		$.ajax({
			url:"listaTipoMedicamentoXLaboratorio",
			type:"get",
			data:{codigo:cod},
			success:function(data){
				$.each(data.keyTipo,function(index,item){
						$("#id_tipo").append("<option value='"+
								item.codTipoMedicamento+"'>"+item.nomTipoMedicamento+"</option>");
				})
			},
			error:function(e){
				swal("Mensaje", "Disculpe, existió un problema "+e, "error");
			}
		})

	}	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		listarMedicamentos();
	} );
</script>

</body>
</html>












