var geocoder;
var map;
var marker;
var latitude;
var longitude;

/* Função para pegar coordenadas 
 * via atributo data da página.
 */
function getGeoLocation(){
	latitude = $('#latitude').data('latitude');
	longitude = $('#longitude').data('longitude');
}

/* Função que inicia o mapa */
function startMap(){		
	var latlng = new google.maps.LatLng(latitude, longitude);
    var options = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
 
    map = new google.maps.Map(document.getElementById('mapa'), options);
 
    geocoder = new google.maps.Geocoder();
 
    marker = new google.maps.Marker({
        map: map,
        draggable: true,
    });
 
    marker.setPosition(latlng);
}

/* Função são executadas quando
 * a página é carregada.
 */
$(document).ready(function (){
	getGeoLocation();
    startMap();   
});	