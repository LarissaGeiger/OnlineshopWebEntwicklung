document.addEventListener("DOMContentLoaded", init);

function init() {

	var element = document.getElementById("produktForm");
	element.addEventListener("click", feld);

}

function feld() {

	if (document.getElementById("kameras").checked) {
		document.getElementById("speicherplatz").disabled = true;
		document.getElementById("betriebssystem").disabled = true;
		document.getElementById("arbeitsspeicher").disabled = true;
		document.getElementById("displaytech").disabled = true;
		document.getElementById("bildschirmdia").disabled = true;
		document.getElementById("sensorauflösung").disabled = false;
		document.getElementById("displaygröße").disabled = false;
		document.getElementById("modell").disabled = false;
	}

	if (document.getElementById("smartphones").checked) {
		document.getElementById("speicherplatz").disabled = false;
		document.getElementById("betriebssystem").disabled = false;
		document.getElementById("arbeitsspeicher").disabled = true;
		document.getElementById("displaytech").disabled = true;
		document.getElementById("bildschirmdia").disabled = true;
		document.getElementById("sensorauflösung").disabled = true;
		document.getElementById("displaygröße").disabled = false;
		document.getElementById("modell").disabled = true;
	}

	if (document.getElementById("fernseher").checked) {
		document.getElementById("speicherplatz").disabled = true;
		document.getElementById("betriebssystem").disabled = true;
		document.getElementById("arbeitsspeicher").disabled = true;
		document.getElementById("displaytech").disabled = false;
		document.getElementById("bildschirmdia").disabled = false;
		document.getElementById("sensorauflösung").disabled = true;
		document.getElementById("displaygröße").disabled = true;
		document.getElementById("modell").disabled = true;
	}

	if (document.getElementById("notebooks").checked) {
		document.getElementById("speicherplatz").disabled = true;
		document.getElementById("betriebssystem").disabled = false;
		document.getElementById("arbeitsspeicher").disabled = false;
		document.getElementById("displaytech").disabled = true;
		document.getElementById("bildschirmdia").disabled = true;
		document.getElementById("sensorauflösung").disabled = true;
		document.getElementById("displaygröße").disabled = false;
		document.getElementById("modell").disabled = true;
	}

}

function checkForm(evt) {
	if (document.getElementById("name").value === "") {
		alert("Bitte Produktname eingeben!");
		document.getElementById("name").focus();
		evt.preventDefault();
	}
	if (document.getElementById("artikelnr").value === "") {
		alert("Bitte Artikelnummer eingeben!");
		document.getElementById("artikelnr").focus();
		evt.preventDefault();
	}
	if (document.getElementById("preis").value === "") {
		alert("Bitte Preis eingeben!");
		document.getElementById("preis").focus();
		evt.preventDefault();
	}
	if (document.getElementById("farbe").value === "") {
		alert("Bitte Farbe eingeben!");
		document.getElementById("farbe").focus();
		evt.preventDefault();
	}
	if (document.getElementById("marke").value === "") {
		alert("Bitte Marke eingeben!");
		document.getElementById("marke").focus();
		evt.preventDefault();
	}
	if (document.getElementById("image").value === "") {
		alert("Bitte Bild hochladen!");
		document.getElementById("image").focus();
		evt.preventDefault();
	}
	if (document.getElementById("pageName").value === "") {
		alert("Bitte Name der Produktseite eingeben!");
		document.getElementById("pageName").focus();
		evt.preventDefault();
	}

}
