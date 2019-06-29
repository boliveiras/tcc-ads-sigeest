$('#confirmacaoExclusaoEstruturaModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoEstrutura = button.data('codigo');
			var nomeEstrutura = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoEstrutura);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir a estrutura  <strong>'
							+ nomeEstrutura + '</strong>');
		});

$('#confirmacaoExclusaoEquipamentoModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoEquipamento = button.data('codigo');
			var nomeEquipamento = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoEquipamento);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir a equipamento  <strong>'
							+ nomeEquipamento + '</strong>');
		});


$('#confirmacaoExclusaoFabricanteModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoFabricante = button.data('codigo');
			var nomeFabricante = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoFabricante);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o fabricante  <strong>'
							+ nomeFabricante + '</strong>');
		});

$('#confirmacaoExclusaoBateriaModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoBateria = button.data('codigo');
			var nomeBateria = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoBateria);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir a bateria  <strong>'
							+ nomeBateria + '</strong>');
		});


$('#confirmacaoExclusaoUsuarioModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoUsuario = button.data('codigo');
			var nomeUsuario = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoUsuario);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o usuario  <strong>'
							+ nomeUsuario + '</strong>');
		});


$('#confirmacaoExclusaoEstoqueModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoEstoque = button.data('codigo');
			var nomeEstoque = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoEstoque);
			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o estoque  <strong>'
							+ nomeEstoque + '</strong>');
	});