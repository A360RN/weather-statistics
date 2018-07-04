let stompClient = null;

window.onload = () => {
	console.log('me cargo');
	const socket = new SockJS('/weather-stat-socket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, (frame) => {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/weather', (weather) => {
			console.log(JSON.parse(weather.body));
		});
	});
	setInterval(() => {
		if (stompClient !== null) {
			stompClient.send("/app/weather", {}, JSON.stringify({'name': 'alonso'}));
		}
	}, 10000);
};