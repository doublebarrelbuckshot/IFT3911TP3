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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import AdminPkg.Observer;
import AdminPkg.Searcher;
import AdminPkg.SimulationData;
import AdminPkg.TransportationManager;
import AdminPkg.UIAdmin;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.IClientUI;
import ReservationPkg.Reservation;
import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

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
	public static JTextArea  taOutput;
	public static JTextArea taInput;
	public static JButton bInput;
	
	private ClientUI()
	{
		
		super("ClientUI");
		this.client = new Client();
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
		taOutput.setPreferredSize(new Dimension(540,450));
		taOutput.setBackground(Color.WHITE);
		taOutput.setOpaque(true);
		JPanel jpCenter = new JPanel();
		JPanel jpOutput = new JPanel();
		jpOutput.add(taOutput);


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
					panel.add(new JLabel("LETTER of the section you want to be in. F: Premiere, A: Affaire, P: Economique premium, E: Economique:"));
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
					String originPort = JOptionPane.showInputDialog("Please input departure train station ID");
					String destinationPort = JOptionPane.showInputDialog("Please input arrival train station ID");;
					
					
					String dateDepartStr = JOptionPane.showInputDialog("Please enter departure date with the format: dd/mm/yyyy");
					
					
					String sectionType = JOptionPane.showInputDialog("Please enter the LETTER of the section you want to be in. F: Premiere, E: Economique");
					
					if(!originPort.isEmpty()){
						criteria.set__transportationHubNameDeparture(originPort.toUpperCase());
						criteria.set_transportationHubNameArrival(destinationPort.toUpperCase());
					}
					if(!dateDepartStr.isEmpty()){
						String[] dateArray = dateDepartStr.split("/");
						Date dateDepart = new Date();
						dateDepart.setDate(Integer.parseInt(dateArray[0]));
						dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
						dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
						criteria.set_tripDepartureDate(dateDepart);
					}
					if(!sectionType.isEmpty()){
						criteria.set_sectionType(ComfortClassEnum.valueOf(sectionType.toUpperCase()));
					}
					
					String resultText = SystemeClient.getInstance().findTripInstance(criteria);
					updateOutput(resultText + "\n");
					
						
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
									update("Votre numero de confirmation est:"+confirmation+ "\n");
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
							//Reservation reservation = client.findReservation(reservationIdInt);
							TransportationManager tpt = TransportationManager.getInstance();
							TripInstance tripInstance = tpt.get_listTripGenerals().get(0).get_tripInstances().get(0);
							Reservation reservation = new Reservation();
							reservation.set_isActive(true);
							reservation.set_number(1050);
							reservation.set_client_(client);
							reservation.set_tripInstance(tripInstance);

							if (reservation != null){
								TripInstance tripInstanceReservation = reservation.get_tripInstance();
								JPanel panelReservation = new JPanel();
								panelReservation.setLayout(new GridLayout(8,2));
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
								panelReservation.add(new JLabel("Credit card expiration:"));
								panelReservation.add(creditCardExpiration);
//								panelReservation.add(new JLabel("Active:"));
//								panelReservation.add(new JLabel(Boolean.toString(reservation.is_isActive())));
								
								
								int resultPanelReservation = JOptionPane.showConfirmDialog(panel, panelReservation, 
							               "Pay reservation", JOptionPane.OK_CANCEL_OPTION);
							} else{
								updateOutput("Aucune reservation avec le id:" + reservationID.getText());
							}
						} 
						
					}
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
