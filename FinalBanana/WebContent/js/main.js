$(document).ready(function(){//Entra hasta que la pagina se cargó

    var arregloDeObjetos = [];//Guardar registros del formulario

    $("span#add") //Selector
    .on( 
        "click",         //Evento a manejar
        function( event ){    //Función manejadora

            //alert("Hola");

            var saveAdd = $("input#inputNombreMiembro").val(); //Estamos apuntando al textarea. Devuelve un string
            saveAdd =  $.trim(saveAdd); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            if(saveAdd!="")
            {
            	saveAdd = {"id":saveAdd};
            	//Ajax para verificar si existe el id del miembro en la bd.
            	  $.ajax({
  	                url: "http://localhost:8080/Proyecto/BuscarProyecto", 
  	                type: "POST",
  	                //Qué espero recibir de la ruta
  	                contentType: "application/json",
  	                //Que tipo de datos te voy a enviar
  	                dataType: "json",
  	                data: JSON.stringify(saveAdd),

  	                //Servlet existe y me devolvió un JSON
  	                success: function(data, textStatus, jqXHR) {
  	                    console.log("Si el acceso al servlet fue correcto");
  	                    console.log(data); //data.dato
  	                  
  	                    if((data.id).localeCompare("error"))
  	                    	{
  	                    	console.log("good");
  	  	                  var html = $("textarea#exampleFormControlTextarea2").html();
  	  	                $("textarea#exampleFormControlTextarea2").append(
  	  	        
  	  	                        data.id+"\n"
  	  	                       
  	  	                );
  	  	    
  	  	                $("input#inputNombreMiembro").val("");
  	                    	}
  	                    else
  	                    	{
                    			console.log("bad");
  	                    		alert("Id de usuario no existe");
  	                    		$("input#inputNombreMiembro").val("");
  	                    	}

  	                    
  	                    
  	                },
  	                error: function(jqXHR, textStatus, errorThrown) {
  	                    console.log(jqXHR);
  	                    console.log(textStatus);
  	                    console.log(errorThrown);
  	                }
  	            });
            	
            	
            	

            }
            else
            {
                alert("Introduce un nombre válido");
            }


            

        });  //Funcion para manejar un evento

    $("button#add-info") //Selector
    .on( 
        "click",         //Evento a manejar
        function( event ){    //Función manejadora

            var saveName = $("input#inputNombreProyecto").val(); //Estamos apuntando al textarea. Devuelve un string
            saveName =  $.trim(saveName); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            var saveDesc = $("textarea#exampleFormControlTextarea1").val(); //Estamos apuntando al textarea. Devuelve un string
            saveDesc =  $.trim(saveDesc); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            var saveStart = $("input#inputStartDate").val(); //Estamos apuntando al textarea. Devuelve un string
            saveStart =  $.trim(saveStart); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            var saveEnd = $("input#inputEndDate").val(); //Estamos apuntando al textarea. Devuelve un string
            saveEnd =  $.trim(saveEnd); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            var saveAddall = $("textarea#exampleFormControlTextarea2").val(); //Estamos apuntando al textarea. Devuelve un string
            saveAddall =  $.trim(saveAddall); //Función trim sirve para recortar espacios al inicio y al fin de la cadena.

            if(saveName !== "" && saveDesc !== "" && saveStart !== "" && saveEnd !== "" && saveAddall !== "")
            {
                console.log(saveName);
                console.log(saveDesc);
                console.log(saveStart);
                console.log(saveEnd);
                console.log(saveAddall);
                
    			
    			//Objeto a enviar al servlet
    			var nuevaPublicacion = {
    					"nombreproyecto": saveName,
    					"descripcion": saveDesc,
    					"fechainicio": saveStart,
    					"fechafin": saveEnd,
    					"estado": "1",
    					"miembros": saveAddall
    			
    			};
    			

    			//alert(nuevaPublicacion);
    			console.log(nuevaPublicacion);  			
    			
    			//Insertar nueva publicacion.

                var html = $("div#posts").html();
                $("div#posts").prepend(

                    '<label class = "form-control-label" for = "textoPost">¿Deseas agregar el siguiente registro?</label>'+
                    
                    
                    '<textarea class = "form-control" id="textoPost">'+
                        
                        'Nombre de Proyecto: '+saveName+'\n'+
                        'Descripcion: '+saveDesc+'\n'+
                        'Fecha de Inicio: '+saveStart+'\n'+
                        'Fecha de Termino: '+saveEnd+'\n'+
                        'Miembros: '+"\n"+saveAddall+
                        
                                              '</textarea>'
                );
                
                $.ajax({
	                url: "http://localhost:8080/Proyecto/AgregarProyecto", 
	                type: "POST",
	                //Qué espero recibir de la ruta
	                contentType: "application/json",
	                //Que tipo de datos te voy a enviar
	                dataType: "json",
	                data: JSON.stringify(nuevaPublicacion),

	                //Servlet existe y me devolvió un JSON
	                success: function(data, textStatus, jqXHR) {
	                    console.log("Si el acceso al servlet fue correcto");
	                    console.log(data); //data.dato
	                    
	                    
	                },
	                error: function(jqXHR, textStatus, errorThrown) {
	                    console.log(jqXHR);
	                    console.log(textStatus);
	                    console.log(errorThrown);
	                }
	            });
                
                

            }
            else
            {
                
               //alert("Debes completar todos los campos para poder continuar.");
               var html = $("div#posts").html();
               $("div#posts").prepend(

                
                   '<textarea class = "form-control" id="textoPost">'+
                       
                   'Debes completar todos los campos para poder continuar.'+
                       
                                             '</textarea>'
                      


               );
               
                
            }
            

    		
    		
    		
    		

            
    });  //Funcion para manejar un evento

});
