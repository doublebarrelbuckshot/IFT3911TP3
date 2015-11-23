package AdminPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import AdminPkg.Administrator;
import TransportationPkg.TripGeneral;
import ClientPkg.ClientUI;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;

public class UIAdmin extends JFrame {
	public Vector<Administrator> _systemeAdmin = new Vector<Administrator>();
	public AdminManagement _interacts;

	private static UIAdmin instance;
	public static JTextArea  taOutput;
	public static JTextArea taInput;
	public static JButton bInput;

	private UIAdmin()
	{
		super("AdminUI");
		this.setSize(600,650);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setLocation(600,0);
		initWindow();

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
		jpCenter.add(jpOutput);
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
				String[] cliCommand = input.split(" ");

				boolean validInput = false;
				int iInput = -1;
				try{
					iInput = Integer.parseInt(cliCommand[0]);
					validInput = true;
				}
				catch(Exception e)
				{
					updateOutput("***Invalid input, please try again***\n" + instance.showMenu());
					taInput.setText("");
				}

				if(validInput)
					processCommand(iInput, cliCommand);


			}
			private void processCommand(int iInput, String[] cliCommand) {
				updateOutput("User Entered " + iInput);
				if(iInput == 1)
				{
					boolean companyFound = false;
					try{
						while(!companyFound)
						{
							String sCompanyName = JOptionPane.showInputDialog("Enter ID of company that you wish to rename.");
							SearchCriteria criteria = new SearchCriteria();
							criteria.set_transportationCompanyName(sCompanyName);
							Searcher searcher = Searcher.getInstance();
							TransportationCompany company = searcher.findTransportationCompany(criteria);
							companyFound = true;
							String newCompanyName = JOptionPane.showInputDialog("Enter new company Name");
							updateOutput("Found: "+ company.get_name());
							updateOutput("Renaming to: " + newCompanyName);
							ICommand renameCoyCommand = renameTptCompany(company, newCompanyName);
							AdminManagement am = AdminManagement.getInstance();
							am.addICommand(renameCoyCommand);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
						updateOutput("NONE FOUND");
					}
				}	
				if(iInput == 2)
				{
					boolean companyFound = false;
					try{
						while(!companyFound)
						{
							String sHubID = JOptionPane.showInputDialog("Enter ID of TransportationHub that you wish to rename.");
							SearchCriteria criteria = new SearchCriteria();
							criteria.set_transportationHubName(sHubID);
							Searcher searcher = Searcher.getInstance();
							TransportationCompany company = searcher.findTransportationCompany(criteria);
							companyFound = true;
							String newCompanyName = JOptionPane.showInputDialog("Enter new company Name");
							updateOutput("Found: "+ company.get_name());
							updateOutput("Renaming to: " + newCompanyName);
							ICommand renameCoyCommand = renameTptCompany(company, newCompanyName);
							AdminManagement am = AdminManagement.getInstance();
							am.addICommand(renameCoyCommand);
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
						updateOutput("NONE FOUND");
					}
				}	
			}

			private void updateOutput(String text) {
				taOutput.setText(taOutput.getText() + "\n" + text);	
			} 
		} );
		jpInput.add(bInput);
		jpCenter.add(jpOutput);
		jpCenter.add(jpInput);
		this.add(jpCenter);

	}

	private final RenameTransportationCompany renameTptCompany(TransportationCompany tptCompany, String newName)
	{

		RenameTransportationCompany rtc = new RenameTransportationCompany(tptCompany, newName);
		return rtc;

	}

	public final String showMenu()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("*******MENU*******\n");
		sb.append("1: Rename Transportation Company \n");
		sb.append("2: Rename Transportation Hub \n");

		return sb.toString();

	}
	public static UIAdmin getInstance()
	{
		if(instance == null)
			instance = new UIAdmin();
		return instance;
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