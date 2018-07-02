function checkForm(evt) {
	if (document.getElementById("email").value === "") {
		alert("Bitte Email-Adresse eingeben!");
		document.getElementById("email").focus();
		evt.preventDefault();
	}
	if (document.getElementById("vorname").value === "") {
		alert("Bitte Vorname eingeben!");
		document.getElementById("vorname").focus();
		evt.preventDefault();
	}
	if (document.getElementById("nachname").value === "") {
		alert("Bitte Nachname eingeben!");
		document.getElementById("nachname").focus();
		evt.preventDefault();
	}

	if (document.getElementById("usereingabe").value === "") {
		alert("Bitte eine Nachricht eingeben!");
		document.getElementById("usereingabe").focus();
		evt.preventDefault();
	}
	alert("Ihre Nachricht an uns: "
			+ document.getElementById("usereingabe").value);

}