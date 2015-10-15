/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    var primero = prompt("Dame un primer numero");
    var segundo = prompt("Dame un segundo numero");

    var sumapares =0;
    var sumaimpares =0;

    $("#creciente").append("Creciente : ");
    for (var i = parseInt(primero); i <= parseInt(segundo); i++) {
        $("#creciente").append(i + "  ");
         if(i%2 == 0){ sumapares = parseInt(sumapares) + i;}
         else{ sumaimpares = parseInt(sumaimpares) + i;}
    }

    $("#decreciente").append("Decreciente : ");
    for (var j = parseInt(segundo); j >= parseInt(primero); j--) {
        $("#decreciente").append(j + "  ");
    }
    
    $("#pares").append("Suma de numero pares : " + sumapares);
    $("#impares").append("Suma de numero impares : " + sumaimpares);
    
}); 