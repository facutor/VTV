const expresiones = {
	usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
	password: /^.{4,12}$/, // 4 a 12 digitos.

};

const campos = {
	nombreUsuario: false,
	password: false,

};

const formulario = document.getElementById("form");
const inputs = document.querySelectorAll("#form input");

const validarFormulario = (evento)=>{

    switch(evento.target.name){
        case "nombreUsuario":
            validarCampo(expresiones.usuario , evento.target , "nombreUsuario");
            break; 
        case "password":
            validarCampo(expresiones.password , evento.target , "password");
            break;    
               
    }
}

const validarCampo=(expresion, input, campo) =>{
    if(expresion.test(input.value)){
        document.getElementById(`grupo__${campo}`).classList.remove("form__grupo-incorrecto");
        document.getElementById(`grupo__${campo}`).classList.add("form__grupo-correcto");
        document.querySelector(`#grupo__${campo} i`).classList.remove("fa-times-circle");
        document.querySelector(`#grupo__${campo} i`).classList.add("fa-check-circle");

        document.querySelector(`#grupo__${campo} .form__error-input-msg`).classList.remove("form__error-input-msg-activo");
        campos[campo] = true;
    }
    else{
        document.getElementById(`grupo__${campo}`).classList.remove("form__grupo-correcto");
        document.getElementById(`grupo__${campo}`).classList.add("form__grupo-incorrecto");
        document.querySelector(`#grupo__${campo} i`).classList.remove("fa-check-circle");
        document.querySelector(`#grupo__${campo} i`).classList.add("fa-times-circle");

        document.querySelector(`#grupo__${campo} .form__error-input-msg`).classList.add("form__error-input-msg-activo");
        campos[campo] = false;
    }
}


const validarCamposAgregados = () =>{
	for(let i=1; i<= (inputs.length -1); i++){
		switch(inputs[i].name){


	        case "nombreUsuario":
	            validarCampo(expresiones.usuario , inputs[i] , "nombreUsuario");
	            break; 
	        case "password":
	            validarCampo(expresiones.password , inputs[i] , "password");
	            break;    
    
		}
	}
}


inputs.forEach( (input) =>{
    input.addEventListener("keyup",validarFormulario);
    input.addEventListener("blur",validarFormulario);
});


if(inputs[2].value !== "" && inputs[3].value !== "" && inputs[4].value !== "" && inputs[5].value !== "" &&
	inputs[7].value !== ""){
	document.addEventListener("DOMContentLoaded", validarCamposAgregados );	
}


formulario.addEventListener("submit", (e) =>{
 
    if(!campos.apellido || !campos.nombre || !campos.nroDocumento || !campos.nombreUsuario || !campos.email || !campos.password){
	
	    e.preventDefault();
        
        document.getElementById("form__msg-error").classList.add("form__msg-erro-activo");
        setTimeout( ()=>{
            document.getElementById("form__msg-error").classList.remove("form__msg-erro-activo");
        } , 5000); //serian 5000 milisegundos es decir 5 segundos para que desaparezca el msg de exito
    }
   
});
