let stompClient = null;

window.onload = () => {
	const socket = new SockJS('/weather-stat-socket');
	stompClient = Stomp.over(socket);
	stompClient.debug = () => {};
	stompClient.connect({}, (frame) => {
		stompClient.subscribe('/topic/weather', (weather) => {
			const {temperature, precipitation} = JSON.parse(weather.body).data;
			setTemperature(temperature);
			setPrecipitation(precipitation);
		});
		stompClient.send("/app/weather", {}, JSON.stringify({'ping': 'pinged'}));
	});
};

function setTemperature(temperature) {
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			const data = JSON.parse(this.responseText);
			document.querySelector('#temperatureCountry').innerText = `País: ${data.translations.es}`;
		}
	};
	xhttp.open('GET', `https://restcountries.eu/rest/v2/alpha/${temperature.countryCode}`);
	xhttp.send();
	document.querySelector('#temperatureMonth').innerText = `Mes: ${getMonthByNumber(temperature.month)}`;
	document.querySelector('#temperatureValue').innerText = `Temperatura: ${temperature.stat} ºC`;
	temperatureColor(temperature.stat);
}

function temperatureColor(temperature) {
	if (temperature > 25) {
		document.querySelector('#temperatureColor').classList = 'red';
	} else if (temperature > 15 && temperature < 25) {
		document.querySelector('#temperatureColor').classList = 'orange';
	} else if (temperature > 0) {
		document.querySelector('#temperatureColor').classList = 'blue';
	} else {
		document.querySelector('#temperatureColor').classList = 'freeze';
	}
}

function setPrecipitation(precipitation) {
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			const data = JSON.parse(this.responseText);
			document.querySelector('#precipitationCountry').innerText = `País: ${data.translations.es}`;
		}
	};
	xhttp.open('GET', `https://restcountries.eu/rest/v2/alpha/${precipitation.countryCode}`);
	xhttp.send();
	document.querySelector('#precipitationMonth').innerText = `Mes: ${getMonthByNumber(precipitation.month)}`;
	document.querySelector('#precipitationValue').innerText = `Precipitación: ${precipitation.stat} mm`;
	precipitationColor(precipitation.stat);
}

function precipitationColor(precipitation) {
	if (precipitation > 200) {
		document.querySelector('#precipitationColor').classList = 'red';
	} else if (precipitation < 200 && precipitation > 100) {
		document.querySelector('#precipitationColor').classList = 'orange';
	} else {
		document.querySelector('#precipitationColor').classList = 'blue';
	}
}

function getMonthByNumber(number) {
	const months = [
		'Enero',
		'Febrero',
		'Marzo',
		'Abril',
		'Mayo',
		'Junio',
		'Julio',
		'Agosto',
		'Setiembre',
		'Octubre',
		'Noviembre',
		'Diciembre'
	];
	
	return months[number-1];
}