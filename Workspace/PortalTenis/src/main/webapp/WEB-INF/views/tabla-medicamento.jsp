<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
														</tr>
												</thead>
												<tbody>
													<c:forEach var="medicamento" items="${dataMedicamento}">
														<tr>
															<td>${medicamento.codMedicamento}</td>
															<td>${medicamento.nomMedicamento}</td>
															<td>${medicamento.laboratorio.desLaboratorio}</td>
															<td>${medicamento.tipoMedicamento.nomTipoMedicamento}</td>
															<td>${medicamento.stockMedicamento}</td>
															<td>${medicamento.precioMedicamento}</td>
															<td>${medicamento.fechaMedicamento}</td>
															<td><button type="button" class="btn btn-danger" 
															onclick="eliminarMedicamento('${medicamento.codMedicamento}')">Eliminar</button></td>
														</tr>
													</c:forEach>												
												</tbody>
											</table>	

<script type="text/javascript">
	$(document).ready(function() {
	   $('#id_table').DataTable();
	} );
</script>



