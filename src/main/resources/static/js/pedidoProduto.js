var pedidoProduto = {
		elementBtnDelete: function () { return $('<a>', { text: 'Deletar', class:'btn btn-danger', onclick: 'pedidoProduto.del(this)' }) },
		add: function(element){			
			$tr = $('<tr>');
			$tr
			.append($('<td>', { text: $(element).parent().find('#produtoId').val()}))
			.append($('<td>', { text: $(element).parent().find('#produtoId option:selected').text()}))
			.append($('<td>', { text: $(element).parent().find('#produtoQtd').val()}))
			.append($('<td>', { html: this.elementBtnDelete }));
			
			$tr.appendTo('#tabelaProdutos tbody');
		},
		del: function(element){
			$(element).parent().parent().remove();
		},
		salvar: function (model){
			$('#tabelaProdutos tbody tr').map(function (i, e){
				$('form').append($('<input>', { name: model + '[' + i + '].produto.id', type:'hidden', value: $($(e).find('td')[0]).text()}));
				$('form').append($('<input>', { name: model + '[' + i + '].quantidade', type:'hidden', value: $($(e).find('td')[2]).text()}));
			})
			$('form').submit();
		}
}
