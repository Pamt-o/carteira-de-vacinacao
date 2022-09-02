
var btnClose = document.querySelector('.close-preview-js');
    var output = document.getElementById("new");
    var loaderFile = function(event){
    var reader = new FileReader();
      reader.onload = function() {
        output.style.display = "block";
        btnClose.style.display = "block";
        output.style.backgroundImage = "url("+reader.result+")";
      }
      reader.readAsDataURL(event.target.files[0]);
    }

    var editarAvatar = document.querySelector(".editar-content");
    var buttonFile = document.getElementById("file-preview-js");

    editarAvatar.addEventListener("click", function(){
      buttonFile.click();
    });

    btnClose.addEventListener("click", function(){
      btnClose.style.display = "none";
      output.style.backgroundImage = "url('')";
      document.getElementById("file-preview-js").value = "";
    });
