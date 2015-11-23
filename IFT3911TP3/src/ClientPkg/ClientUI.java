package ClientPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import AdminPkg.Observer;
import AdminPkg.SimulationData;
import AdminPkg.Subject;
import AdminPkg.UIAdmin;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import ReservationPkg.IClientUI;
import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;

public class ClientUI extends JFrame implements IClientUI, Observer {



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
	public static JTextArea  taOutput;
	public static JTextArea taInput;
	public static JButton bInput;
	
	private ClientUI()
	{
		super("ClientUI");
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
				if(iInput == 2){
					SearchCriteria criteria = new SearchCriteria();
					String originAirport = JOptionPane.showInputDialog("Please input origin airport ID");
					criteria.set__transportationHubNameDeparture(originAirport);
					String destinationAirport = JOptionPane.showInputDialog("Please input destination airport ID");
					criteria.set_transportationHubNameArrival(destinationAirport);
					
					String dateDepartStr = JOptionPane.showInputDialog("Please enter departure date with the format: dd/mm/yyyy");
					String[] dateArray = dateDepartStr.split("/");
					Date dateDepart = new Date();
					dateDepart.setDate(Integer.parseInt(dateArray[0]));
					dateDepart.setMonth(Integer.parseInt(dateArray[1]) - 1);
					dateDepart.setYear(Integer.parseInt(dateArray[2]) - 1900);
					criteria.set_tripDepartureDate(dateDepart);
					String sectionType = JOptionPane.showInputDialog("Please enter the LETTER of the section you want to be in. F: Premiere, A: Affaire, P: Economique premium, E: Economique");
					criteria.set_sectionType(ComfortClassEnum.valueOf(sectionType));
					
					updateOutput(originAirport);
					updateOutput(destinationAirport);
					updateOutput(dateDepartStr);
					updateOutput(sectionType);
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
		return sb.toString();

	}

	public static ClientUI getInstance()
	{
		if(instance == null)
			instance = new ClientUI();
		return instance;
	}


	public SystemeClient _interacts;

	public TripInstance findTripInstance(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public InstanceSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public int getOrderChangeDeadline(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void showAlert(String aAlert) {
		throw new UnsupportedOperationException();
	}

	public void update(Subject aS) {
		//taOutput.setText("done");
	}
}