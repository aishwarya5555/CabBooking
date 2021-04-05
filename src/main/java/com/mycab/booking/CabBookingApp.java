package com.mycab.booking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
/**
 * 
 java -jar booking-system-0.0.1-SNAPSHOT.jar "C:\Users\{useranme}\git\CabBooking\cab_data.text"
 *
 */

public class CabBookingApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filepath = args[0];
		System.out.println("Enter location Id");
		Integer locationId = Integer.valueOf(br.readLine());
		List<Location> locations = readCabData(filepath);

		TreeMap<Integer, Location> cars = new TreeMap<>();
		TreeMap<Integer, Location> bikes = new TreeMap<>();
		TreeMap<Integer, Location> autoes = new TreeMap<>();
		locations.stream().filter(loc -> loc.isAvailable()).forEach(cab -> {
			if (cab.isCar()) {
				cars.put(cab.getLocationId(), cab);
			}
			if (cab.isBike()) {
				bikes.put(cab.getLocationId(), cab);
			}
			if (cab.isAuto()) {
				autoes.put(cab.getLocationId(), cab);
			}
		});

		Integer nearCarLoc = minDiff(locationId, cars);
		Integer nearBikeLoc = minDiff(locationId, bikes);
		Integer nearAutoLoc = minDiff(locationId, autoes);

		System.out.println(cars.get(nearCarLoc).toString());
		System.out.println(autoes.get(nearAutoLoc).toString());
		System.out.println(bikes.get(nearBikeLoc).toString());
	}

	private static Integer minDiff(Integer locationId, TreeMap<Integer, Location> cabMap) {
		Integer nearLoc = null;
		Integer minDiff = null;
		for (Integer locId : cabMap.keySet()) {
			Integer diff = Math.abs(locId - locationId);
			if (minDiff == null || minDiff > diff) {
				minDiff = diff;
				nearLoc = locId;
			}
		}
		return nearLoc;
	}

	private static List<Location> readCabData(String filepath) throws IOException {
		File file = new File(filepath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		List<Location> locations = new ArrayList<Location>();
		while ((line = br.readLine()) != null) {
			String[] split = line.split(",");
			locations.add(new Location(Integer.valueOf(split[0]), split[1], split[2], split[3], split[4]));
		}
		br.close();
		return locations;
	}

}
