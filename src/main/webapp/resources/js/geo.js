var geocoder;
var infowindow;
var map;
var latlngbounds;

function initMap() {
    console.info("initMap");
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: {lat: 59.934280, lng: 30.3350986}
    });
    geocoder = new google.maps.Geocoder;
    infowindow = new google.maps.InfoWindow;
    latlngbounds = new google.maps.LatLngBounds();

    // drawPoints();
}

window.onload = function() {
    var drawer = function(){
        drawPoints();
    }
    drawer();
};

function setMarker(mapka, name, loc) {
    // console.info("setMarker: " + name);
    if (!mapka) return;
    var myLatLng = parseToLatLng(loc);
    latlngbounds.extend(myLatLng);
    var marker = new google.maps.Marker({
        position: myLatLng,
        title: name,
        map: map
    });
    console.info("setMarkeR: " + name);

    infowindow.open(map, marker);
};

function drawPoints() {
    // console.info("drawPoints, points = " + pointsArr.length);
    var geoI = 0;
    for (geoI = 0; geoI < pointsArr.length; geoI++) {
        // console.info("drawPoints i = " + geoI);

        var marker = new google.maps.Marker({
            position: parseToLatLng(pointsArr[geoI].coords),
            map: map,
            title: pointsArr[geoI].name
        });
        var addr = pointsArr[geoI].name;
        infowindow.setContent(addr);
        infowindow.open(map, marker);
    }
}


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