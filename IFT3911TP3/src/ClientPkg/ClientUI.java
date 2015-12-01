package ClientPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import AdminPkg.Observer;
import AdminPkg.Searcher;
import AdminPkg.SimulationData;
import AdminPkg.TransportationManager;
import AdminPkg.UIAdmin;
import CommonComponentsPkg.Adresse;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.GenerateurConfirmation;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Booking;
import ReservationPkg.Client;
import ReservationPkg.IClientUI;
import ReservationPkg.Passager;
import ReservationPkg.PassagerReal;
import ReservationPkg.Reservation;
import ReservationPkg.Sexe;
import TransportationPkg.ComfortClass;
import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;
import TransportationPkg.AviationPkg.Vol;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.TrainPkg.Trajet;

public class ClientUI extends JFrame implements IClientUI, Observer {


	static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args)
	{
		SimulationData.initAir();
		SimulationData.initTrain();
		SimulationData.initCruise();
		ClientSimulationData.initClientSimulationData();
		ClientUI cGUI = ClientUI.getInstance();
		UIAdmin aGUI = UIAdmin.getInstance();
	

		//cGUI.update(new Subject());
	}

	private static ClientUI instance;
	private Client client;
	public static JScrollPane scrollPane;
	public static JTextArea  taOutput;
	public static JTextArea taInput;
	public static JButton bInput;
	
	private ClientUI()
	{
		
		super("ClientUI");
		this.client = ClientSimulationData.getClient();
		this.setSize(600,650);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		initWindow();
		this.setVisible(true);
	}

	private void initWindow() {

		/*
		 * Init output JLabel
		 */
		taOutput = new JTextArea (showMenu());
		taOutput.setEditable(false);
		taOutput.setBorder(new TitledBorder("Output"));
		taOutput.setBackground(Color.WHITE);
		taOutput.setOpaque(true);
		JPanel jpCenter = new JPanel();
		JPanel jpOutput = new JPanel();
		JScrollPane sp = new JScrollPane(taOutput); 
		sp.setPreferredSize(new Dimension(500,450));
		sp.setBounds(23, 40, 394, 191);

		sp.setViewportView(taOutput);
		jpOutput.add(sp);

		this.add(jpCenter);
		
		taInput = new JTextArea("");
		taInput.setBorder(new TitledBorder("Input"));
		taInput.setPreferredSize(new Dimension(410,100));
		taInput.setBackground(Color.WHITE);
		taInput.setOpaque(true);
		JPanel jpInput = new JPanel();
		jpInput.add(taInput);

		bInput = new JButton("Apply Command");


		bInput.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				processInput(taInput.getText());
				//updateOutput(taInput.getText());
			}

			private void processInput(String input) {
				boolean validInput = false;
				int iInput = -1;
				try{
					iInput = Integer.parseInt(input);
					validInput = true;
				}
				catch(Exception e)
				{
					updateOutput("***Invalid input, please try again***\n" + instance.showMenu());
					taInput.setText("");
				}

				if(validInput)
					processCommand(iInput);
			

			}
			private void processCommand(int iInput) {
				updateOutput("User Entered " + iInput);
				JFrame frame = new JFrame("FrameDemo");
				Searcher searcher = Searcher.getInstance();
				if(iInput == 1){
					ClientTripVisitor visitorFlights = new ClientTripVisitor();
					ClientTripVisitor visitorTrain = new ClientTripVisitor();
					ClientTripVisitor visitorCruises = new ClientTripVisitor();
					for(TripGeneral tripGeneral : TransportationManager.getInstance().get_listTripGenerals()){
						if (tripGeneral instanceof Vol){
							for(TripInstance tripInstance: tripGeneral.get_tripInstances()){
								for(ComfortClass cc : tripInstance.get_comfortClasses()){	
										tripInstance.accept(visitorFlights);
										cc.accept(visitorFlights);
								}
							}
						} else if (tripGeneral instanceof Croisiere){
							for(TripInstance tripInstance: tripGeneral.get_tripInstances()){
								for(ComfortClass cc : tripInstance.get_comfortClasses()){	
										tripInstance.accept(visitorCruises);
										cc.accept(visitorCruises);
								}
							}
						} else if (tripGeneral instanceof Trajet)
							for(TripInstance tripInstance: tripGeneral.get_tripInstances()){
								for(ComfortClass cc : tripInstance.get_comfortClasses()){	
										tripInstance.accept(visitorTrain);
										cc.accept(visitorTrain);
								}
							}
					}
					updateOutput("\nFlights");
					updateOutput(visitorFlights.getResult());
					updateOutput("\nCruises");
					updateOutput(visitorCruises.getResult());
					updateOutput("\nTrain cruise");
					updateOutput(visitorTrain.getResult());
				}
				if(iInput == 2){
					JPanel panel = new JPanel();
					JTextField depart = new JTextField();
					JTextField arrive = new JTextField();
					JTextField departDate = new JTextField();
					JTextField section = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Origin airport ID:"));
					panel.add(depart);
					panel.add(new JLabel("Destination airport ID:"));
					panel.add(arrive);
					panel.add(new JLabel("Departure date with the format: dd/mm/yyyy"));
					panel.add(departDate);
					panel.add(new JLabel("LETTER of the section you want to be in. F: Premiere, A: Affaire, P: Economique premium, E: Economique:"));
					panel.add(section);
					
					int result = JOptionPane.showConfirmDialog(null, panel, 
				               "Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);
				      if (result == JOptionPane.OK_OPTION) {
						SearchCriteria criteria = new SearchCriteria();
												
						if(!depart.getText().isEmpty()){
							criteria.set__transportationHubNameDeparture(depart.getText().toUpperCase());
						}
						if(!arrive.getText().isEmpty()){
							criteria.set_transportationHubNameArrival(arrive.getText().toUpperCase());
						}
						if(!departDate.getText().isEmpty()){
							String[] dateArray = departDate.getText().split("/");
							Date dateDepart = new Date();
							dateDepart.setDate(Integer.parseInt(dateArray[0]));
							dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
							dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
							criteria.set_tripDepartureDate(dateDepart);
						}
						if(!section.getText().isEmpty()){
							criteria.set_sectionType(ComfortClassEnum.valueOf(section.getText().toUpperCase()));
						}
						
						String resultText= SystemeClient.getInstance().findTripInstance(criteria);
						updateOutput(resultText + "\n");
				      }
				} else if(iInput == 3){
					JPanel panel = new JPanel();
					JTextField depart = new JTextField();
					JTextField arrive = new JTextField();
					JTextField departDate = new JTextField();
					JTextField section = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Port ID:"));
					panel.add(depart);
					panel.add(new JLabel("Departure date with the format: dd/mm/yyyy"));
					panel.add(departDate);
					panel.add(new JLabel("LETTER of the section you want to be in. I: Interieure, O: Vue sur sur ocean, S: Suite, F: Famille, D: Famille Deluxe."));
					panel.add(section);
					
					int result = JOptionPane.showConfirmDialog(null, panel, 
				               "Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);
				      if (result == JOptionPane.OK_OPTION) {
						SearchCriteria criteria = new SearchCriteria();
						
						if(!depart.getText().isEmpty()){
							criteria.set__transportationHubNameDeparture(depart.getText());
							criteria.set_transportationHubNameArrival(depart.getText());
						}
						if(!departDate.getText().isEmpty()){
							String[] dateArray = departDate.getText().split("/");
							Date dateDepart = new Date();
							dateDepart.setDate(Integer.parseInt(dateArray[0]));
							dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
							dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
							criteria.set_tripDepartureDate(dateDepart);
						}
						if(!section.getText().isEmpty()){
							criteria.set_sectionType(ComfortClassEnum.valueOf(section.getText().toUpperCase()));
						}
						
						String resultText = SystemeClient.getInstance().findTripInstance(criteria);
						updateOutput(resultText + "\n");
				      }
				}else if(iInput == 4){
					SearchCriteria criteria = new SearchCriteria();
					JPanel panel = new JPanel();
					JTextField depart = new JTextField();
					JTextField arrive = new JTextField();
					JTextField departDate = new JTextField();
					JTextField section = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Please input departure train station ID"));
					panel.add(depart);
					panel.add(new JLabel("Please input arrival train station ID"));
					panel.add(arrive);
					panel.add(new JLabel("Please enter departure date with the format: dd/mm/yyyy"));
					panel.add(departDate);
					panel.add(new JLabel("Please enter the LETTER of the section you want to be in. F: Premiere, E: Economique"));
					panel.add(section);
					
					int result = JOptionPane.showConfirmDialog(null, panel, 
				               "Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);
					
					if (result == JOptionPane.OK_OPTION) {
						if(!depart.getText().isEmpty()){
							criteria.set__transportationHubNameDeparture(depart.getText().toUpperCase());
							
						}
						if(!arrive.getText().isEmpty()){
							criteria.set_transportationHubNameArrival(arrive.getText().toUpperCase());
						}
						if(!departDate.getText().isEmpty()){
							String[] dateArray = departDate.getText().split("/");
							Date dateDepart = new Date();
							dateDepart.setDate(Integer.parseInt(dateArray[0]));
							dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
							dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
							criteria.set_tripDepartureDate(dateDepart);
						}
						if(!section.getText().isEmpty()){
							criteria.set_sectionType(ComfortClassEnum.valueOf(section.getText().toUpperCase()));
						}
						
						String resultText = SystemeClient.getInstance().findTripInstance(criteria);
						updateOutput(resultText + "\n");
					}
						
				}else if(iInput == 5){
					SearchCriteria sc = new SearchCriteria();
					
					JPanel panel = new JPanel();
					JTextField generalID = new JTextField();
					JTextField dateD = new JTextField();
					JTextField section = new JTextField();
					JTextField nbPassenger = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Enter the trip ID:"));
					panel.add(generalID);
					panel.add(new JLabel("Departure date with the format: dd/mm/yyyy"));
					panel.add(dateD);
					panel.add(new JLabel("LETTER of the section you want to be in. F: Premiere, A: Affaire, P: Economique premium, E: Economique:"));
					panel.add(section);
					panel.add(new JLabel("Number of passenger:"));
					panel.add(nbPassenger);
					int result = JOptionPane.showConfirmDialog(null, panel, 
				               "Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);
				      if (result == JOptionPane.OK_OPTION) {
				    	 
				    	  if(!generalID.getText().isEmpty()){
								sc.set_tripIDNumber(generalID.getText());
							}
							if(!dateD.getText().isEmpty()){
								String[] dateArray = dateD.getText().split("/");
								Date dateDepart = new Date();
								dateDepart.setDate(Integer.parseInt(dateArray[0]));
								dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
								dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
								sc.set_tripDepartureDate(dateDepart);
							}
							if(!section.getText().isEmpty()){
								sc.set_sectionType(ComfortClassEnum.valueOf(section.getText().toUpperCase()));
							}
							
							Vector<GenericSeat> seats = SystemeClient.getInstance().findGenericSeat(sc);
							if(seats != null){
								if(seats.size() >= Integer.parseInt(nbPassenger.getText())){
									String confirmation = SystemeClient.getInstance().makeReservation(seats,Integer.parseInt(nbPassenger.getText()), client);
									update("Here is your reservation number:"+confirmation+ "\n");
								}
								else
									update("Il n'y a plus de place pour: "+nbPassenger.getText()+" personne\n");
							}
							else
									update("Recherche contient 0 element.");
				      }
				      
				      
				}else if(iInput == 6){
					JPanel panel = new JPanel();
					JTextField reservationID = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Please enter the reservation ID you wish to pay:"));
					panel.add(reservationID);
					int result = JOptionPane.showConfirmDialog(null, panel, 
				               "Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						if(!reservationID.getText().equals(null)){
							int reservationIdInt = Integer.parseInt(reservationID.getText());
							Reservation reservation = client.findReservation(reservationIdInt);
							
							if (reservation != null){
								TripInstance tripInstanceReservation = reservation.get_tripInstance();
								JPanel panelReservation = new JPanel();
								panelReservation.setLayout(new GridLayout(9,2));
								JTextField creditCardNumber = new JTextField();
								JTextField creditCardExpiration = new JTextField();
								panelReservation.add(new JLabel("Reservation number: "));
								panelReservation.add(new JLabel(reservation.get_number()+""));
								panelReservation.add(new JLabel("Trip number: "));
								panelReservation.add(new JLabel(tripInstanceReservation.get_tripDescription().get_tripID()));
								panelReservation.add(new JLabel("Origin: "));
								panelReservation.add(new JLabel(tripInstanceReservation.get_tripDescription().get_hubDeparture().get_name()));
								panelReservation.add(new JLabel("Destination: "));
								panelReservation.add(new JLabel(tripInstanceReservation.get_tripDescription().get_hubArrival().get_name()));
								panelReservation.add(new JLabel("Departure Date: "));
								panelReservation.add(new JLabel(tripInstanceReservation.get_dateDepartStr()));
								panelReservation.add(new JLabel("Arrival Date: "));
								panelReservation.add(new JLabel(tripInstanceReservation.get_dateArriveStr()));
								
								panelReservation.add(new JLabel("Credit card number:"));
								panelReservation.add(creditCardNumber);
								panelReservation.add(new JLabel("Credit card expiration (mm/yyyy):"));
								panelReservation.add(creditCardExpiration);
								panelReservation.add(new JLabel("Amount owed:"));
								panelReservation.add(new JLabel(reservation.getReservationPrice() + ""));

								int resultPanelReservation = JOptionPane.showConfirmDialog(panel, panelReservation, 
							               "Pay reservation", JOptionPane.OK_CANCEL_OPTION);
								if(resultPanelReservation == JOptionPane.OK_OPTION){
									
									for(int i=0; i<reservation.get_listPassagers().size(); i++){
										JPanel panelAddPassenger = new JPanel();
										panelAddPassenger.setLayout(new GridLayout(8,2));
										JTextField firstNameTextField = new JTextField();
										JTextField lastNameTextField = new JTextField();
										JTextField adresseTextField = new JTextField();
										JTextField courrielTextField = new JTextField();
										JTextField numTelTextField = new JTextField();
										JTextField sexeTextField = new JTextField();
										JTextField dateNaissanceTextField = new JTextField();
										JTextField numPassportTextField = new JTextField();
										panelAddPassenger.add(new JLabel("First name: "));
										panelAddPassenger.add(firstNameTextField);
										panelAddPassenger.add(new JLabel("Last name: "));
										panelAddPassenger.add(lastNameTextField);
										panelAddPassenger.add(new JLabel("Adresse: "));
										panelAddPassenger.add(adresseTextField);
										panelAddPassenger.add(new JLabel("Email: "));
										panelAddPassenger.add(courrielTextField);
										panelAddPassenger.add(new JLabel("Phone number: "));
										panelAddPassenger.add(numTelTextField);
										panelAddPassenger.add(new JLabel("Sex (Male, Female): "));
										panelAddPassenger.add(sexeTextField);
										panelAddPassenger.add(new JLabel("Birthday (dd/mm/yyyy): "));
										panelAddPassenger.add(dateNaissanceTextField);
										panelAddPassenger.add(new JLabel("Passport number: "));
										panelAddPassenger.add(numPassportTextField);
										PassagerReal passager = new PassagerReal();
										int resultPanelPassager= JOptionPane.showConfirmDialog(panelReservation, panelAddPassenger, 
									               "Passager " + (i + 1), JOptionPane.OK_CANCEL_OPTION);
										if (resultPanelPassager == JOptionPane.OK_OPTION){
											passager.set_firstName(firstNameTextField.getText());
											passager.set_lastName(lastNameTextField.getText());
											Adresse adresse = new Adresse();
											adresse.set_streetName(adresseTextField.getText());
											passager.set_adresse(adresse);
											passager.set_courriel(courrielTextField.getText());
											passager.set_numTel(numTelTextField.getText());
											passager.set_sexe(Sexe.valueOf(sexeTextField.getText().toUpperCase()));
											String[] dateArray = dateNaissanceTextField.getText().split("/");
											Date dateNaissance = new Date();
											dateNaissance.setDate(Integer.parseInt(dateArray[0]));
											dateNaissance.setMonth(Integer.parseInt(dateArray[1]) - 1);
											dateNaissance.setYear(Integer.parseInt(dateArray[2]) - 1900);
											passager.setDateNaissance(dateNaissance);
											passager.setNumPassport(numPassportTextField.getText());
											GenericSeat seat = reservation.get_reservedSeats().get(i);
											passager.setAssignedSeat((InstanceSeat)seat);
											seat.get_state().confirmed(seat);
										}
										reservation.get_listPassagers().set(i, passager);
									}
									String[] dateArray1 = creditCardExpiration.getText().split("/");
									Date dateExpiration = new Date();
									dateExpiration.setMonth(Integer.parseInt(dateArray1[0]) - 1);
									dateExpiration.setYear(Integer.parseInt(dateArray1[1]) - 1900);
									Booking booking = new Booking();
									booking.set_client_(client);
									booking.set_totalPrice(reservation.getReservationPrice());
									booking.set_accountBalance(reservation.getReservationPrice());
									booking.set_number(GenerateurConfirmation.getInstance().get_numeroConfirmation());
									booking.set_tripInstance(reservation.get_tripInstance());
									
									for(Passager passager: reservation.get_listPassagers()){
										booking.addPassenger(passager);
									}
									booking.pay(reservation.getReservationPrice(), creditCardNumber.getText(), dateExpiration);
									client.addOrder(booking);
									updateOutput("Thank you! You have paid the amount of: " + booking.get_totalPrice() + ". Here is your booking number: " + booking.get_number());
								}
								
								} else{
									updateOutput("No reservation with id: " + reservationID.getText());
							}
							} 
						
						}
					}else if(iInput == 7){
						JPanel panel = new JPanel();
						JTextField reservationID = new JTextField();
						panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
						
						panel.add(new JLabel("Enter Reservation Number:"));
						panel.add(reservationID);
						
							
						int result= JOptionPane.showConfirmDialog(null, panel, 
					            "Cancel Reservation", JOptionPane.OK_CANCEL_OPTION);
								//updateOutput("Aucune reservation avec le id:" + reservationID.getText());
						if(result == JOptionPane.OK_OPTION){
									
							if(!reservationID.getText().isEmpty()){
									String resultCancel=SystemeClient.getInstance().cancelReservation(reservationID.getText(),client);
									updateOutput(resultCancel+"\n");							
							}
						
						}
							
					
					}
					else if(iInput == 8){
						JPanel panel = new JPanel();
						JTextField bookingIDTextField = new JTextField();
						panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
						
						panel.add(new JLabel("Enter Booking Number:"));
						panel.add(bookingIDTextField);
						
							
						int result= JOptionPane.showConfirmDialog(null, panel, 
					            "Cancel Booking", JOptionPane.OK_CANCEL_OPTION);
	
						if(result == JOptionPane.OK_OPTION){
							if(!bookingIDTextField.getText().isEmpty()){
								
								Booking booking = client.findBooking(Integer.parseInt(bookingIDTextField.getText()));
								if(booking != null){
									JPanel panelBooking = new JPanel();
																	
									panelBooking.add(new JLabel("Booking: "));
									panelBooking.add(new JLabel(booking.get_number() + ""));
									int counter=1;
									for(Passager passager: booking.get_listPassagers() ){
										panelBooking.add(new JLabel("Passager " + counter+ ": "));
										panelBooking.add(new JLabel(passager.get_firstName() + " " + passager.get_lastName()));
										panelBooking.add(new JLabel("Seat cost: "));
										panelBooking.add(new JLabel (passager.getAssignedSeat().getPrice()+""));
										counter++;
									}
									panelBooking.add(new JLabel("Price paid: "));
									panelBooking.add(new JLabel( booking.get_totalPrice() + ""));
									panelBooking.add(new JLabel("Refund amount: "));
									panelBooking.add(new JLabel( booking.get_refundableAmount()+""));
									panelBooking.add(new JLabel( "Are you sure you wish to refund your booking?"));
									panelBooking.setLayout(new GridLayout(4 + (2*counter-1),2));
									int resultBooking= JOptionPane.showConfirmDialog(panel, panelBooking, 
								            "Cancel booking", JOptionPane.OK_CANCEL_OPTION);
									if(resultBooking == JOptionPane.OK_OPTION){
										client._listOrders.remove(booking);
										updateOutput("Booking number " + booking.get_number()+" has been cancelled. The amount of "+ booking.get_refundableAmount() + "$ has been refunded to your credit "
												+ "card: " + booking.getPaiement().get_creditcard().get_digits());
									}
								} else {
									updateOutput("No booking with id: " + bookingIDTextField.getText());
								}
							}
//							if(!bookingIDTextField.getText().isEmpty()){
//									String resultCancel=SystemeClient.getInstance().cancelReservation(bookingIDTextField.getText(),client);
//									updateOutput(resultCancel+"\n");							
//							}
						
						}
					}else if(iInput == 9){
						taOutput.setText(showMenu());
					}
			}				
		} );
		jpInput.add(bInput);
		jpCenter.add(jpOutput);
		jpCenter.add(jpInput);
		this.add(jpCenter);

	}

	
	private final void updateOutput(String text) {
		taOutput.setText(taOutput.getText() + "\n" + text);	
	} 
	public final String showMenu()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("*******MENU*******\n");
		sb.append("1: Show all Trips \n");
		sb.append("2: Find Flight \n");
		sb.append("3: Find Cruise \n");
		sb.append("4: Find Train Ride \n");
		sb.append("5: Make reservation \n");
		sb.append("6: Pay reservation \n");
		sb.append("7: Cancel reservation \n");
		sb.append("8: Cancel Booking \n");
		sb.append("9: Clear screen \n");
		return sb.toString();

	}

	public static ClientUI getInstance()
	{
		if(instance == null)
			instance = new ClientUI();
		return instance;
	}
@Override
	public TripInstance findTripInstance(SearchCriteria aSc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstanceSeat findSeat(SearchCriteria aSc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOrderChangeDeadline(SearchCriteria aSc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showAlert(String aAlert) {
		// TODO Auto-generated method stub
		
	}

	public void update(String message) {
		updateOutput(message);
	}

}
