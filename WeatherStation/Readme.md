- Pub/Sub Model
- The Publisher is tightly coupled with the Observer
- Redis pub/sub behaves slightly different ( the publisher publishes the message to a channel and not directly to the subscribers)

- The WeatherStation doesn't need to be know about the concrete observer though.
- Observers can be dynamically added/removed at runtime.


**Use cases**

- Event listeners:- GUI frameworks often use observer pattern to implement event listeners for handling button clicks, input changes etc.
- Stock price monitoring:- When a stock price change, mutliple subscribers ( investors / systems) need to be notified of the change. 
- News publishing system
- Social media platforms:- to get updates from specific accounts
- Logging system:- Different logging handlers can observe events and log them as needed, such as to the console, file, remote server. 
