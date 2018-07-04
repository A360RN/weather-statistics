let stompClient = null;

window.onload = () => {
	const socket = new SockJS('/weather-stat-socket');
	stompClient = Stomp.over(socket);
	stompClient.debug = () => {};
	stompClient.connect({}, (frame) => {
		stompClient.subscribe('/topic/weather', (weather) => {
			const {temperature, precipitation} = JSON.parse(weather.body).data;
			document.getElementById('websocketPlaceholder').innerText = `Temperatura: Pais -> ${temperature.countryCode} Mes -> ${temperature.month} Valor -> ${temperature.stat} Precipitación: Pais -> ${precipitation.countryCode} Mes -> ${precipitation.month} Valor -> ${precipitation.stat}`;
		});
		stompClient.send("/app/weather", {}, JSON.stringify({'name': 'alonso'}));
	});
};