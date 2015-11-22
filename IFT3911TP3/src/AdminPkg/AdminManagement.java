package AdminPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import TransportationPkg.TripGeneral;
import AdminPkg.AirAdminPkg.AirFactory;
import AdminPkg.CruiseAdminPkg.CruiseFactory;
import AdminPkg.TrainAdminPkg.TrainFactory;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TripInstance;

public class AdminManagement extends Subject {
	protected Administrator _listAdmins;
	public UIAdmin _interacts;
	public TransportationFactory _unnamed_TransportationFactory_;
	public ICommand _commands;

	
	public static void main(String[] args)
	{
		initAir();
		initTrain();
		initCruise();
		
		
	}
	
	public static void initCruise(){

		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory cruiseFactory =  CruiseFactory.getInstance();
		TransportationHub portNY = cruiseFactory.createTransportationHub("NY Port");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(portNY);

		TransportationHub portHavana = cruiseFactory.createTransportationHub("Havana Malecon");
		tptManager._listTptHubs.add(portHavana);

		TransportationHub portRome = cruiseFactory.createTransportationHub("Rome Port");
		tptManager._listTptHubs.add(portRome);
		
		TransportationCompany princess = cruiseFactory.createTransportCompany("Princess Cruises");
		tptManager.addTransportCompany(princess);
		
		
		TransportationVehicle cruiseShip = cruiseFactory.createTransportVehicle(2400, "Rhode Island Ship Builders", princess);

		princess.addTransportationVehicle(cruiseShip);
		
		
		/*
		 * TRIP GENERAL NY_HAVANA
		 */
		Date dDepartNY_HAVANA = new Date();
		dDepartNY_HAVANA.setHours(10);
		dDepartNY_HAVANA.setMinutes(30);
		
		Date dArriveNY_HAVANA = new Date();
		dArriveNY_HAVANA.setHours(12);
		dArriveNY_HAVANA.setMinutes(30);
		TripGeneral NY_HAVANA = cruiseFactory.createTripGeneral(dDepartNY_HAVANA, dArriveNY_HAVANA, "NY_HAVANA1030", portNY, portHavana);
		tptManager.addTripGeneral(NY_HAVANA);
		princess.addTripGeneral(NY_HAVANA);
		
		
		/*
		 * Init of trip instances NY_HAVANA
		 */
		Date dDepartInstNY_HAVANA = new Date();
		dDepartInstNY_HAVANA.setDate(25);
		dDepartInstNY_HAVANA.setMonth(1);
		dDepartInstNY_HAVANA.setYear(2016);
		
		Date dArriveInstNY_HAVANA = new Date();
		dArriveInstNY_HAVANA.setDate(27);
		dArriveInstNY_HAVANA.setMonth(1);
		dArriveInstNY_HAVANA.setYear(2016);
		TripInstance NY_HAVANA1 = cruiseFactory.createTripInstance(dDepartInstNY_HAVANA, dArriveInstNY_HAVANA, 1001, 110);
		NY_HAVANA.addTripInstance(NY_HAVANA1);
		NY_HAVANA1.setTptVehicle(cruiseShip);
		
		Date dDepartInstNY_HAVANA2 = new Date();
		dDepartInstNY_HAVANA2.setDate(25);
		dDepartInstNY_HAVANA2.setMonth(1);
		dDepartInstNY_HAVANA2.setYear(2016);
		
		Date dArriveInstNY_HAVANA2 = new Date();
		dArriveInstNY_HAVANA2.setDate(27);
		dArriveInstNY_HAVANA2.setMonth(1);
		dArriveInstNY_HAVANA2.setYear(2016);
		TripInstance NY_HAVANA2 = cruiseFactory.createTripInstance(dDepartInstNY_HAVANA2, dArriveInstNY_HAVANA2, 1002, 107);
		NY_HAVANA.addTripInstance(NY_HAVANA2);
		NY_HAVANA2.setTptVehicle(cruiseShip);

		/*
		 * TRIP GENERAL NY_ROME
		 */
		Date dDepartNY_ROME = new Date();
		dDepartNY_ROME.setHours(8);
		dDepartNY_ROME.setMinutes(45);
		
		Date dArriveNY_ROME = new Date();
		dArriveNY_ROME.setHours(11);
		dArriveNY_ROME.setMinutes(55);
		TripGeneral NY_ROME = cruiseFactory.createTripGeneral(dDepartNY_ROME, dArriveNY_ROME, "NY_ROME845", portNY, portRome);
		tptManager.addTripGeneral(NY_ROME);
		princess.addTripGeneral(NY_ROME);

		
		/*
		 * Init of trip instances NY_ROME
		 */
		Date dDepartInstNY_ROME = new Date();
		dDepartInstNY_ROME.setDate(20);
		dDepartInstNY_ROME.setMonth(2);
		dDepartInstNY_ROME.setYear(2016);
		
		Date dArriveInstNY_ROME = new Date();
		dArriveInstNY_ROME.setDate(27);
		dArriveInstNY_ROME.setMonth(2);
		dArriveInstNY_ROME.setYear(2016);
		TripInstance NY_ROME1 = cruiseFactory.createTripInstance(dDepartInstNY_ROME, dArriveInstNY_ROME, 1003, 220);
		NY_ROME.addTripInstance(NY_ROME1);
		NY_ROME1.setTptVehicle(cruiseShip);
		
		Date dDepartInstNY_ROME2 = new Date();
		dDepartInstNY_ROME2.setDate(1);
		dDepartInstNY_ROME2.setMonth(2);
		dDepartInstNY_ROME2.setYear(2016);
		
		Date dArriveInstNY_ROME2 = new Date();
		dArriveInstNY_ROME2.setDate(8);
		dArriveInstNY_ROME2.setMonth(2);
		dArriveInstNY_ROME2.setYear(2016);
		TripInstance NY_ROME2 = cruiseFactory.createTripInstance(dDepartInstNY_ROME2, dArriveInstNY_ROME2, 1004, 240);
		NY_ROME.addTripInstance(NY_ROME2);
		NY_ROME2.setTptVehicle(cruiseShip);

		
		/*
		 * TRIP GENERAL HAVANA_ROME
		 */
		Date dDepartHAVANA_ROME = new Date();
		dDepartHAVANA_ROME.setHours(4);
		dDepartHAVANA_ROME.setMinutes(15);
		
		Date dArriveHAVANA_ROME = new Date();
		dArriveHAVANA_ROME.setHours(9);
		dArriveHAVANA_ROME.setMinutes(45);
		TripGeneral HAVANA_ROME = cruiseFactory.createTripGeneral(dDepartHAVANA_ROME, dArriveHAVANA_ROME, "HAVANA_ROME415", portHavana, portRome);
		tptManager.addTripGeneral(HAVANA_ROME);
		princess.addTripGeneral(HAVANA_ROME);


		/*
		 * Init of trip instances NY_ROME
		 */
		Date dDepartInstHAVANA_ROME = new Date();
		dDepartInstHAVANA_ROME.setDate(11);
		dDepartInstHAVANA_ROME.setMonth(3);
		dDepartInstHAVANA_ROME.setYear(2016);
		
		Date dArriveInstHAVANA_ROME = new Date();
		dArriveInstHAVANA_ROME.setDate(18);
		dArriveInstHAVANA_ROME.setMonth(3);
		dArriveInstHAVANA_ROME.setYear(2016);
		TripInstance HAVANA_ROME1 = cruiseFactory.createTripInstance(dDepartInstHAVANA_ROME, dArriveInstHAVANA_ROME, 1005, 170);
		HAVANA_ROME.addTripInstance(HAVANA_ROME1);
		HAVANA_ROME1.setTptVehicle(cruiseShip);
		
		System.out.println("HAVANA_ROME: " + HAVANA_ROME.get_heureArriveStr() + "  " + HAVANA_ROME._hubArrival.get_name() + " " + HAVANA_ROME._hubDeparture.get_name());

	}
	public static void initTrain(){
		
		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory trainFactory =  TrainFactory.getInstance();
		TransportationHub trainStationNY = trainFactory.createTransportationHub("Grand Central Station");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(trainStationNY);

		TransportationHub trainStationFL = trainFactory.createTransportationHub("Miami Station");
		tptManager._listTptHubs.add(trainStationFL);

		TransportationHub trainStationBoston = trainFactory.createTransportationHub("Boston Central Station");
		tptManager._listTptHubs.add(trainStationBoston);
		
		TransportationCompany amtrak = trainFactory.createTransportCompany("Amtrak");
		tptManager.addTransportCompany(amtrak);
		
		
		TransportationVehicle train1 = trainFactory.createTransportVehicle(100, "Bombardier", amtrak);

		amtrak.addTransportationVehicle(train1);
		
		
		/*
		 * TRIP GENERAL NY_FL
		 */
		Date dDepartNY_FL = new Date();
		dDepartNY_FL.setHours(10);
		dDepartNY_FL.setMinutes(30);
		
		Date dArriveNY_FL = new Date();
		dArriveNY_FL.setHours(12);
		dArriveNY_FL.setMinutes(30);
		TripGeneral NY_FL = trainFactory.createTripGeneral(dDepartNY_FL, dArriveNY_FL, "NYFL1030", trainStationNY, trainStationFL);
		tptManager.addTripGeneral(NY_FL);
		amtrak.addTripGeneral(NY_FL);

		/*
		 * Init of trip instances NY_FL
		 */
		Date dDepartInstNY_FL = new Date();
		dDepartInstNY_FL.setDate(11);
		dDepartInstNY_FL.setMonth(2);
		dDepartInstNY_FL.setYear(2016);
		
		Date dArriveInstNY_FL = new Date();
		dArriveInstNY_FL.setDate(14);
		dArriveInstNY_FL.setMonth(2);
		dArriveInstNY_FL.setYear(2016);
		TripInstance NY_FL1 = trainFactory.createTripInstance(dDepartInstNY_FL, dArriveInstNY_FL, 2001, 90);
		NY_FL.addTripInstance(NY_FL1);
		NY_FL1.setTptVehicle(train1);
		
		Date dDepartInstNY_FL2 = new Date();
		dDepartInstNY_FL2.setDate(1);
		dDepartInstNY_FL2.setMonth(2);
		dDepartInstNY_FL2.setYear(2016);
		
		Date dArriveInstNY_FL2 = new Date();
		dArriveInstNY_FL2.setDate(6);
		dArriveInstNY_FL2.setMonth(2);
		dArriveInstNY_FL2.setYear(2016);
		TripInstance NY_FL2 = trainFactory.createTripInstance(dDepartInstNY_FL2, dArriveInstNY_FL2, 2002, 95);
		NY_FL.addTripInstance(NY_FL2);
		NY_FL2.setTptVehicle(train1);
		

		
		/*
		 * TRIP GENERAL NY_BOSTON
		 */
		Date dDepartNY_BOSTON = new Date();
		dDepartNY_BOSTON.setHours(8);
		dDepartNY_BOSTON.setMinutes(45);
		
		Date dArriveNY_BOSTON = new Date();
		dArriveNY_BOSTON.setHours(11);
		dArriveNY_BOSTON.setMinutes(55);
		TripGeneral NY_BOSTON = trainFactory.createTripGeneral(dDepartNY_BOSTON, dArriveNY_BOSTON, "NYBOSTON845", trainStationNY, trainStationBoston);
		tptManager.addTripGeneral(NY_BOSTON);
		amtrak.addTripGeneral(NY_BOSTON);

		Date dDepartInstNY_BOSTON = new Date();
		dDepartInstNY_BOSTON.setDate(2);
		dDepartInstNY_BOSTON.setMonth(3);
		dDepartInstNY_BOSTON.setYear(2016);
		
		Date dArriveInstNY_BOSTON = new Date();
		dArriveInstNY_BOSTON.setDate(3);
		dArriveInstNY_BOSTON.setMonth(3);
		dArriveInstNY_BOSTON.setYear(2016);
		TripInstance NY_BOSTON1 = trainFactory.createTripInstance(dDepartInstNY_BOSTON, dArriveInstNY_BOSTON, 2006, 75);
		NY_BOSTON.addTripInstance(NY_BOSTON1);
		NY_BOSTON1.setTptVehicle(train1);
		
		
		/*
		 * TRIP GENERAL BOSTON_FL
		 */
		Date dDepartBOSTON_FL = new Date();
		dDepartBOSTON_FL.setHours(4);
		dDepartBOSTON_FL.setMinutes(15);
		
		Date dArriveBOSTON_FL = new Date();
		dArriveBOSTON_FL.setHours(9);
		dArriveBOSTON_FL.setMinutes(45);
		TripGeneral BOSTON_FL = trainFactory.createTripGeneral(dDepartBOSTON_FL, dArriveBOSTON_FL, "BOSTON_FL415", trainStationBoston, trainStationFL);
		tptManager.addTripGeneral(BOSTON_FL);
		amtrak.addTripGeneral(BOSTON_FL);

		/*
		 * init trip instances
		 */
		Date dDepartInstBOSTON_FL = new Date();
		dDepartInstBOSTON_FL.setDate(6);
		dDepartInstBOSTON_FL.setMonth(3);
		dDepartInstBOSTON_FL.setYear(2016);
		
		Date dArriveInstBOSTON_FL = new Date();
		dArriveInstBOSTON_FL.setDate(8);
		dArriveInstBOSTON_FL.setMonth(3);
		dArriveInstBOSTON_FL.setYear(2016);
		TripInstance BOSTON_FL1 = trainFactory.createTripInstance(dDepartInstBOSTON_FL, dArriveInstBOSTON_FL, 2007, 68);
		BOSTON_FL.addTripInstance(BOSTON_FL1);
		BOSTON_FL1.setTptVehicle(train1);
		
		System.out.println("BOSTON_FL: " + BOSTON_FL.get_heureArriveStr() + "  " + BOSTON_FL._hubArrival.get_name() + " " + BOSTON_FL._hubDeparture.get_name());

	}
	public static void initAir()
	{
		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory airFactory =  AirFactory.getInstance();
		TransportationHub airportYUL = airFactory.createTransportationHub("Pierre Elliot Trudeau");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(airportYUL);

		TransportationHub airportLAX = airFactory.createTransportationHub("Los Angeles International");
		tptManager._listTptHubs.add(airportLAX);

		TransportationHub airportJFK = airFactory.createTransportationHub("John F. Kennedy International");
		tptManager._listTptHubs.add(airportJFK);
		
		TransportationCompany westJet = airFactory.createTransportCompany("WestJet");
		tptManager.addTransportCompany(westJet);
		
		
		TransportationVehicle plane1 = airFactory.createTransportVehicle(100, "Boeing", westJet);

		westJet.addTransportationVehicle(plane1);
		
		
		/*
		 * TRIP GENERAL YUL-JFK
		 */
		Date dDepartYUL_JFK = new Date();
		dDepartYUL_JFK.setHours(10);
		dDepartYUL_JFK.setMinutes(30);
		
		Date dArriveYUL_JFK = new Date();
		dArriveYUL_JFK.setHours(12);
		dArriveYUL_JFK.setMinutes(30);
		TripGeneral YUL_JFK = airFactory.createTripGeneral(dDepartYUL_JFK, dArriveYUL_JFK, "YULJKF1030", airportYUL, airportJFK);
		tptManager.addTripGeneral(YUL_JFK);
		westJet.addTripGeneral(YUL_JFK);
		
		/*
		 * init trip instances
		 */
		Date dDepartInstYUL_JFK = new Date();
		dDepartInstYUL_JFK.setDate(6);
		dDepartInstYUL_JFK.setMonth(3);
		dDepartInstYUL_JFK.setYear(2016);
		
		Date dArriveInstYUL_JFK = new Date();
		dArriveInstYUL_JFK.setDate(8);
		dArriveInstYUL_JFK.setMonth(3);
		dArriveInstYUL_JFK.setYear(2016);
		TripInstance YUL_JKF1 = airFactory.createTripInstance(dDepartInstYUL_JFK, dArriveInstYUL_JFK, 3001, 130);
		YUL_JFK.addTripInstance(YUL_JKF1);
		YUL_JKF1.setTptVehicle(plane1);
		
		
		/*
		 * TRIP GENERAL YUL-LAX
		 */
		Date dDepartYUL_LAX = new Date();
		dDepartYUL_LAX.setHours(8);
		dDepartYUL_LAX.setMinutes(45);
		
		Date dArriveYUL_LAX = new Date();
		dArriveYUL_LAX.setHours(11);
		dArriveYUL_LAX.setMinutes(55);
		TripGeneral YUL_LAX = airFactory.createTripGeneral(dDepartYUL_LAX, dArriveYUL_LAX, "YULLAX845", airportYUL, airportLAX);
		tptManager.addTripGeneral(YUL_LAX);
		westJet.addTripGeneral(YUL_LAX);

		
		/*
		 * TRIP GENERAL LAX-JFK
		 */
		Date dDepartLAX_JFK = new Date();
		dDepartLAX_JFK.setHours(4);
		dDepartLAX_JFK.setMinutes(15);
		
		Date dArriveLAX_JFK = new Date();
		dArriveLAX_JFK.setHours(9);
		dArriveLAX_JFK.setMinutes(45);
		TripGeneral LAX_JFK = airFactory.createTripGeneral(dDepartLAX_JFK, dArriveLAX_JFK, "LAXJKF415", airportLAX, airportJFK);
		tptManager.addTripGeneral(LAX_JFK);
		westJet.addTripGeneral(LAX_JFK);


		
		System.out.println("LAX-JFK: " + LAX_JFK.get_heureArriveStr() + "  " + LAX_JFK._hubArrival.get_name() + " " + LAX_JFK._hubDeparture.get_name());

	}
	
	private AdminManagement() {
		throw new UnsupportedOperationException();
	}

	public AdminManagement getInstance() {
		throw new UnsupportedOperationException();
	}

	public TripGeneral findTripGeneral(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void addTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationVehicle(String aId) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationHub(int aId) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle findTransportationVehicle(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationVehicle(String aVehID) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportCompany(int aId) {
		throw new UnsupportedOperationException();
	}

	public void addTripGeneral(String aTripID, TransportationHub aDepart, TransportationHub aArrive, TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public TransportationHub findTransportationHub(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportationCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}
}