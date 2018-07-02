"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
	var pw = document.getElementById("passwort2");
	pw.addEventListener("blur", checkPasswort);
}
function checkPasswort() {
	var pw1 = document.getElementById("passwort");
	var pw2 = document.getElementById("passwort2");

	if (pw1.value !== pw2.value) {
		alert("Passwörter müssen übereinstimmen! Bitte wiederholen Sie ihr Passwort");
		document.getElementById("passwort2").focus();
	}
}

function checkForm(evt) {
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
	if (document.getElementById("email").value === "") {
		alert("Bitte Email-Adresse eingeben!");
		document.getElementById("email").focus();
		evt.preventDefault();
	}
	if (document.getElementById("passwort").value === "") {
		alert("Bitte Passwort eingeben!");
		document.getElementById("passwort").focus();
		evt.preventDefault();
	}
	if (document.getElementById("passwort2").value === "") {
		alert("Bitte Passwort wiederholen!");
		document.getElementById("passwort2").focus();
		evt.preventDefault();
	}

}