$( function() {
	
    var tiposDisponiveis = [
      "RÁDIO 5.8",
      "RÁDIO LICENCIADO",
      "SWITCH",
      "ROTEADOR",
      "SERVIDOR",
      "RETIFICADORA",
      "INVERSOR"
    ];
    
    var setoresDisponiveis = [
    	"SUPORTE",
    	"INFRAESTRUTURA",
    	"ENGENHARIA",
    	"PROJETOS",
    	"DIRETORIA",
    	"NOC"
    ];
    
    $( '#setor').autocomplete({
        source: setoresDisponiveis
      });
    
    $('#tipo').autocomplete({
        source: tiposDisponiveis
      });

});
    
    