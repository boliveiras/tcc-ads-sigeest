$(function() {	
	
	// Navegação dinâmica
	var url = window.location;
	$('ul.nav a[href="'+ url +'"]').parent().addClass('active');
	$('ul.nav a').filter(function() {
	    return this.href == url;
	}).parent().addClass('active');

	// Componente tooltip
	$('[rel="tooltip"]').tooltip();

	// Máscara monetária
	$('.js-valores').maskMoney({
		decimal : ',',
		thousands : '.',
		allowZero : true
	});

	// Máscara para telefone
	$('.js-telefones').mask("(99) 9999-9999?9").focusout(
			function(event) {
				var target, phone, element;
				target = (event.currentTarget) ? event.currentTarget
						: event.srcElement;
				phone = target.value.replace(/\D/g, ''); // Remove tudo o que
															// não é dígito
				element = $(target);
				element.unmask();
				if (phone.length > 10) {
					element.mask("(99) 99999-999?9");
				} else {
					element.mask("(99) 9999-9999?9");
				}
			});

	// Inicia o plugin jquery Data Table
	$('#dataTable, #dataTable1, #dataTable2').dataTable({
		responsive : true,
		"oLanguage" : {
			"decimal" : ",",
			"sEmptyTable" : "Nenhum registro encontrado",
			"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
			"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
			"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
			"sInfoPostFix" : "",
			"sInfoThousands" : ".",
			"sLengthMenu" : "_MENU_ resultados por página",
			"sLoadingRecords" : "Carregando...",
			"sProcessing" : "Processando...",
			"sZeroRecords" : "Nenhum registro encontrado",
			"sSearch" : "Pesquisar",
			"oPaginate" : {
				"sNext" : "Próximo",
				"sPrevious" : "Anterior",
				"sFirst" : "Primeiro",
				"sLast" : "Último"
			},
			"oAria" : {
				"sSortAscending" : ": Ordenar colunas de forma ascendente",
				"sSortDescending" : ": Ordenar colunas de forma descendente"
			}
		}
	});
});
