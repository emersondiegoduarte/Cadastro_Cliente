jQuery(function($) {
	
	mascaraInteiro();
	mascaraMoeda();
	mascaraPorcentagem();
	mascaraData();	
	mascaraCpfCnpj('cpf_cnpj_calculo','accordion_calculo');
	mascaraCep('cep_pernoite','accordion_calculo');
	somenteNumero();
	somenteLetras();
});


function mascaraMoeda(){
	jQuery('.mascara_moeda').maskMoney({symbol:"R$ ",showSymbol:true,symbolStay:true,decimal:",",thousands:"."});
}

function mascaraPorcentagem(){
	jQuery('.mascara_porcentagem').maskMoney({decimal:","});
}

function mascaraData(){
	jQuery('.mascara_data > input').mask("99/99/9999");
}

function mascaraInteiro(){
	jQuery('.mascara_inteiro').maskMoney({thousands:".",precision:"0"});
}

function somenteNumero(){
	jQuery('.somente_numero').keypress(verificaNumero);
}

function somenteLetras(){
	jQuery('.somente_letras').keypress(verificaLetras);
}

function mascaraCpfCnpj(campo, pai){
	if(pai == undefined){
		campo = '#'+campo;
	}else{
		campo = '#'+pai+'\\:'+campo;
	}
	if(jQuery(campo).val() != null){
		retiraMascaraCpfCnpj();
		if(jQuery(campo).val().length == 14){		
			jQuery(campo).mask("99.999.999/9999-99");
		}
		if(jQuery(campo).val().length == 11){	
			jQuery(campo).mask("999.999.999-99");
		}
	}
}

function retiraMascaraCpfCnpj(campo, pai){
	if(pai == undefined){
		campo = '#'+campo;
	}else{
		campo = '#'+pai+'\\:'+campo;
	}
	jQuery(campo).unmask();
	var cpfCnpj = jQuery(campo).val();
	if (cpfCnpj != null){
		var RegExp = /\D/g;
		cpfCnpj = cpfCnpj.replace(RegExp, "");
		jQuery(campo).val(cpfCnpj);
	}
}

function mascaraCep(campo, pai){
	if(pai == undefined){
		campo = '#'+campo;
	}else{
		campo = '#'+pai+'\\:'+campo;
	}

	if(jQuery(campo).val() != null){
		retiraCaracter();
		while(jQuery(campo).val().length < 8){
			cep = '0'+jQuery(campo).val();
			jQuery(campo).val(cep);
		}
		
		if(jQuery(campo).val() == "00000000"){
			jQuery(campo).val("");
		}
		
		jQuery(campo).mask("99.999-999");
		
	}
}

function retiraMascaraCep(campo, pai){
	if(pai == undefined){
		campo = '#'+campo;
	}else{
		campo = '#'+pai+'\\:'+campo;
	}
	
	jQuery(campo).unmask();
	var cep = jQuery(campo).val();
	if (cep != null){
		var RegExp = /\D/g;
		cep = cep.replace(RegExp, "");
		jQuery(campo).val(cep);
	}
}


function retiraCaracter(campo){
	campo = '#'+campo;
	var valor = jQuery(campo).val();
	if (valor != null){
		var RegExp = /\D/g;
		valor = valor.replace(RegExp, "");
		jQuery(campo).val(valor);
	}
}

function retiraNumeros(campo){
	campo = '#'+campo;
	var valor = jQuery(campo).val();
	if (valor != null){
		var RegExp = /\d/g;
		valor = valor.replace(RegExp, "");
		jQuery(campo).val(valor);
	}
}

function transformaUpper(campo){
	campo.value = campo.value.toUpperCase();
}

function verificaNumero(e) {
	if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
		return false;
	}
}

function verificaLetras(e){
	var var_tecla = e.keyCode ? e.keyCode : e.which;
     /* Tecla Backspace */
     if (var_tecla == 8)
              {return true;}
     /* Tecla Space */
     if (var_tecla == 32)
              {return true;}
     /* Teclas a-z e A-Z */
     if ((var_tecla > 64 && var_tecla < 91) || (var_tecla > 96 && var_tecla < 123))
              {return true;}
     /* Teclas acentuadas e cedilha */
     if ((var_tecla > 191 && var_tecla < 221) || (var_tecla > 223 && var_tecla < 253))
              {return true;}
     return false;
}

/*Controla o foco dos campos após ser feito requisição ajax*/
function focoCpfCnpjCalculo(){
	$('#accordion_calculo\\:cpf_cnpj_calculo').focus();	
}

/*Controla o foco dos campos após ser feito requisição ajax*/
function focoVigenciaInicialCalculo(){
	$('#accordion_calculo\\:fim_vigencia_calculo_input').focus();	
}