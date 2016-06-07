var geocoder;
var infowindow;
var map;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: {lat: 59.934280, lng: 30.3350986}
    });
    geocoder = new google.maps.Geocoder;
    infowindow = new google.maps.InfoWindow;
}


function setMarkers(map, locations) {
    var latlngbounds = new google.maps.LatLngBounds();
    for (var i = 0; i < locations.length; i++) {
        var myLatLng = locations[i][1];
        latlngbounds.extend(myLatLng);
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
            title: locations[i][0]
        });
    }
    map.setCenter( latlngbounds.getCenter(), map.fitBounds(latlngbounds));
};


function parseToLatLng(str) {
    var x = str.replace(/\(|\)/g, '');
    var latlngStr = x.split(',', 2);
    var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};
    return latlng;
}

function myDeGeoCode(coords, pName) {
    var latlng = parseToLatLng(coords);
    geocoder.geocode({'location': latlng}, function (results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                map.setZoom(15);
                var marker = new google.maps.Marker({
                    position: latlng,
                    map: map
                });
                var addr = pName + ' : ' + results[1].formatted_address;
                infowindow.setContent(addr);
                infowindow.open(map, marker);
            } else {
                window.alert('No results found');
            }
        } else {
            window.alert('Geocoder failed due to: ' + status);
        }
    });
}

function myGeoCode(form) {
    var address = document.getElementById("address").value;
    var nname = document.getElementById("name").value;
    geocoder.geocode({'address': address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            map.setZoom(15);

            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
            var coords = results[0].geometry.location;
            var zz = 'id=' + '0' + '&name=' + nname + '&coords=' + results[0].geometry.location;

            if (nname.length > 1) {
                $.ajax({
                    type: "POST",
                    url: ajaxUrl,
                    data: zz,
                    success: function () {
                        $('#editRow').modal('hide');
                        updateTable();
                        successNoty('Saved');
                    }
                });
            } else {
                failNotySimple("Enter name for point");
            }
        } else {
            failNotySimple("Geocode was not successful for the following reason: " + status);
        }
    });
}