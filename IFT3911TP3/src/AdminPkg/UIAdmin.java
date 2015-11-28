package AdminPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;




import AdminPkg.Administrator;
import AdminPkg.AirAdminPkg.AirFactory;
import TransportationPkg.TripGeneral;
import ClientPkg.ClientUI;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TripInstance;

public class UIAdmin extends JFrame {
	public Vector<Administrator> _systemeAdmin = new Vector<Administrator>();
	public AdminManagement _interacts;

	private static UIAdmin instance;
	public static JTextArea  taOutput;
	public static JTextArea taInput;

	private UIAdmin()
	{
		super("AdminUI");
		//this.setSize(700,600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setLocation(500,0);

		initWindow();
		this.pack();
	}

	private void initWindow() {

		/*
		 * Init output JLabel
		 */
		JPanel jpButtons = new JPanel();
		jpButtons.setBorder(new TitledBorder("Commands"));
		//taInput.setPreferredSize(new Dimension(540,100));
		GridLayout buttonsGridLayout = new GridLayout(10,0);
		jpButtons.setLayout(buttonsGridLayout);

		taOutput = new JTextArea (showMenu());
		taOutput.setEditable(false);
		taOutput.setBorder(new TitledBorder("Output"));
		//taOutput.setPreferredSize(new Dimension(540,450));
		taOutput.setBackground(Color.WHITE);
		taOutput.setOpaque(true);
		//taOutput.setLineWrap(true);
		JPanel jpCenter = new JPanel();
		JPanel jpOutput = new JPanel();
		JScrollPane sp = new JScrollPane(taOutput); 
		sp.setPreferredSize(new Dimension(500,450));
		sp.setBounds(23, 40, 394, 191);

		sp.setViewportView(taOutput);
		jpOutput.add(sp);
		//jpCenter.add(jpOutput);
		this.add(jpCenter);

		taInput = new JTextArea("");
		//taInput.setBorder(new TitledBorder("Input"));
		//taInput.setPreferredSize(new Dimension(410,100));
		//taInput.setBackground(Color.WHITE);
		//taInput.setOpaque(true);
		//JPanel jpInput = new JPanel();	
		//jpInput.add(taInput);

		JButton btnRenameAirport = new JButton("Rename Airport");
		JButton btnPrintAllTripGeneral = new JButton("Print all Trip Instances");
		JButton btnUndo = new JButton("Undo");
		JButton btnAddAirport = new JButton("AddAirport");
		JButton btnAddGeneralFlight = new JButton("Add General Flight");
		JButton btnAddInstanceFlight = new JButton("Add Instance Flight");

		btnAddInstanceFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					while(true){
						AdminManagement am = AdminManagement.getInstance();
						String tripGeneralID = JOptionPane.showInputDialog("Enter Flight General ID related to this Flight Instance");
						if(tripGeneralID == null)
							break;
						SearchCriteria criteria = new SearchCriteria();
						criteria.set_tripIDNumber(tripGeneralID);
						Searcher searcher = Searcher.getInstance();
						TripGeneral tripGeneral = searcher.findOneTripGeneral(criteria);
					
						String hhmmDepart = JOptionPane.showInputDialog("Enter dd:mm:yyyy for departure");
						if(hhmmDepart == null)
							break;
						String[] hhmmArray = hhmmDepart.split(":");
						Date departhhmm  = new Date();
						departhhmm.setDate(Integer.parseInt(hhmmArray[0]));
						departhhmm.setMonth(Integer.parseInt(hhmmArray[1]));
						departhhmm.setYear(Integer.parseInt(hhmmArray[2]));


						String hhmmArrive = JOptionPane.showInputDialog("Enter dd:mm:yyyy for arrival");
						if(hhmmArrive == null)
							break;
						String[] hhmmArrayArrive = hhmmDepart.split(":");
						Date arrivehhmm  = new Date();
						arrivehhmm.setDate(Integer.parseInt(hhmmArrayArrive[0]));
						arrivehhmm.setMonth(Integer.parseInt(hhmmArrayArrive[1]));
						arrivehhmm.setYear(Integer.parseInt(hhmmArrayArrive[2]));

						String fullPrice = JOptionPane.showInputDialog("Enter full price");
						if(hhmmArrive == null)
							break;
						double dFullPrice = Double.parseDouble(fullPrice);
						
						TripInstance ti = AirFactory.getInstance().createTripInstance(departhhmm, arrivehhmm, 9999,dFullPrice);
						ti.set_tripDescription(tripGeneral);
						AddTripInstance ati = new AddTripInstance(ti);
						am.addICommand(ati);
						break;

					}
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnAddGeneralFlight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					while(true){
						AdminManagement am = AdminManagement.getInstance();
						String sCompanyID = JOptionPane.showInputDialog("Enter Company ID that will service flight: ");
						if(sCompanyID == null)
							break;
						SearchCriteria criteria = new SearchCriteria();
						criteria.set_transportationCompanyName(sCompanyID);
						Searcher searcher = Searcher.getInstance();
						TransportationCompany company = searcher.findTransportationCompany(criteria);
						
						String sDepartAirport = JOptionPane.showInputDialog("Enter AirportID for the departure");
						if(sCompanyID == null)
							break;
						criteria = new SearchCriteria();
						criteria.set_transportationHubName(sDepartAirport);
						searcher = Searcher.getInstance();
						TransportationHub departAirport = searcher.findOneTransportationHub(criteria);
						if(departAirport == null)
							break;
						
						
						String sArriveAirport = JOptionPane.showInputDialog("Enter AirportID for the arrival");
						if(sCompanyID == null)
							break;
						criteria = new SearchCriteria();
						criteria.set_transportationHubName(sArriveAirport);
						searcher = Searcher.getInstance();
						TransportationHub arriveAirport = searcher.findOneTransportationHub(criteria);
						if(arriveAirport == null)
							break;

						String hhmmDepart = JOptionPane.showInputDialog("Enter hh:mm for departure");
						if(hhmmDepart == null)
							break;
						String[] hhmmArray = hhmmDepart.split(":");
						Date departhhmm  = new Date();
						departhhmm.setHours(Integer.parseInt(hhmmArray[0]));
						departhhmm.setMinutes(Integer.parseInt(hhmmArray[1]));


						String hhmmArrive = JOptionPane.showInputDialog("Enter hh:mm for departure");
						if(hhmmArrive == null)
							break;
						String[] hhmmArrayArrive = hhmmDepart.split(":");
						Date arrivehhmm  = new Date();
						arrivehhmm.setHours(Integer.parseInt(hhmmArrayArrive[0]));
						arrivehhmm.setMinutes(Integer.parseInt(hhmmArrayArrive[1]));
						
						
						TripGeneral tg = AirFactory.getInstance().createTripGeneral(departhhmm, arrivehhmm, "TEST", departAirport, arriveAirport);
						AddTripGeneral atg = new AddTripGeneral(tg);
						am.addICommand(atg);
						break;

					}
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnAddAirport.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AdminManagement am = AdminManagement.getInstance();

				String airportName = JOptionPane.showInputDialog("Enter AirportName: ");
				String airportID = JOptionPane.showInputDialog("Enter AirportID: ");
				TransportationHub airport = AirFactory.getInstance().createTransportationHub(airportName, airportID);
				ICommand addTransportationCommand = new AddTransportationHub(airport);
				am.addICommand(addTransportationCommand);

			}

		});
		btnUndo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdminManagement am = AdminManagement.getInstance();
				am.undo();
			}

		});

		btnPrintAllTripGeneral.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdminManagement am = AdminManagement.getInstance();


				boolean companyFound = false;
				try{

					updateOutput("All Trip General's in System:");
					String toPrint = am.findTripGeneral(new SearchCriteria());
					updateOutput(toPrint + "\n");
				}

				catch(Exception e)
				{
					System.out.println(e);
					updateOutput("NONE FOUND");
				}
			}

		});

		btnRenameAirport.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AdminManagement am = AdminManagement.getInstance();
				boolean companyFound = false;
				try{
					while(!companyFound)
					{
						String sCompanyName = JOptionPane.showInputDialog("Enter ID of company that you wish to rename.");
						if(sCompanyName == null)
							break;
						SearchCriteria criteria = new SearchCriteria();
						criteria.set_transportationCompanyName(sCompanyName);
						Searcher searcher = Searcher.getInstance();
						TransportationCompany company = searcher.findTransportationCompany(criteria);
						if(company != null)
						{
							companyFound = true;
							String newCompanyName = JOptionPane.showInputDialog("Enter new company Name");
							if(newCompanyName == null)
								break;
							updateOutput("Found: "+ company.get_name());
							updateOutput("Renaming to: " + newCompanyName);
							ICommand renameCoyCommand = renameTptCompany(company, newCompanyName);
							am.addICommand(renameCoyCommand);
						}
					}
				}
				catch(Exception e)
				{
					//System.out.println(e);
					updateOutput("NO COMPANY FOUND");
				}

			}

		});

		jpButtons.add(btnAddInstanceFlight);
		jpButtons.add(btnAddGeneralFlight);
		jpButtons.add(btnRenameAirport);
		jpButtons.add(btnPrintAllTripGeneral);
		jpButtons.add(btnUndo);
		jpButtons.add(btnAddAirport);
		jpCenter.add(jpOutput, BorderLayout.CENTER);
		jpCenter.add(jpButtons, BorderLayout.EAST);
		this.add(jpCenter);

	}
	public void updateOutput(String text) {
		taOutput.setText(taOutput.getText() + "\n" + text);	
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
		sb.append("2: Print all TripGeneral\n");
		sb.append("3: Undo Last\n");
		sb.append("4. Add Airport");

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