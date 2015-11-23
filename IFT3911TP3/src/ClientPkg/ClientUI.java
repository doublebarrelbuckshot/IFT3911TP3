package ClientPkg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import TransportationPkg.TripInstance;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.InstanceSeat;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationCompany;
import AdminPkg.RenameTransportationCompany;
import AdminPkg.SimulationData;
import AdminPkg.Subject;
import AdminPkg.UIAdmin;
import ReservationPkg.Company;
import ReservationPkg.IClientUI;
import AdminPkg.Observer;
import AdminPkg.Searcher;

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

	public void update(String message) {
		updateOutput(message);
	}
}