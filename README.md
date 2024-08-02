School of Information and Physical Sciences University of Newcastle SENG4500 –Network & Distributed Computing Week 2 Workshop In this workshop we will be introduced to the Layer-4 concept of sockets. A socket is a virtual, persistent connection between a client and a server. In Java, sockets operate similar to I/O streams – so akin to reading/writing data into a file for example. This is a common abstraction taken from POSIX systems. You are to write two Java programs. Both will be CLI (i.e. no GUI required).  The “server” program will request to listen on a port. Remember from the Week 1 lecture that a port is how the Operating System knows what processes are wanting to receive inbound layer-4 network connections. Ports are identified by an integer. Pick a random integer between 1025 and 60000. This will be the port number your server will listen on. When the server receives a connection, it should output “CONNECTION OPEN" to the stdout console and then it should wait until it receives a “HELLO” string, followed by a new line. Once it receives that string it should respond with “HI, HOW ARE YOU”, followed by a new line, and then close the connection. The ”client” program will request to connect to the port your server is listening on. When you connect to socket you need two things – the port number (the same random number you picked above) and the host address, which in this case will be 127.0.0.1 (more on this later). When the client establishes the socket, it should immediately send the string “HELLO” followed by a new line character. It should then wait for a response from the server. Once a string, followed by a newline character, is received from the server it should output that to the console and close the connection. Feel free to output more information to the stdout from both CLI programs to help you debug what is happening. How do you interact with sockets and ports in Java? Well that’s what you are going to explore in this workshop. Here are some good places to start https://docs.oracle.com/javase/tutorial/networking/sockets/index.html https://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html Once you have this working I suggest running up Wireshark and seeing if you can capture the communication between your client and server. You will need to setup a filter to restrict the capture to the port you have chosen, and also ensure you are listening on the ‘localhost’ or ‘loopback’ interface. 
