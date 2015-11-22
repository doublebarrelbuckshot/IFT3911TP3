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