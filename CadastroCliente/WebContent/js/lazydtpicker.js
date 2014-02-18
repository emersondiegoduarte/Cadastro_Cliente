// jQuery interface
if (typeof jQuery != "undefined") {
	(function($) {
		/**
		 * plugin to create a button able to lazily installs and remove the
		 * datepicker from the field by creating a 'button' and using an event
		 * on it to trigger the calendar
		 */
		$.fn.lazydtpicker = function() {
			this.each(function(i, e) {
				if ($(e).hasClass("dtpicker") //
						&& !$(e).hasClass("alreadyGotButton")) {
					var bt =$('<img class="btpicker" src="imagens/calendario.gif" />');
					$(e).after(bt);
					bt.click(function(){
						if(!e.disabled && !e.readOnly){
							$(e).datepicker({
								dateFormat:'dd/mm/yy',
								changeYear: true,
								yearRange: '1920:2021',
								onClose:function(){
									$(e).datepicker("destroy");
								}
							});
							$(e).datepicker("show");							
						}
					});
					$(e).addClass('alreadyGotButton');
				}
			});
		};
	})(jQuery);
}