function eliminarInspeccion(id) {
	swal({
		  title: "Está seguro de que desea eliminar esta inspeccion?",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/inspecciones/delete/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("La inspeccion ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/";
				}
			});
		  } else {
			swal("La inspeccion no ha sido eliminado");
		}
	  });
}
function eliminarVehiculo(id) {
	swal({
		  title: "Está seguro de que desea eliminar este vehiculo",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/vehiculos/delete/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("El vehiculo ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/";
				}
			});
		  } else {
			swal("El vehiculo no ha sido eliminado");
		}
	  });
}
function eliminarInspector(id) {
	swal({
		  title: "Está seguro de que desea eliminar este inspector, tambien se borraran las inspeciones que realizo",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/inspectores/delete/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("El inspector ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/";
				}
			});
		  } else {
			swal("El inspector no ha sido eliminado");
		}
	  });
}
function eliminarConductor(id) {
	swal({
		  title: "Está seguro de que desea eliminar este Dueño",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/conductores/delete/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("El Dueño ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/";
				}
			});
		  } else {
			swal("El dueño no ha sido eliminado");
		}
	  });
}
	

	