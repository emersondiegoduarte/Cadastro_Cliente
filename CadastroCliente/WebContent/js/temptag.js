/**
 * este helper carrega scripts em tags temporárias e as remove em seguida.
 * 
 * @param uri
 *            caminho da url que servirá o script desejado
 * 
 * @license Public Domain
 * @author sombriks/Usix technology
 */
function TempTag(uri, usernd,time) {
	var tag = document.createElement("script");
	var marcador = "__timestamp__=" + time;
	if (usernd)
		tag.src = uri.lastIndexOf("?") > -1 ? //
		uri + "&" + marcador : uri + "?" + marcador;
	else
		tag.src = uri;
	
	tag.onload = function() {
		document.body.removeChild(tag);
	};

	this.carregar = function() {
		document.body.appendChild(tag);
	};
}
// jQuery interface
if (typeof jQuery != "undefined") {
	(function($) {
		$.getScriptWithTag = function(uri, usernd,time) {
			new TempTag(uri, usernd,time).carregar();
		};
	})(jQuery);
}