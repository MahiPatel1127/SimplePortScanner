import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {
    public static void main(String[] args) {

        System.out.println("Java Port Scanner");

        // Get the target and port range from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target (IP address): ");
        String target = scanner.nextLine();

        System.out.print("Enter starting port: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid starting port. Please enter a number.");
            return;
        }

        int startPort = scanner.nextInt();

        System.out.print("Enter ending port: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid ending port. Please enter a number.");
            return;
        }

        int endPort = scanner.nextInt();

        // Validate that the selected ports are within the valid range
        if (startPort < 1 || startPort > 65535 || endPort < 1 || endPort > 65535) {
            System.out.println("Invalid port range. Ports must be between 1 and 65535.");
            return;
        }

        // Make sure the starting port is not greater than the ending port
        if (startPort > endPort) {
            System.out.println("Invalid port range. Starting port must be less than or equal to ending port.");
            return;
        }

        // Record the start time to measure how long the scan takes
        long startTime = System.currentTimeMillis();

        System.out.println();
        System.out.println("Scanning " + target + " from port " + startPort + " to " + endPort + "...");
        System.out.println();

        boolean foundOpenPort = false;
        int openPortCount = 0;

        // Check each port within the user-selected range
        for (int port = startPort; port <= endPort; port++) {
            if (scanPort(target, port)) {
                String service = getServiceName(port);
                System.out.println("Port " + port + " is OPEN - Common service: " + service);
                foundOpenPort = true;
                openPortCount++;
            }
        }

        if (!foundOpenPort) {
            System.out.println("No open ports found.");
        }

        // Record the end time after all ports have been scanned
        long endTime = System.currentTimeMillis();

        // Display the final scan results
        System.out.println();
        System.out.println("========== Scan Summary ==========");
        System.out.println("Target: " + target);
        System.out.println("Ports scanned: " + (endPort - startPort + 1));
        System.out.println("Open ports: " + openPortCount);
        System.out.println("Scan time: " + (endTime - startTime) + " ms");
        System.out.println("==================================");
    }

    // Attempts to connect to the specified port and returns true if the connection
    public static boolean scanPort(String target, int port) {
        try {
            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(target, port);
            socket.connect(address, 200);
            socket.close();
            return true;
        } catch (ConnectException e) {
            return false;
        } catch (SocketTimeoutException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    // Returns the common service normally associated with the specified port
    public static String getServiceName(int port) {

        switch (port) {

            case 21:
                return "FTP";

            case 22:
                return "SSH";

            case 25:
                return "SMTP";

            case 53:
                return "DNS";

            case 80:
                return "HTTP";

            case 110:
                return "POP3";

            case 143:
                return "IMAP";

            case 135:
                return "Microsoft RPC";

            case 443:
                return "HTTPS";

            case 445:
                return "SMB";

            case 3306:
                return "MySQL";

            default:
                return "Unknown";
        }
    }
} 
