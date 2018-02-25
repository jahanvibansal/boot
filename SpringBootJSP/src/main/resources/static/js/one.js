function validate(){
	
	
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.write(this.responseText);
	    }
	  };
	  var name= document.getElementById("name").value;
	  alert(name);
	  xhttp.open("GET", "students/"+name, true);
	  xhttp.send();

}