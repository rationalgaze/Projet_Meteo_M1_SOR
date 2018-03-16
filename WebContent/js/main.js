// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
  
  
  $('.custom-file-input').on('change',function(){
	  var fname = document.getElementById("zip").files[0].name;
	  $(this).next('.custom-file-label').addClass("selected").html(fname);
	});
  
  $('.mod-btn').on('click',function(){
	  var parentRow = $( this ).closest( "tr" ),
		  date = parentRow.find(".date").html(),
		  loc = parentRow.find(".loc").html(),
		  tmin = parentRow.find(".tmin").html(),
		  tmax = parentRow.find(".tmax").html(),
		  tmoy = parentRow.find(".tmoy").html(),
		  rain = parentRow.find(".rain").html(),
		  sun = parentRow.find(".sun").html(),
	  	  wind = parentRow.find(".wind").html(),
	  	  raf = parentRow.find(".raf").html(),
	  	  dir = parentRow.find(".dir").html().toLowerCase();

	  $("#modifModal").find("#date").val(date);
	  $("#modifModal").find("#location").val(loc);
	  $("#modifModal").find("#min").val(tmin);
	  $("#modifModal").find("#max").val(tmax);
	  $("#modifModal").find("#moy").val(tmoy);
	  $("#modifModal").find("#rain").val(rain);
	  $("#modifModal").find("#sun").val(sun);
	  $("#modifModal").find("#wind").val(wind);
	  $("#modifModal").find("#raf").val(raf);
	  $("#modifModal select").find("option[value='"+dir+"']").prop('selected','selected');
  });
  
})();