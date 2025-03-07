# WebServer Project

## Overview
This project implements a lightweight yet robust HTTP web server in Java, offering both single-threaded and multithreaded implementations. It is designed to handle fundamental HTTP requests efficiently while demonstrating key concepts in networking, concurrency, and socket programming.

## Features
- Implements both single-threaded and multithreaded request handling architectures.
- Utilizes Java Socket API for low-level network communication.
- Supports HTTP GET requests for serving static content (HTML, CSS, JS, images).
- Demonstrates thread pooling for efficient request processing in the multithreaded version.
- Implements basic logging mechanisms for tracking client requests and server responses.
- Structured error handling for invalid or unsupported requests.

## Project Structure
```
webserver/
│-- Multithreading/  # Contains the multithreaded implementation using thread pooling
│-- SingleThreaded/  # Contains the single-threaded implementation for basic HTTP handling
│-- README.md        # Project documentation
```

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/ganjivamshiii/webserver.git
   ```
2. Navigate to the project directory:
   ```sh
   cd webserver
   ```
3. Compile the Java source files:
   ```sh
   javac -d bin src/*.java
   ```
4. Run the web server:
   ```sh
   java -cp bin SingleThreadedServer  # For single-threaded execution
   java -cp bin MultiThreadedServer   # For multithreaded execution
   ```

## Usage
- Place static web files (HTML, CSS, JS, images) inside the server’s working directory.
- Start the server and access it via a web browser or HTTP client:
  ```sh
  curl http://localhost:8080/index.html
  ```
- Server logs requests and responses to the console.
- In the multithreaded version, multiple client requests are handled concurrently.

## Technical Aspects
- **Networking**: Utilizes Java's `ServerSocket` and `Socket` classes for TCP communication.
- **Multithreading**: Implements a thread pool to handle multiple client requests concurrently.
- **I/O Operations**: Reads and writes HTTP request/response data efficiently.
- **HTTP Protocol Handling**: Parses basic HTTP headers and serves static content.
- **Concurrency Management**: Prevents resource contention in the multithreaded implementation.

## Performance Considerations
- The single-threaded version is suitable for low-traffic environments but becomes a bottleneck under heavy load.
- The multithreaded implementation improves throughput by leveraging thread pools to manage concurrent connections.
- Optimization strategies include caching mechanisms, asynchronous I/O, and non-blocking socket handling.

## Contributing
Contributions are encouraged to enhance performance, security, and feature set:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature-improvement`)
3. Commit your changes (`git commit -m 'Enhanced request parsing logic'`)
4. Push to your branch (`git push origin feature-improvement`)
5. Submit a pull request for review

## License
This project is licensed under the MIT License.

## Contact
For inquiries, feature requests, or bug reports, open an issue on GitHub or reach out via email.
