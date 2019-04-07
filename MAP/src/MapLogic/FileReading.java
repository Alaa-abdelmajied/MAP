package MapLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileReading {

	private String[][] passengerLogin = new String[100][2];
	private String[][] mangerLogin = new String[100][2];
	private String[][] driverLogin = new String[100][2];
	private int driverCounter = 0;
	private int passengerCounter = 0;
	private int managerCounter = 0;
	private String accountType;
	private String line;
	private ArrayList<String> source = new ArrayList<String>();
	private ArrayList<String> destination = new ArrayList<String>();
	private ArrayList<Double> time = new ArrayList<Double>();
	private ArrayList<String> vehicle = new ArrayList<String>();
	private ArrayList<Integer> numberOfStops = new ArrayList<Integer>();
	private ArrayList<Double> ticketPrice = new ArrayList<Double>();
	private ArrayList<String> passengerName = new ArrayList<String>();
	private ArrayList<Integer> numberOfTrips = new ArrayList<Integer>();
	private ArrayList<String> driverName = new ArrayList<String>();
	private ArrayList<String> driverGender = new ArrayList<String>();
	private ArrayList<Integer> driverNumber = new ArrayList<Integer>();
	private ArrayList<String> driverVehicle = new ArrayList<String>();
	private ArrayList<ArrayList<String>> driverTrips = new ArrayList<ArrayList<String>>();

	public void readLoginFile() throws IOException {

		File file = new File("login.txt");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			accountType = stringTokenizer.nextToken();
			if (accountType.equals("Manager") || accountType.equals("Driver")) {
				if (accountType.equals("Driver")) {
					driverLogin[driverCounter][0] = stringTokenizer.nextToken();
					driverLogin[driverCounter][1] = stringTokenizer.nextToken();
					driverCounter++;
				} else if (accountType.equals("Manager")) {
					mangerLogin[managerCounter][0] = stringTokenizer.nextToken();
					mangerLogin[managerCounter][1] = stringTokenizer.nextToken();
					managerCounter++;
				}
			} else if (accountType.equals("Passenger")) {
				passengerLogin[passengerCounter][0] = stringTokenizer.nextToken();
				passengerLogin[passengerCounter][1] = stringTokenizer.nextToken();
				passengerCounter++;
			}
		}
	}

	public void readTripFile() throws IOException {

		File file = new File("trips.txt");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ":,");
			stringTokenizer.nextToken();
			source.add(stringTokenizer.nextToken());
			stringTokenizer.nextToken();
			destination.add(stringTokenizer.nextToken());
			stringTokenizer.nextToken();
			time.add(Double.parseDouble(stringTokenizer.nextToken()));
			stringTokenizer.nextToken();
			vehicle.add(stringTokenizer.nextToken());
			stringTokenizer.nextToken();
			numberOfStops.add(Integer.parseInt(stringTokenizer.nextToken()));
			stringTokenizer.nextToken();
			ticketPrice.add(Double.parseDouble(stringTokenizer.nextToken()));
		}
	}

	public void readVipFile() throws IOException {

		File file = new File("vipPassengers");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			while (stringTokenizer.hasMoreTokens()) {
				passengerName.add(stringTokenizer.nextToken());
				numberOfTrips.add(Integer.parseInt(stringTokenizer.nextToken()));
			}
		}
	}
	
	public void readDriverFile() throws IOException {

		File file = new File("DriverFile");

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			driverName.add(stringTokenizer.nextToken());
			driverGender.add(stringTokenizer.nextToken());
			driverNumber.add(Integer.parseInt(stringTokenizer.nextToken()));
			driverVehicle.add(stringTokenizer.nextToken());
			
			
			
		}
	}

	public String[][] getPassengerLogin() {
		return passengerLogin;
	}

	public String[][] getMangerLogin() {
		return mangerLogin;
	}

	public String[][] getDriverLogin() {
		return driverLogin;
	}

	public ArrayList<String> getSource() {
		return source;
	}

	public ArrayList<String> getDestination() {
		return destination;
	}

	public ArrayList<Double> getTime() {
		return time;
	}

	public ArrayList<String> getVehicle() {
		return vehicle;
	}

	public ArrayList<Integer> getNumberOfStops() {
		return numberOfStops;
	}

	public ArrayList<Double> getTicketPrice() {
		return ticketPrice;
	}

	public ArrayList<String> getPassengerName() {
		return passengerName;
	}

	public ArrayList<Integer> getNumberOfTrips() {
		return numberOfTrips;
	}

}
