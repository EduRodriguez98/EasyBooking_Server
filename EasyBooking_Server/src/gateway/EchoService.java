package gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 * This class process the request of each client as a separated Thread.
 */
public class EchoService extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;

	public EchoService(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		//Echo server
		try {
			//Read request from the client
			String data = this.in.readUTF();			
			System.out.println("   - EchoService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
			
			//Send response to the client
			this.out.writeUTF(data.toUpperCase());			
			System.out.println("   - EchoService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err.println("   # EchoService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # EchoService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # EchoService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
}