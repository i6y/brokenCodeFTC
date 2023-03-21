window.onload = function() {
  openTab(1, event, 'Team');
};

function responsive() {
  var x = document.getElementById("mainMenu");
  if (x.className === "nav-bar"){
    x.className += " responsive";
  } 
  else {
    x.className = "nav-bar";
  }
}

//code to open popup
var isPopOpen = false;
var first = true;
var otherElement = false;
var y;
var popup;

function openPopup(x){
  //you've clicked on a popup somewhere
  //if a popup is already open
  if (isPopOpen){
    //hide old popup
    popup = document.getElementById(y);
    popup.classList.toggle("show");
    //show new popup
    popup = document.getElementById(x);
    popup.classList.toggle("show");
    y = x; 
    otherElement = true;
  }
  //otherwise show the popup
  else {
    y = x; 
    popup = document.getElementById(x);
    popup.classList.toggle("show");
    isPopOpen = true;
  }
}
//if i click anywhere...
window.addEventListener('click', function(e){ 
  if (isPopOpen){
    //if this is the first time im clicking on an element, dont do anything
    if (first){
      first = false;
    }
    else{
      //if i click outside of the open popup...
      if (!popup.contains(e.target)) {
        //if no element is currently open
        if (!otherElement){
          document.getElementById(y).classList.remove("show");
          isPopOpen = false;
          first = true;
        }
        //if another element is already open, dont hide the current popup
        else{
          otherElement = false;
        }
      }
    }
  }
});

//change between alumni and students tab
var i, tabcontent, tablinks;

function openTab(load, evt, tab) {
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  if (load == 1){
    document.getElementById('init').className += " active";
  }
  document.getElementById(tab).style.display = "block";
  if (evt.currentTarget.classList.contains('active')){
    evt.currentTarget.className -= " active";
  }
  else {
    evt.currentTarget.className += " active";
  }
}


// Slideshow on covid years page

let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("demo");
  let captionText = document.getElementById("caption");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}
