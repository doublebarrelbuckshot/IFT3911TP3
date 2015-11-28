package ClientPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
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
import AdminPkg.UIAdmin;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.Client;
import ReservationPkg.IClientUI;
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
					
					Vector<TripInstance> tripList = searcher.findTripInstances(criteria);
					for (TripInstance trip: tripList){
						TripGeneral descriptionCroisiere = trip.get_tripDescription();
						updateOutput("Voyage: "+ descriptionCroisiere.get_tripID() + " Date de depart: " + trip.get_dateDepartStr() 
						+ " Heure de depart: " + descriptionCroisiere.get_heureDepartStr() + " Heure d'arrivee: " + descriptionCroisiere.get_heureArriveStr());
					}
				}else if(iInput == 5){
					SearchCriteria sc = new SearchCriteria();
					
					JPanel panel = new JPanel();
					JTextField generalID = new JTextField();
					JTextField dateD = new JTextField();
					JTextField section = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
					
					panel.add(new JLabel("Enter the trip ID:"));
					panel.add(generalID);
					panel.add(new JLabel("Departure date with the format: dd/mm/yyyy"));
					panel.add(dateD);
					panel.add(new JLabel("LETTER of the section you want to be in. F: Premiere, A: Affaire, P: Economique premium, E: Economique:"));
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
							
							InstanceSeat seat = SystemeClient.getInstance().findSeat(sc);
							
							SystemeClient.getInstance().makeReservation(seat, client);
				    	  
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
		return sb.toString();

	}

	public static ClientUI getInstance()
	{
		if(instance == null)
			instance = new ClientUI();
		return instance;
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		
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

}