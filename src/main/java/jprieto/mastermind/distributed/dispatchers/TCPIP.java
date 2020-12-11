package jprieto.mastermind.distributed.dispatchers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import jprieto.mastermind.types.Error;
import jprieto.utils.ColorUtils;
import jprieto.mastermind.types.Color;

public class TCPIP extends jprieto.utils.TCPIP {

	public static TCPIP createClientSocket() {
		try {
			Socket socket = new Socket("localhost", 2020);
			System.out.println("Cliente> Establecida conexion");
			return new TCPIP(socket);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static TCPIP createServerSocket() {
		try {
			ServerSocket serverSocket = new ServerSocket(2020);
			System.out.println("Servidor> Esperando conexion...");
			Socket socket = serverSocket.accept();
			System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
					+ socket.getPort());
			return new TCPIP(serverSocket, socket);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public TCPIP(Socket socket) {
		super(socket);
	}
	
	public TCPIP(ServerSocket serverSocket, Socket socket) {
		super(serverSocket, socket);
	}

	public void send(Error value) {
		if (value == null) {
			this.send("null");
		}else {
			this.send(value.name());
		}
	}
	
	public void send() {
		this.send("null");
	}
	
	public void send(List<Color> value)
	{
		String convertedValue = "";
		for(int i = 0; i< value.size(); i++)
		{
			convertedValue += ColorUtils.INITIALS[value.get(i).ordinal()];
		}
		this.send(convertedValue);
	}

	public Error receiveError() {
		String error = this.receiveLine();
		if (error.equals("null")) {
			return null;
		}
		return Error.valueOf(error);
	}
	
	public List<Color> receiveProposedCombination() {
		String characters = this.receiveLine();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorUtils.getInstance(characters.charAt(i)));
		}
		return colors;
	}

	public void close() {
		this.send(FrameType.CLOSE.name());
		super.close();
	}	

}
