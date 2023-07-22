function zmienTloNaPodstawieTemperatury(temperatura) {
  const body = document.body;

  if (temperatura >= 30) {
    body.style.backgroundImage = "url('basic2.jpg')";
  } else if (temperatura >= 20) {
    body.style.backgroundImage = "url('basic.jpg')";
  } else {
    body.style.backgroundImage = "url('rain.jpg')";
  }
}


document.addEventListener("DOMContentLoaded", function() {
  const temperaturaElement = document.querySelector('.city p span');
  if(temperaturaElement){
    const temperatura = parseFloat(temperaturaElement.innerText);
    zmienTloNaPodstawieTemperatury(temperatura);
  }
});