package AdminPkg;

import java.util.Date;

import AdminPkg.AirAdminPkg.AirFactory;
import AdminPkg.CruiseAdminPkg.CruiseFactory;
import AdminPkg.TrainAdminPkg.TrainFactory;
import CommonComponentsPkg.VehiculeLayoutEnum;
import TransportationPkg.ComfortClass;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;
import TransportationPkg.AviationPkg.AirConfort;
import TransportationPkg.AviationPkg.AirEtroit;
import TransportationPkg.AviationPkg.AirLarge;
import TransportationPkg.AviationPkg.AirMoyen;
import TransportationPkg.AviationPkg.AirPhysicalSeat;
import TransportationPkg.CroisierePkg.Famille;
import TransportationPkg.CroisierePkg.FamilyDeluxe;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.CroisierePkg.Interieur;
import TransportationPkg.CroisierePkg.ItineraryItem;
import TransportationPkg.CroisierePkg.LayoutDeluxe;
import TransportationPkg.CroisierePkg.LayoutFamille;
import TransportationPkg.CroisierePkg.LayoutInterior;
import TransportationPkg.CroisierePkg.LayoutOcean;
import TransportationPkg.CroisierePkg.LayoutSuite;
import TransportationPkg.CroisierePkg.Ocean;
import TransportationPkg.CroisierePkg.PhysicalCabine;
import TransportationPkg.TrainPkg.TrainEtroit;
import TransportationPkg.TrainPkg.TrainPhysicalSeat;

public class SimulationData {

	public static void initCruise(){

		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory cruiseFactory =  CruiseFactory.getInstance();
		TransportationHub portNY = cruiseFactory.createTransportationHub("NY Port", "NYP");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(portNY);

		TransportationHub portHavana = cruiseFactory.createTransportationHub("Havana Malecon", "HAP");
		tptManager._listTptHubs.add(portHavana);

		TransportationHub portRome = cruiseFactory.createTransportationHub("Rome Port", "ROP");
		tptManager._listTptHubs.add(portRome);
		
		TransportationCompany princess = cruiseFactory.createTransportCompany("Princess Cruises", "PRINCE");
		tptManager.addTransportCompany(princess);
		
		/*
		 * Init cruise ship
		 */
		TransportationVehicle cruiseShip = cruiseFactory.createTransportVehicle(2400, "Rhode Island Ship Builders", princess);
		
		for(int i = 0; i<10; i++)
		{
			VehicleLayout li = new LayoutInterior();
			VehicleLayout lo = new LayoutOcean();
			VehicleLayout ls = new LayoutSuite();
			VehicleLayout lf = new LayoutFamille();
		//No layoutEnum for cruise ship
			cruiseShip.addVehicleLayout(li);
			li.configureSeating();
			cruiseShip.addVehicleLayout(lo);
			lo.configureSeating();
			cruiseShip.addVehicleLayout(ls);
			ls.configureSeating();
			cruiseShip.addVehicleLayout(lf);
			lf.configureSeating();
		}
		
		/*
		 *TO PRINT OUT ROOM NUMBERS FOR EACH SEAT
		for(int i =0; i<cruiseShip.get_layoutSections().size(); i++)
		{

				for(int k=0; k<cruiseShip.get_layoutSections().get(i)._seating.size(); k++)
				{
					PhysicalCabine pc = (PhysicalCabine)cruiseShip.get_layoutSections().get(i)._seating.get(k);
					System.out.println(pc.getRoomIdentifier());
				}
		
		}
		
		 */
		
		princess.addTransportationVehicle(cruiseShip);
		/*
		 * TRIP GENERAL HAVANA
		 */
		Date dDepartHAVANA = new Date();
		dDepartHAVANA.setHours(10);
		dDepartHAVANA.setMinutes(30);
		
		Date dArriveHAVANA = new Date();
		dArriveHAVANA.setHours(12);
		dArriveHAVANA.setMinutes(30);
		TripGeneral HAVANA = cruiseFactory.createTripGeneral(dDepartHAVANA, dArriveHAVANA,princess, portHavana, portHavana);
		tptManager.addTripGeneral(HAVANA);
		princess.addTripGeneral(HAVANA);
		
		/*
		 * Init of trip instances HAVANA
		 */
		Date dDepartInst_HAVANA = new Date();
		dDepartInst_HAVANA.setDate(25);
		dDepartInst_HAVANA.setMonth(1);
		dDepartInst_HAVANA.setYear(116);
		
		Date dArriveInstHAVANA = new Date();
		dArriveInstHAVANA.setDate(27);
		dArriveInstHAVANA.setMonth(1);
		dArriveInstHAVANA.setYear(116);
		TripInstance HAVANA1 = cruiseFactory.createTripInstance(dDepartInst_HAVANA, dArriveInstHAVANA,  110);
		HAVANA.addTripInstance(HAVANA1);
		
		HAVANA1.setTptVehicle(cruiseShip);
		HAVANA1.set_tripDescription(HAVANA);
		for(int i=0; i<cruiseShip._layoutSections.size(); i++)
		{
			VehicleLayout vl = cruiseShip._layoutSections.get(i);
			if(vl == null)
				System.out.println("BEFORE");
			
			HAVANA1.assignLayoutToClass(vl);
			
		}
		//assign to all comfortclass the tripinstance
		for(ComfortClass section : HAVANA1.get_comfortClasses()){
			section.set_tripInstace(HAVANA1);
		}
	
		Date dDepartInstNY_HAVANA2 = new Date();
		dDepartInstNY_HAVANA2.setDate(27);
		dDepartInstNY_HAVANA2.setMonth(1);
		dDepartInstNY_HAVANA2.setYear(116);
		
		Date dArriveInstNY_HAVANA2 = new Date();
		dArriveInstNY_HAVANA2.setDate(28);
		dArriveInstNY_HAVANA2.setMonth(1);
		dArriveInstNY_HAVANA2.setYear(116);
		TripInstance NY_HAVANA2 = cruiseFactory.createTripInstance(dDepartInstNY_HAVANA2, dArriveInstNY_HAVANA2, 107);
		HAVANA.addTripInstance(NY_HAVANA2);
		NY_HAVANA2.setTptVehicle(cruiseShip);
		NY_HAVANA2.set_tripDescription(HAVANA);
	
		for(int i=0; i<cruiseShip._layoutSections.size(); i++)
		{
			VehicleLayout vl = cruiseShip._layoutSections.get(i);
			NY_HAVANA2.assignLayoutToClass(vl);
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : NY_HAVANA2.get_comfortClasses()){
					section.set_tripInstace(NY_HAVANA2);
				}
		/*
		 * TRIP GENERAL NY_ROME
		 */
		Date dDepartNY_ROME = new Date();
		dDepartNY_ROME.setHours(8);
		dDepartNY_ROME.setMinutes(45);
		
		Date dArriveNY_ROME = new Date();
		dArriveNY_ROME.setHours(8);
		dArriveNY_ROME.setMinutes(45);
		

		TripGeneral NY_ROME = cruiseFactory.createTripGeneral(dDepartNY_ROME, dArriveNY_ROME, princess, portNY, portNY);
		ItineraryItem i1 = new ItineraryItem();

		Date dArrivei1 = new Date();
		dArrivei1.setHours(11);
		dArrivei1.setMinutes(55);
		Date dDeparti1 = new Date();
		dDeparti1.setHours(3);
		dDeparti1.setMinutes(45);
		i1.set_dateArrive(dArrivei1);
		i1.set_dateLeave(dDeparti1);
		i1.set_port(portRome);
		
		((Croisiere)NY_ROME).addItineraryItem(i1);

		tptManager.addTripGeneral(NY_ROME);
		princess.addTripGeneral(NY_ROME);
		
		/*
		 * Init of trip instances NY_ROME
		 */
		Date dDepartInstNY_ROME = new Date();
		dDepartInstNY_ROME.setDate(20);
		dDepartInstNY_ROME.setMonth(2);
		dDepartInstNY_ROME.setYear(116);
		
		Date dArriveInstNY_ROME = new Date();
		dArriveInstNY_ROME.setDate(27);
		dArriveInstNY_ROME.setMonth(2);
		dArriveInstNY_ROME.setYear(116);
		TripInstance NY_ROME1 = cruiseFactory.createTripInstance(dDepartInstNY_ROME, dArriveInstNY_ROME, 220);
		NY_ROME.addTripInstance(NY_ROME1);
		NY_ROME1.setTptVehicle(cruiseShip);
		NY_ROME1.set_tripDescription(NY_ROME);
		
		for(int i=0; i<cruiseShip._layoutSections.size(); i++)
		{
			VehicleLayout vl = cruiseShip._layoutSections.get(i);
			NY_ROME1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : NY_ROME1.get_comfortClasses()){
					section.set_tripInstace(NY_ROME1);
				}
		Date dDepartInstNY_ROME2 = new Date();
		dDepartInstNY_ROME2.setDate(1);
		dDepartInstNY_ROME2.setMonth(2);
		dDepartInstNY_ROME2.setYear(116);
		
		Date dArriveInstNY_ROME2 = new Date();
		dArriveInstNY_ROME2.setDate(8);
		dArriveInstNY_ROME2.setMonth(2);
		dArriveInstNY_ROME2.setYear(116);
		TripInstance NY_ROME2 = cruiseFactory.createTripInstance(dDepartInstNY_ROME2, dArriveInstNY_ROME2, 240);
		NY_ROME.addTripInstance(NY_ROME2);
		NY_ROME2.setTptVehicle(cruiseShip);
		NY_ROME2.set_tripDescription(NY_ROME);

		for(int i=0; i<cruiseShip._layoutSections.size(); i++)
		{
			VehicleLayout vl = cruiseShip._layoutSections.get(i);
			NY_ROME2.assignLayoutToClass(vl);
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : NY_ROME2.get_comfortClasses()){
					section.set_tripInstace(NY_ROME2);
				}
		
		/*
		 * TRIP GENERAL HAVANA_ROME
		 */
		Date dDepartHAVANA_ROME = new Date();
		dDepartHAVANA_ROME.setHours(4);
		dDepartHAVANA_ROME.setMinutes(15);
		
		Date dArriveHAVANA_ROME = new Date();
		dArriveHAVANA_ROME.setHours(9);
		dArriveHAVANA_ROME.setMinutes(45);
		TripGeneral HAVANA_ROME = cruiseFactory.createTripGeneral(dDepartHAVANA_ROME, dArriveHAVANA_ROME, princess, portHavana, portHavana);
		
		
		ItineraryItem i2 = new ItineraryItem();

		Date dArrivei2 = new Date();
		dArrivei2.setHours(11);
		dArrivei2.setMinutes(55);
		Date dDeparti2 = new Date();
		dDeparti2.setHours(3);
		dDeparti2.setMinutes(45);
		i2.set_dateArrive(dArrivei2);
		i2.set_dateLeave(dDeparti2);
		i2.set_port(portRome);
		
		((Croisiere)NY_ROME).addItineraryItem(i1);
		
		tptManager.addTripGeneral(HAVANA_ROME);
		princess.addTripGeneral(HAVANA_ROME);

		/*
		 * Init of trip instances NY_ROME
		 */
		Date dDepartInstHAVANA_ROME = new Date();
		dDepartInstHAVANA_ROME.setDate(11);
		dDepartInstHAVANA_ROME.setMonth(3);
		dDepartInstHAVANA_ROME.setYear(116);
		
		Date dArriveInstHAVANA_ROME = new Date();
		dArriveInstHAVANA_ROME.setDate(18);
		dArriveInstHAVANA_ROME.setMonth(3);
		dArriveInstHAVANA_ROME.setYear(116);
		TripInstance HAVANA_ROME1 = cruiseFactory.createTripInstance(dDepartInstHAVANA_ROME, dArriveInstHAVANA_ROME, 170);
		HAVANA_ROME.addTripInstance(HAVANA_ROME1);
		HAVANA_ROME1.setTptVehicle(cruiseShip);
		HAVANA_ROME1.set_tripDescription(HAVANA_ROME);
		
		for(int i=0; i<cruiseShip._layoutSections.size(); i++)
		{
			VehicleLayout vl = cruiseShip._layoutSections.get(i);
			HAVANA_ROME1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : HAVANA_ROME1.get_comfortClasses()){
					section.set_tripInstace(HAVANA_ROME1);
				}
		System.out.println("HAVANA_ROME: " + HAVANA_ROME.get_heureArriveStr() + "  " + HAVANA_ROME._hubArrival.get_name() + " " + HAVANA_ROME._hubDeparture.get_name());

	}
	

	public static void initTrain(){
		
		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory trainFactory =  TrainFactory.getInstance();
		TransportationHub trainStationNY = trainFactory.createTransportationHub("Grand Central Station", "GCS");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(trainStationNY);

		TransportationHub trainStationFL = trainFactory.createTransportationHub("Miami Station", "MIS");
		tptManager._listTptHubs.add(trainStationFL);

		TransportationHub trainStationBoston = trainFactory.createTransportationHub("Boston Central Station", "BCS");
		tptManager._listTptHubs.add(trainStationBoston);
		
		TransportationCompany amtrak = trainFactory.createTransportCompany("Amtrak", "AMTRAK");
		tptManager.addTransportCompany(amtrak);
		
		
		TransportationVehicle train1 = trainFactory.createTransportVehicle(400, "Bombardier", amtrak);
		
			VehicleLayout te = new TrainEtroit();
			te.set_capacity(400);
			VehiculeLayoutEnum s = VehiculeLayoutEnum.S;
			te.setVehiculeLayoutType(s);
			train1.addVehicleLayout(te);
			te.configureSeating();
		
		
		/*
		 * TO PRINT TRAIN SEAT NUMBERS
		 */
		/*
		for(int i =0; i<train1.get_layoutSections().size(); i++)
		{
			for(int j=0; j<train1.get_layoutSections().get(i).get_seating().size(); j++){
				TrainPhysicalSeat tfs = (TrainPhysicalSeat)train1.get_layoutSections().get(i).get_seating().get(j);
				System.out.println(tfs.get_columnLetter() + "  " + tfs.get_rowNumber());
			}
		}
		*/
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
		TripGeneral NY_FL = trainFactory.createTripGeneral(dDepartNY_FL, dArriveNY_FL, amtrak, trainStationNY, trainStationFL);
		tptManager.addTripGeneral(NY_FL);
		amtrak.addTripGeneral(NY_FL);
		/*
		 * Init of trip instances NY_FL
		 */
		Date dDepartInstNY_FL = new Date();
		dDepartInstNY_FL.setDate(11);
		dDepartInstNY_FL.setMonth(2);
		dDepartInstNY_FL.setYear(116);
		
		Date dArriveInstNY_FL = new Date();
		dArriveInstNY_FL.setDate(14);
		dArriveInstNY_FL.setMonth(2);
		dArriveInstNY_FL.setYear(116);
		TripInstance NY_FL1 = trainFactory.createTripInstance(dDepartInstNY_FL, dArriveInstNY_FL, 90);
		NY_FL.addTripInstance(NY_FL1);
		NY_FL1.setTptVehicle(train1);
		NY_FL1.set_tripDescription(NY_FL);
		
		for(int i=0; i<train1._layoutSections.size(); i++)
		{
			VehicleLayout vl = train1._layoutSections.get(i);
			NY_FL1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
		for(ComfortClass section : NY_FL1.get_comfortClasses()){
			section.set_tripInstace(NY_FL1);
		}
		
		Date dDepartInstNY_FL2 = new Date();
		dDepartInstNY_FL2.setDate(1);
		dDepartInstNY_FL2.setMonth(2);
		dDepartInstNY_FL2.setYear(116);
	
		Date dArriveInstNY_FL2 = new Date();
		dArriveInstNY_FL2.setDate(6);
		dArriveInstNY_FL2.setMonth(2);
		dArriveInstNY_FL2.setYear(116);
		TripInstance NY_FL2 = trainFactory.createTripInstance(dDepartInstNY_FL2, dArriveInstNY_FL2, 95);
		NY_FL.addTripInstance(NY_FL2);
		NY_FL2.setTptVehicle(train1);
		NY_FL2.set_tripDescription(NY_FL);
		
		for(int i=0; i<train1._layoutSections.size(); i++)
		{
			VehicleLayout vl = train1._layoutSections.get(i);
			NY_FL2.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : NY_FL2.get_comfortClasses()){
					section.set_tripInstace(NY_FL2);
				}

		
		/*
		 * TRIP GENERAL NY_BOSTON
		 */
		Date dDepartNY_BOSTON = new Date();
		dDepartNY_BOSTON.setHours(8);
		dDepartNY_BOSTON.setMinutes(45);
		
		Date dArriveNY_BOSTON = new Date();
		dArriveNY_BOSTON.setHours(11);
		dArriveNY_BOSTON.setMinutes(55);
		TripGeneral NY_BOSTON = trainFactory.createTripGeneral(dDepartNY_BOSTON, dArriveNY_BOSTON, amtrak,trainStationNY, trainStationBoston);
		tptManager.addTripGeneral(NY_BOSTON);
		amtrak.addTripGeneral(NY_BOSTON);
		
		Date dDepartInstNY_BOSTON = new Date();
		dDepartInstNY_BOSTON.setDate(2);
		dDepartInstNY_BOSTON.setMonth(3);
		dDepartInstNY_BOSTON.setYear(116);
		
		Date dArriveInstNY_BOSTON = new Date();
		dArriveInstNY_BOSTON.setDate(3);
		dArriveInstNY_BOSTON.setMonth(3);
		dArriveInstNY_BOSTON.setYear(116);
		TripInstance NY_BOSTON1 = trainFactory.createTripInstance(dDepartInstNY_BOSTON, dArriveInstNY_BOSTON, 75);
		NY_BOSTON.addTripInstance(NY_BOSTON1);
		NY_BOSTON1.setTptVehicle(train1);
		NY_BOSTON1.set_tripDescription(NY_BOSTON);
		
		for(int i=0; i<train1._layoutSections.size(); i++)
		{
			VehicleLayout vl = train1._layoutSections.get(i);
			NY_BOSTON1.assignLayoutToClass(vl); 
		}
		
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : NY_BOSTON1.get_comfortClasses()){
					section.set_tripInstace(NY_BOSTON1);
				}
		/*
		 * TRIP GENERAL BOSTON_FL
		 */
		Date dDepartBOSTON_FL = new Date();
		dDepartBOSTON_FL.setHours(4);
		dDepartBOSTON_FL.setMinutes(15);
		
		Date dArriveBOSTON_FL = new Date();
		dArriveBOSTON_FL.setHours(9);
		dArriveBOSTON_FL.setMinutes(45);
		TripGeneral BOSTON_FL = trainFactory.createTripGeneral(dDepartBOSTON_FL, dArriveBOSTON_FL, amtrak, trainStationBoston, trainStationFL);
		tptManager.addTripGeneral(BOSTON_FL);
		amtrak.addTripGeneral(BOSTON_FL);
		/*
		 * init trip instances
		 */
		Date dDepartInstBOSTON_FL = new Date();
		dDepartInstBOSTON_FL.setDate(6);
		dDepartInstBOSTON_FL.setMonth(3);
		dDepartInstBOSTON_FL.setYear(116);
		
		Date dArriveInstBOSTON_FL = new Date();
		dArriveInstBOSTON_FL.setDate(8);
		dArriveInstBOSTON_FL.setMonth(3);
		dArriveInstBOSTON_FL.setYear(116);
		TripInstance BOSTON_FL1 = trainFactory.createTripInstance(dDepartInstBOSTON_FL, dArriveInstBOSTON_FL, 68);
		BOSTON_FL.addTripInstance(BOSTON_FL1);
		BOSTON_FL1.setTptVehicle(train1);
		BOSTON_FL1.set_tripDescription(BOSTON_FL);
		
		for(int i=0; i<train1._layoutSections.size(); i++)
		{
			VehicleLayout vl = train1._layoutSections.get(i);
			BOSTON_FL1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : BOSTON_FL1.get_comfortClasses()){
					section.set_tripInstace(BOSTON_FL1);
				}
		System.out.println("BOSTON_FL: " + BOSTON_FL.get_heureArriveStr() + "  " + BOSTON_FL._hubArrival.get_name() + " " + BOSTON_FL._hubDeparture.get_name());

	}
	public static void initAir()
	{
		TransportationManager tptManager = TransportationManager.getInstance();

		TransportationFactory airFactory =  AirFactory.getInstance();
		TransportationHub airportYUL = airFactory.createTransportationHub("Pierre Elliot Trudeau", "YUL");
		//System.out.println("AIRPORT: " + airportYUL.get_name());
		tptManager._listTptHubs.add(airportYUL);

		TransportationHub airportLAX = airFactory.createTransportationHub("Los Angeles International", "LAX");
		tptManager._listTptHubs.add(airportLAX);

		TransportationHub airportJFK = airFactory.createTransportationHub("John F. Kennedy International", "JFK");
		tptManager._listTptHubs.add(airportJFK);
		
		TransportationCompany westJet = airFactory.createTransportCompany("WestJet", "WESJET");
		tptManager.addTransportCompany(westJet);
		
		
		TransportationVehicle plane1 = airFactory.createTransportVehicle(100, "Boeing", westJet);
		
		/*
		 * Set up Plane Layout
		 */
		VehicleLayout ae = new AirEtroit();
		ae.set_capacity(30);
		ae.configureSeating();
		VehiculeLayoutEnum s = VehiculeLayoutEnum.S;
		ae.setVehiculeLayoutType(s);
		plane1.addVehicleLayout(ae);


		VehicleLayout ac = new AirConfort();
		ac.set_capacity(25);
		ac.configureSeating();
		VehiculeLayoutEnum c = VehiculeLayoutEnum.C;
		ac.setVehiculeLayoutType(c);
		plane1.addVehicleLayout(ac);


		VehicleLayout am = new AirMoyen();
		am.set_capacity(25);
		am.configureSeating();
		VehiculeLayoutEnum m = VehiculeLayoutEnum.M;
		am.setVehiculeLayoutType(m);
		plane1.addVehicleLayout(am);

		VehicleLayout al = new AirLarge();
		al.set_capacity(20);
		al.configureSeating();
		VehiculeLayoutEnum l = VehiculeLayoutEnum.L;
		al.setVehiculeLayoutType(l);
		plane1.addVehicleLayout(al);

		/*
		 * TO PRINT OUT SEATING
		for(int i =0; i<plane1.get_layoutSections().size(); i++)
		{
			for(int j=0; j<plane1.get_layoutSections().get(i).get_seating().size(); j++){
				AirPhysicalSeat tfs = (AirPhysicalSeat)plane1.get_layoutSections().get(i).get_seating().get(j);
				System.out.println(tfs.get_columnLetter() + "  " + tfs.get_rowNumber());
			}
		}
		*/
		
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
		TripGeneral YUL_JFK = airFactory.createTripGeneral(dDepartYUL_JFK, dArriveYUL_JFK, westJet,airportYUL, airportJFK);
		tptManager.addTripGeneral(YUL_JFK);
		westJet.addTripGeneral(YUL_JFK);
		
		/*
		 * init trip instances
		 */
		Date dDepartInstYUL_JFK = new Date();
		dDepartInstYUL_JFK.setDate(6);
		dDepartInstYUL_JFK.setMonth(3);
		dDepartInstYUL_JFK.setYear(116);
		
		Date dArriveInstYUL_JFK = new Date();
		dArriveInstYUL_JFK.setDate(6);
		dArriveInstYUL_JFK.setMonth(3);
		dArriveInstYUL_JFK.setYear(116);
		TripInstance YUL_JKF1 = airFactory.createTripInstance(dDepartInstYUL_JFK, dArriveInstYUL_JFK, 130);
		YUL_JFK.addTripInstance(YUL_JKF1);
		YUL_JKF1.setTptVehicle(plane1);
		YUL_JKF1.set_tripDescription(YUL_JFK);
		
		for(int i=0; i<plane1._layoutSections.size(); i++)
		{
			
			VehicleLayout vl = plane1._layoutSections.get(i);
			YUL_JKF1.assignLayoutToClass(vl);
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : YUL_JKF1.get_comfortClasses()){
					section.set_tripInstace(YUL_JKF1);
				}
		
		/*
		 * TRIP GENERAL YUL-LAX
		 */
		Date dDepartYUL_LAX = new Date();
		dDepartYUL_LAX.setHours(8);
		dDepartYUL_LAX.setMinutes(45);
		
		Date dArriveYUL_LAX = new Date();
		dArriveYUL_LAX.setHours(11);
		dArriveYUL_LAX.setMinutes(55);
		TripGeneral YUL_LAX = airFactory.createTripGeneral(dDepartYUL_LAX, dArriveYUL_LAX, westJet,airportYUL, airportLAX);
		tptManager.addTripGeneral(YUL_LAX);
		westJet.addTripGeneral(YUL_LAX);
		/*
		 * init trip instances
		 */
		Date dDepartInstYUL_LAX = new Date();
		dDepartInstYUL_LAX.setDate(7);
		dDepartInstYUL_LAX.setMonth(3);
		dDepartInstYUL_LAX.setYear(116);
		
		Date dArriveInstYUL_LAX = new Date();
		dArriveInstYUL_LAX.setDate(7);
		dArriveInstYUL_LAX.setMonth(3);
		dArriveInstYUL_LAX.setYear(116);
		TripInstance YUL_LAX1 = airFactory.createTripInstance(dDepartInstYUL_LAX, dArriveInstYUL_LAX, 200);
		YUL_LAX.addTripInstance(YUL_LAX1);
		YUL_LAX1.setTptVehicle(plane1);
		YUL_LAX1.set_tripDescription(YUL_LAX);
		
		for(int i=0; i<plane1._layoutSections.size(); i++)
		{
			VehicleLayout vl = plane1._layoutSections.get(i);
			YUL_LAX1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
		for(ComfortClass section : YUL_LAX1.get_comfortClasses()){
			section.set_tripInstace(YUL_LAX1);
		}
		
		Date dDepartInstYUL_LAX2 = new Date();
		dDepartInstYUL_LAX2.setDate(8);
		dDepartInstYUL_LAX2.setMonth(3);
		dDepartInstYUL_LAX2.setYear(116);
		
		Date dArriveInstYUL_LAX2 = new Date();
		dArriveInstYUL_LAX2.setDate(8);
		dArriveInstYUL_LAX2.setMonth(3);
		dArriveInstYUL_LAX2.setYear(116);
		TripInstance YUL_LAX2 = airFactory.createTripInstance(dDepartInstYUL_LAX2, dArriveInstYUL_LAX2, 200);
		YUL_LAX.addTripInstance(YUL_LAX2);
		YUL_LAX2.setTptVehicle(plane1);
		YUL_LAX2.set_tripDescription(YUL_LAX);
		
		for(int i=0; i<plane1._layoutSections.size(); i++)
		{
			VehicleLayout vl = plane1._layoutSections.get(i);
			YUL_LAX2.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
		for(ComfortClass section : YUL_LAX2.get_comfortClasses()){
			section.set_tripInstace(YUL_LAX2);
		}
		/*
		 * TRIP GENERAL LAX-JFK
		 */
		Date dDepartLAX_JFK = new Date();
		dDepartLAX_JFK.setHours(4);
		dDepartLAX_JFK.setMinutes(15);
		
		Date dArriveLAX_JFK = new Date();
		dArriveLAX_JFK.setHours(9);
		dArriveLAX_JFK.setMinutes(45);
		TripGeneral LAX_JFK = airFactory.createTripGeneral(dDepartLAX_JFK, dArriveLAX_JFK, westJet, airportLAX, airportJFK);
		tptManager.addTripGeneral(LAX_JFK);
		westJet.addTripGeneral(LAX_JFK);
		LAX_JFK.setTptCompany(westJet);
		
		/*
		 * init trip instances
		 */
		Date dDepartInstLAX_JFK = new Date();
		dDepartInstLAX_JFK.setDate(10);
		dDepartInstLAX_JFK.setMonth(3);
		dDepartInstLAX_JFK.setYear(116);
		
		Date dArriveInstLAX_JFK  = new Date();
		dArriveInstLAX_JFK.setDate(10);
		dArriveInstLAX_JFK.setMonth(3);
		dArriveInstLAX_JFK.setYear(116);
		TripInstance LAX_JFK1 = airFactory.createTripInstance(dDepartInstLAX_JFK, dArriveInstLAX_JFK, 210);
		LAX_JFK.addTripInstance(LAX_JFK1);
		LAX_JFK1.setTptVehicle(plane1);
		LAX_JFK1.set_tripDescription(LAX_JFK);
		
		for(int i=0; i<plane1._layoutSections.size(); i++)
		{
			VehicleLayout vl = plane1._layoutSections.get(i);
			LAX_JFK1.assignLayoutToClass(vl); 
		}
		//assign to all comfortclass the tripinstance
				for(ComfortClass section : LAX_JFK1.get_comfortClasses()){
					section.set_tripInstace(LAX_JFK1);
				}
		Date dDepartInstLAX_JFK2 = new Date();
		dDepartInstLAX_JFK2.setDate(11);
		dDepartInstLAX_JFK2.setMonth(3);
		dDepartInstLAX_JFK2.setYear(116);
		
		Date dArriveInstLAX_JFK2  = new Date();
		dArriveInstLAX_JFK2.setDate(11);
		dArriveInstLAX_JFK2.setMonth(3);
		dArriveInstLAX_JFK2.setYear(116);
		TripInstance LAX_JFK2 = airFactory.createTripInstance(dDepartInstLAX_JFK2, dArriveInstLAX_JFK2, 212);
		LAX_JFK.addTripInstance(LAX_JFK2);
		LAX_JFK2.setTptVehicle(plane1);
		LAX_JFK2.set_tripDescription(LAX_JFK);
		
		for(int i=0; i<plane1._layoutSections.size(); i++)
		{
			VehicleLayout vl = plane1._layoutSections.get(i);
			LAX_JFK2.assignLayoutToClass(vl); 
		}

		//assign to all comfortclass the tripinstance
				for(ComfortClass section : LAX_JFK2.get_comfortClasses()){
					section.set_tripInstace(LAX_JFK2);
				}
		System.out.println("LAX-JFK: " + LAX_JFK.get_heureArriveStr() + "  " + LAX_JFK._hubArrival.get_name() + " " + LAX_JFK._hubDeparture.get_name());

	}
	
}
