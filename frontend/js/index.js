//var rootURL = "http://localhost:8080/passwordMetter";
var rootURL = "http://127.0.0.1:8080/passwordMetter";
$(document).ready(function() {
	var $loading = $('#loadingDiv').hide(); 
	$('#Bday').datepicker({
	    calendarWeeks: true
	});
	$(document)
	  .ajaxStart(function () {
		$('#loadingDiv').show();
		$('#btnSend').prop( "disabled", true );
	  })
	  .ajaxStop(function () {
		$('#loadingDiv').hide();
		$('#btnSend').prop( "disabled", false );
	  });
	;
	$('#txt_pass').keydown(function(event) {
        if (event.keyCode == 13) {
            console.log('function');
			$("#response").empty();

			var date = $('.datepicker').datepicker().val();
			var name = $('#name').val();
			var lastname1 = $('#lastname1').val();
			var lastname2 = $('#lastname2').val();
			var bday = $('#Bday').val();
			var nickname = $('#nickname').val();
			var petname = $('#petname').val();
			var password = $('#txt_pass').val();

			var data = {
				password: password,
				name: name,
				data: date,
				lastname1:lastname1,
				lastname2:lastname2,
				bday:bday,
				nickname :nickname,
				petname: petname
			}
			
			console.log(password);
			console.log(data);
			
			sendPassword(data);

			return false;
         }
    });
	$('#btnSend').click(function() {
		console.log('function');
		$("#response").empty();
		$("#bio").hide();
		var date = $('.datepicker').datepicker();
		var name = $('#name').val();
		var lastname1 = $('#lastname1').val();
		var lastname2 = $('#lastname2').val();
		var bday = $('#Bday').val();
		var nickname = $('#nickname').val();
		var petname = $('#petname').val();
		var password = $('#txt_pass').val();

		var data = {
			password: password,
			name: name,
			data: date,
			lastname1:lastname1,
			lastname2:lastname2,
			bday:bday,
			nickname :nickname,
			petname: petname
		}
		
		console.log(password);
		console.log(data);
		
		sendPassword(data);

		return false;
	});
	// clean response section
	$('body').on('click','#errorBtn', function() {
		$("#response").empty();
	});

	function sendPassword(dataInfo) {
		console.log('sendPassword');
		//console.log(password);
		console.log(dataInfo);
		$.ajax({
			type: 'POST',
			url: rootURL,
			dataType: "json",
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify({ 
				password: dataInfo.password,
				name: dataInfo.name,
				date: dataInfo.date,
				lastname1:dataInfo.lastname1,
				lastname2:dataInfo.lastname2,
				bday:dataInfo.bday,
				nickname :dataInfo.nickname,
				petname: dataInfo.petname
			}),
			success: function(data){
				console.log(data);
				var responseTemplateStart = '<div class="col-md-12 alert alert-dismissible alert-success"> <button id="errorBtn" type="button" class="close" data-dismiss="alert">&times;</button> <strong>Resultado: </strong>' ;
				var responseTemplateEnd ='</div>';
				var suggestionsHtml = responseTemplateStart +'<ul>' ;
				var suggestions = data.suggestions;
				for (i = 0; i < suggestions.length; i++) {
					suggestionsHtml+= "<li>" + suggestions[i] + '</li>';
				};
				suggestionsHtml+= '</ul>';
				console.log(suggestionsHtml);
				$("#response").append(suggestionsHtml + responseTemplateEnd);
				$("#bio").show();
			},
			error: function(error){
				console.log(error);
				var errorTemplate = '<div class="col-md-12 alert alert-dismissible alert-danger"><button id="errorBtn" type="button" class="close" data-dismiss="alert">&times;</button> <strong>Oh snap!  Error de conexión</strong></div>';
				$("#response").empty();
				$("#response").append(errorTemplate);
				$("#bio").show();
			}
		});
	}
});

