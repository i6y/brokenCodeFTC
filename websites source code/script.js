function responsive() {
  var x = document.getElementById("mainMenu");
  if (x.className === "nav-bar"){
    x.className += " responsive";
  } 
  else {
    x.className = "nav-bar";
  }
}
