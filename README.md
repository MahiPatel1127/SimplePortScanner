# SimplePortScanner

A beginner-friendly Java TCP port scanner that checks a user-defined range of ports and identifies common services associated with open ports.

## Overview

This project is a simple cybersecurity tool developed in Java to understand how port scanning works.

The scanner attempts to establish a TCP connection to each port in the selected range. If a connection is successful, the port is reported as open.

For commonly used ports, the program also displays the service normally associated with that port number.

## Features

* Scan a user-defined IP address
* Scan a custom range of ports from 1 to 65,535
* Detect open TCP ports using socket connections
* Use a connection timeout to avoid waiting too long on each port
* Display common service associations for selected ports
* Count the total number of open ports
* Measure and display the scan duration
* Validate port numbers and port ranges
* Handle invalid numeric input
* Display a clear scan summary

## Technologies Used

* Java
* Java Networking (`Socket` and `InetSocketAddress`)
* Java `Scanner`
* Exception handling
* VS Code
* JDK 23

## How It Works

The scanner follows these basic steps:

1. The user enters the target IP address.
2. The user enters a starting and ending port.
3. The program validates the port range.
4. Each port in the selected range is checked.
5. The scanner attempts a TCP connection to the port.
6. If the connection succeeds, the port is reported as open.
7. The program displays the common service associated with known port numbers.
8. A final summary shows the number of ports scanned, open ports, and scan duration.

## How to Run

### 1.Open the project folder

Open the SimplePortScanner folder in VS Code.

### 2. Compile the program

Open the VS Code terminal and run:
```bash
javac PortScanner.java
```

### 3. Run the program

```bash
java PortScanner
```

### 4. Enter the target and port range

For example:

```text
Enter target (IP address): 127.0.0.1
Enter starting port: 1
Enter ending port: 100
```

## Example Output

```text
Java Port Scanner

Scanning 127.0.0.1 from port 1 to 100...

Port 80 is OPEN - Common service: HTTP
Port 135 is OPEN - Common service: Microsoft RPC

========== Scan Summary ==========
Target: 127.0.0.1
Ports scanned: 100
Open ports: 2
Scan time: XXXXX ms
==================================
```

*The exact open ports and scan time will vary depending on the services running on the target system.*

## Testing

The program was tested using the following cases:

* Normal port range scan
* Detection of known open ports on the local machine
* Invalid starting port using non-numeric input
* Invalid ending port using non-numeric input
* Port numbers below 1
* Port numbers above 65,535
* Starting port greater than ending port
* Full scan from port 1 to 65,535

All planned test cases completed successfully.

## Limitations

* The scanner identifies services based on common port-number associations rather than performing actual service fingerprinting.
* The scanner performs TCP connection checks and does not perform UDP scanning.
* Scanning speed is limited because ports are checked sequentially.
* The tool is intended for learning and basic security testing.

## Future Improvements

Possible future improvements include:

* Multithreaded scanning for improved performance
* More detailed service detection
* UDP port scanning
* Exporting scan results to a file
* Additional command-line options

## Disclaimer

This project is intended for educational purposes and authorized security testing only.

Only scan systems that you own or have explicit permission to test.
