/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    var mijson = {
        "primer": {
            "artista": "BDC",
            "titulo": "The Collection",
            "sello": "Karrusell international",
            "referencia": 551,
            "año": 1996,
            "pais": "Alemania",
            "formato": "Formato CD",
            "observaciones": "Licensed from Mercury Records LTd (London)",
            "genero": ["Funck", "Soul", "Electronic"],
            "estilo": ["Funk disco", "Synth Pop"]
        },
        "segun": {
            "artista": "Michael Jackson",
            "titulo": "Michael",
            "sello": "Epic",
            "referencia": 2010,
            "año": 2010,
            "pais": "Estados Unidos",
            "formato": "Formato CD",
            "observaciones": "Licensed from Epic Records LTd (EEUU)",
            "genero": ["R&B comtemporáneo", "Soul", "Pop"],
            "estilo": ["Funk disco", "Pop disco"]
        }
    };

    $('#primerboton').on('click', function () {

        $('#primero').toggle('slow');

    });

    $("#segundoboton").on('click', function () {
        $("#segundo").toggle('slow');

    });
    $("#primero").append("Titulo : " + mijson.primer.titulo + "</br>");
    $("#primero").append("Artista : " + mijson.primer.artista + "</br>");
    $("#primero").append("Sello : " + mijson.primer.sello + "</br>");
    $("#primero").append("Referencia : " + mijson.primer.referencia + "</br>");
    $("#primero").append("Año : " + mijson.primer.año + "</br>");
    $("#primero").append("Pais : " + mijson.primer.pais + "</br>");
    $("#primero").append("Formato : " + mijson.primer.formato + "</br>");
    $("#primero").append("Observacion : " + mijson.primer.observaciones + "</br>");
    $("#primero").append("Genero : " + mijson.primer.genero[0] + ", " + mijson.primer.genero[1] + ", " + mijson.primer.genero[2] + "</br>");
    $("#primero").append("Estilo : " + mijson.primer.estilo[0] + ", " + mijson.primer.estilo[1]);


    $("#segundo").append("Titulo : " + mijson.segun.titulo + "</br>");
    $("#segundo").append("Artista : " + mijson.segun.artista + "</br>");
    $("#segundo").append("Sello : " + mijson.segun.sello + "</br>");
    $("#segundo").append("Referencia : " + mijson.segun.referencia + "</br>");
    $("#segundo").append("Año : " + mijson.segun.año + "</br>");
    $("#segundo").append("Pais : " + mijson.segun.pais + "</br>");
    $("#segundo").append("Formato : " + mijson.segun.formato + "</br>");
    $("#segundo").append("Observacion : " + mijson.segun.observaciones + "</br>");
    $("#segundo").append("Genero : " + mijson.segun.genero[0] + ", " + mijson.primer.genero[1] + ", " + mijson.primer.genero[2] + "</br>");
    $("#segundo").append("Estilo : " + mijson.segun.estilo[0] + ", " + mijson.primer.estilo[1]);



    $('#buscar').on('click', function () {
        var valor = $('#datos').val();
        
        
        if (valor === "mijson.primer.titulo") {
            $("#reflejar").html("Titulo : " + mijson.primer.titulo + "</br>");
        } else if (valor === "mijson.primer.artista") {

            $("#reflejar").html("Artista : " + mijson.primer.artista + "</br>");
        } else if (valor === "mijson.primer.sello") {
            $("#reflejar").html("Sello : " + mijson.primer.sello + "</br>");
        } else if (valor === "mijson.primer.referencia") {
            $("#reflejar").html("Referencia : " + mijson.primer.referencia + "</br>");
        } else if (valor === "mijson.primer.año") {
            $("#reflejar").html("Año : " + mijson.primer.año + "</br>");
        } else if (valor === "mijson.primer.pais") {
            $("#reflejar").html("Pais : " + mijson.primer.pais + "</br>");
        } else if (valor === "mijson.primer.formato") {
            $("#reflejar").html("Formato : " + mijson.primer.formato + "</br>");
        } else if (valor === "mijson.primer.observaciones") {
            $("#reflejar").html("Observacion : " + mijson.primer.observaciones + "</br>");
        } else if (valor === "mijson.primer.genero") {
            $("#reflejar").html("Genero : " + mijson.primer.genero[0] + ", " + mijson.primer.genero[1] + ", " + mijson.primer.genero[2] + "</br>");
        } else if (valor === "mijson.primer.estilo") {
            $("#reflejar").html("Estilo : " + mijson.primer.estilo[0] + ", " + mijson.primer.estilo[1]);
        } else if (valor === "mijson.segun.estilo") {
        $("#reflejar").html("Artista : " + mijson.segun.artista + "</br>");
        } else if (valor === "mijson.segun.sello") {
            $("#reflejar").html("Sello : " + mijson.segun.sello + "</br>");
        } else if (valor === "mijson.segun.referencia") {
            $("#reflejar").html("Referencia : " + mijson.segun.referencia + "</br>");
        } else if (valor === "mijson.segun.año") {
            $("#reflejar").html("Año : " + mijson.segun.año + "</br>");
        } else if (valor === "mijson.segun.pais") {
            $("#reflejar").html("Pais : " + mijson.segun.pais + "</br>");
        } else if (valor === "mijson.segun.formato") {
            $("#reflejar").html("Formato : " + mijson.segun.formato + "</br>");
        } else if (valor === "mijson.segun.observaciones") {
            $("#reflejar").html("Observacion : " + mijson.segun.observaciones + "</br>");
        } else if (valor === "mijson.segun.genero") {
            $("#reflejar").html("Genero : " + mijson.segun.genero[0] + ", " + mijson.segun.genero[1] + ", " + mijson.segun.genero[2] + "</br>");
        } else if (valor === "mijson.primer.estilo") {
            $("#reflejar").html("Estilo : " + mijson.segun.estilo[0] + ", " + mijson.segun.estilo[1]);
        }
    });
});


