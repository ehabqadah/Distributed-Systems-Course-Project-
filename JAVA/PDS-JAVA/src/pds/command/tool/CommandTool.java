package pds.command.tool;

import java.io.Console;
import java.util.Scanner;

import pds.network.Node;

public class CommandTool {

	public static void main(String[] args) {

		Node node = new Node("1");

		node.setupServerPart();
		System.out
				.println(" Enter command join or signoff or  startElection or exit");

		while (true) {
			String command = null;
			try {
				Scanner in = new Scanner(System.in);

				// Reads a single line from the console
				// and stores into name variable
				command = in.nextLine();
				// read line from the user input
				String[] commandAndParms = command.split(" ");
				switch (commandAndParms[0]) {

				case "exit":
					System.exit(0);
					break;
				case "signoff":
					node.signOff();
					break;

				case "join":
					if (commandAndParms.length > 1)
						node.join(commandAndParms[1]);
					else
						System.out
								.println("enter join and ip like join 192.168.1.1");
					break;

				case "startElection":
					node.startElection();
					break;
				default:
					break;
				}

			} catch (Exception ex) {

				// if any error occurs
				ex.printStackTrace();
			}
		}

	}

}
