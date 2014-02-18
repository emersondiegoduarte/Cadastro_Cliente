
function getValorFormatado(valor) {
	var valorformatado = valor;
	if (valor != null) {
		if (parseFloat(valor) == 0) {
			valorformatado = "0,00";
		} else if (valor != "") {
			valor = parseFloat(valor).toFixed(2);
			valor += ""; // caso não seja string
			var v = valor.replace(/\./, "").replace(/,/, "");
			v = v.replace(/\D/g, "");
			v = v.replace(/(\d+)(\d{2})/, "$1,$2");
			v = v.replace(/(\d+)(\d{3},\d{2})$/g, "$1.$2");

			var qtdLoop = (v.length - 3) / 3;
			var count = -1;

			while (qtdLoop > count++)
				v = v.replace(/(\d+)(\d{3}.*)/, "$1.$2");

			if (v.search(/^(0\d+,)/) > -1) {
				v = v.replace(/^(0+)(\d)/g, "$2");
			}
			valorformatado = v;
		}
	}

	return valorformatado;
}


function getDateFromData(data) {
	try{
		var d = new Date();
		var v = data;
		if ("" != v.replace(" ", "")) {
			// splittando a data
			var dma = v.match(/[0-9]+/g);
			var i = dma.length;
			while (i--)
				dma[i] = parseInt(dma[i], 10);
			if (dma[0])
				d.setDate(dma[0]);
			if (dma[1])
				d.setMonth(dma[1] - 1);
			if (dma[2])
				d.setFullYear(dma[2],dma[1] - 1,dma[0]);
		}
		return d;
	}catch (e) {
		alert(e);
	}
}

function getDataFromDate(data) {
	try{
		if(data != null){
			var dia = data.getDate();
				if(dia < 10) dia = "0"+ dia;
			var mes = data.getMonth() + 1;
				if(mes < 10) mes = "0"+ mes;
			var ano = data.getFullYear();
			var str = dia + "/" + mes + "/" + ano;
			return str;
		}		
	}catch (e) {
		alert(e);
	}
}


function diasDecorridos(dtCotacao){
   
	var dataAtual = new Date();
	var anoAtual = dataAtual.getFullYear();
	var mesAtual = dataAtual.getMonth() + 1;
	var diaAtual = dataAtual.getDate();
	var dt1 =  new Date(anoAtual, mesAtual, diaAtual);
	
	var dataCotacao = dtCotacao;
	var anoCotParts = dataCotacao.split('/');
	var diaCot = anoCotParts[0];
	var mesCot = anoCotParts[1];
	var anoCot = anoCotParts[2];
	var dt2 =  new Date(anoCot, mesCot, diaCot);
	
	// variáveis auxiliares
    var minuto = 60000; 
    var dia = minuto * 60 * 24;
    var horarioVerao = 0;
    
    // ajusta o horario de cada objeto Date
    dt1.setHours(0);
    dt1.setMinutes(0);
    dt1.setSeconds(0);
    dt2.setHours(0);
    dt2.setMinutes(0);
    dt2.setSeconds(0);
    
    // determina o fuso horário de cada objeto Date
    var fh1 = dt1.getTimezoneOffset();
    var fh2 = dt2.getTimezoneOffset(); 
    
    // retira a diferença do horário de verão
    if(dt2 > dt1){
      horarioVerao = (fh2 - fh1) * minuto;
    } 
    else{
      horarioVerao = (fh1 - fh2) * minuto;    
    }
    
    var dif = Math.abs(dt2.getTime() - dt1.getTime()) - horarioVerao;
    return Math.ceil(dif / dia);
}


function removeAcentos(texto){
	if(texto != null && texto != ""){
		texto = texto.toLowerCase();
		texto = texto.replace(/[âãáàä]/g, "a");
		texto = texto.replace(/[êéèë]/g, "e");
		texto = texto.replace(/[îíìï]/g, "i");
		texto = texto.replace(/[ôõóòö]/g, "o");
		texto = texto.replace(/[ûúùü]/g, "u");
		texto = texto.replace(/[ç]/g, "c");		
	}

	return texto;
}

function calculaIdade(dataNasc){

	var dataAtual = new Date();
	var anoAtual = dataAtual.getFullYear();
	var anoNascParts = dataNasc.split('/');
	var diaNasc =anoNascParts[0];
	var mesNasc =anoNascParts[1];
	var anoNasc =anoNascParts[2];
	var idade = anoAtual - anoNasc;
	var mesAtual = dataAtual.getMonth() + 1;
	// se mês atual for menor que o nascimento, nao fez aniversario ainda;
	// (26/10/2009)
	if(mesAtual < mesNasc){
		idade--;
	}else {
		// se estiver no mes do nasc, verificar o dia
		if(mesAtual == mesNasc){
			if(dataAtual.getDate() < diaNasc ){
				// se a data atual for menor que o dia de nascimento ele ainda
				// nao fez aniversario
				idade--;
			}
		}
	}

	return idade;
}


function calculaDiferencaEntreDatas(dataIni, dataFim, idcPrecisao){
	var flgAnoAnt = false;
	var flgMesAnt = false;
	var anoIniParts = dataIni.split('/');
	var diaIni = parseInt(anoIniParts[0], 10);
	var mesIni = parseInt(anoIniParts[1], 10);
	var anoIni = parseInt(anoIniParts[2], 10);
	var anoFimParts = dataFim.split('/');
	var diaFim = parseInt(anoFimParts[0], 10);
	var mesFim = parseInt(anoFimParts[1], 10);
	var anoFim = parseInt(anoFimParts[2], 10);

	if(anoFim < anoIni){
		flgAnoAnt = true;
		anoIniParts = dataFim.split('/');
		anoFimParts = dataIni.split('/');
		diaIni = parseInt(anoIniParts[0], 10);
		mesIni = parseInt(anoIniParts[1], 10);
		anoIni = parseInt(anoIniParts[2], 10);
		diaFim = parseInt(anoFimParts[0], 10);
		mesFim = parseInt(anoFimParts[1], 10);
		anoFim = parseInt(anoFimParts[2], 10);
	}
	
	var idade = anoFim - anoIni;
	if(idcPrecisao == "A"){
		// se mês atual for menor que o nascimento, nao fez aniversario ainda;
		if(mesFim < mesIni){
			idade--;
		// se estiver no mes do nasc, verificar o dia
		}else if(mesFim == mesIni){
				if(diaFim < diaIni ){
					// se a data atual for menor que o dia de nascimento ele ainda
					// nao fez aniversario
					idade--;
				}
		}
		
		if(flgAnoAnt)
			idade *= -1;
		
	}else if(idcPrecisao == "M"){
		var qtdMesesFim =  parseInt([ ( anoFim - 1 ) * 12], 10) + parseInt(mesFim, 10);  
		var qtdMesesIni =  parseInt([ ( anoIni - 1 ) * 12], 10) + parseInt(mesIni, 10);
		var qtdMeses = qtdMesesFim - qtdMesesIni;
		idade = qtdMeses;
		
		if(flgAnoAnt)
			idade *= -1;
		
	}else if(idcPrecisao == "D"){
		var dt1 =  null;
		var dt2 =  null;
		if(anoFim == anoIni && mesFim < mesIni){
			flgMesAnt = true;
			dt1 =  getDateFromData(dataFim);
			dt2 =  getDateFromData(dataIni);
		}else{
			dt1 =  getDateFromData(dataIni);
			dt2 =  getDateFromData(dataFim);
		}
		
		// variáveis auxiliares
	    var minuto = 60000; 
	    var dia = minuto * 60 * 24;
	    var horarioVerao = 0;
	    
	    // ajusta o horario de cada objeto Date
	    dt1.setHours(0);
	    dt1.setMinutes(0);
	    dt1.setSeconds(0);
	    dt2.setHours(0);
	    dt2.setMinutes(0);
	    dt2.setSeconds(0);
	    
	    // determina o fuso horário de cada objeto Date
	    var fh1 = dt1.getTimezoneOffset();
	    var fh2 = dt2.getTimezoneOffset(); 
	    
	    // retira a diferença do horário de verão
	    if(dt2 > dt1){
	      horarioVerao = (fh2 - fh1) * minuto;
	    } 
	    else{
	      horarioVerao = (fh1 - fh2) * minuto;    
	    }
	    
	    var dif = Math.abs(dt2.getTime() - dt1.getTime()) - horarioVerao;
	    idade =  Math.ceil(dif / dia);
	    
		if(flgAnoAnt)
			idade *= -1;
		else if(flgMesAnt)
	    	idade *= -1;
		
	}
	
	return idade;
}

var dates = [ '00', '01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '32', '33', '34', '35', '36', '37', '38', '39', '40', '41', '42', '43', '44', '45', '46', '47', '48', '49', '50', '51', '52', '53', '54', '55', '56', '57', '58', '59' ];

function date2String( date ) {
	if( date != null ) {
		return dates[ date.getDate() ] + '/' + dates[ date.getMonth() + 1 ] + '/' + date.getFullYear();
	}
	return null;
}

function string2Date( date ) {
	if ( date != '' && date != null ) {
		var s = date.split( '/' );
		return new Date( s[ 2 ], s[ 1 ] - 1, s[ 0 ] );
	}
	return '';

}

