
var count = 0;

function shuffle() {

    var random = [];
    var parent = document.getElementById("parent");
    
    var numbers = parent.getElementsByClassName("number");
    var number = 0;
    for(var i = numbers.length - 1; i >= 0; i--) {
        var childNode = numbers[i];
        var n = Math.floor(Math.random() * 3) + 1;
        childNode.innerHTML = n;
        random[number] = n;
        number++;
    }
    
    var newText = document.createElement("h3");
    newText.setAttribute("class", 'text');
    newText.innerHTML = "Trial " + count + " : ";

    if ((random[0] == random[1]) && (random[1] == random[2])) {
       newText.innerHTML += "Success";
    } else {
        newText.innerHTML += "Fail";
    }
    count++;
    parent.appendChild(newText);
}


function reset() {
    var parent = document.getElementById("parent");
    var texts = parent.getElementsByClassName('text');

    for(var i = texts.length - 1; i >= 0; i--) {
        var childNode = texts[i];
        childNode.parentNode.removeChild(childNode); 
    }

    var numbers = parent.getElementsByClassName("number");
    for(var i = numbers.length - 1; i >= 0; i--) {
        var childNode = numbers[i];
        childNode.innerHTML = 0;
    }

    count = 0;
}