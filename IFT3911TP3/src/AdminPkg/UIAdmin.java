package AdminPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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







import AdminPkg.Administrator;
import AdminPkg.AirAdminPkg.AirFactory;
import TransportationPkg.TripGeneral;
import ClientPkg.ClientUI;
import CommonComponentsPkg.ComfortClassEnum;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.ComfortClass;
import TransportationPkg.GenericSeat;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;

public class UIAdmin extends JFrame implements Observer {
	public Vector<Administrator> _systemeAdmin = new Vector<Administrator>();
	public AdminManagement _interacts;

	private static UIAdmin instance;
	public static JTextArea  taOutput;
	public static JTextArea taInput;

	private UIAdmin()
	{
		super("AdminUI");
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
		GridLayout buttonsGridLayout = new GridLayout(10,0);
		jpButtons.setLayout(buttonsGridLayout);

		taOutput = new JTextArea ("");
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


		JButton btnRenameAirport = new JButton("Rename Air Company");
		JButton btnPrintAllTripGeneral = new JButton("Print all Trip Instances");
		JButton btnUndo = new JButton("Undo");
		JButton btnAddAirport = new JButton("AddAirport");
		JButton btnAddGeneralFlight = new JButton("Add General Flight");
		JButton btnAddInstanceFlight = new JButton("Add Instance Flight");

		btnAddInstanceFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					JPanel panel = new JPanel();
					JTextField taFlightGeneralID = new JTextField();
					JTextField taFullPrice = new JTextField();
					JTextField taDateDepart = new JTextField();
					JTextField taDateArrive = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

					panel.add(new JLabel("Enter Flight General ID related to this Flight Instance"));
					panel.add(taFlightGeneralID);
					panel.add(new JLabel("Enter dd:mm:yyyy for departure"));
					panel.add(taDateDepart);
					panel.add(new JLabel("Enter dd:mm:yyyy for arrival"));
					panel.add(taDateArrive);
					panel.add(new JLabel("Enter full price"));
					panel.add(taFullPrice);

					int result = JOptionPane.showConfirmDialog(null, panel, 
							"Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);

					if (result == JOptionPane.OK_OPTION) {	

						AdminManagement am = AdminManagement.getInstance();

						SearchCriteria criteria = new SearchCriteria();
						criteria.set_tripIDNumber(taFlightGeneralID.getText());
						Searcher searcher = Searcher.getInstance();
						TripGeneral tripGeneral = searcher.findOneTripGeneral(criteria);

						String[] hhmmArray = taDateDepart.getText().split(":");
						Date departhhmm  = new Date();
						departhhmm.setDate(Integer.parseInt(hhmmArray[0]));
						departhhmm.setMonth(Integer.parseInt(hhmmArray[1])-1);
						departhhmm.setYear(Integer.parseInt(hhmmArray[2]) - 1900);

						String[] hhmmArrayArrive = taDateArrive.getText().split(":");
						Date arrivehhmm  = new Date();
						arrivehhmm.setDate(Integer.parseInt(hhmmArrayArrive[0]));
						arrivehhmm.setMonth(Integer.parseInt(hhmmArrayArrive[1])-1);
						arrivehhmm.setYear(Integer.parseInt(hhmmArrayArrive[2])-1900);

						String fullPrice = taFullPrice.getText();

						double dFullPrice = Double.parseDouble(fullPrice);

						TripInstance ti = AirFactory.getInstance().createTripInstance(departhhmm, arrivehhmm,dFullPrice);
						ti.set_tripDescription(tripGeneral);


						//Add plane (first plane in companys fleet) and comfort classes and layout
						if (!tripGeneral.getTptCompany()._tptVehicles.isEmpty())
						{

							TransportationVehicle tv = tripGeneral.getTptCompany()._tptVehicles.firstElement();
							for(int i=0; i<tv._layoutSections.size(); i++)
							{
								VehicleLayout vl = tv._layoutSections.get(i);
								ti.assignLayoutToClass(vl); 
							}
							//assign to all comfortclass the tripinstance
							for(ComfortClass section : ti.get_comfortClasses()){
								section.set_tripInstace(ti);
							}
							ti._tptVehicle = tv;
						}
						AddTripInstance ati = new AddTripInstance(ti);

						am.addICommand(ati);

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
					JPanel panel = new JPanel();
					JTextField taCompanyID = new JTextField();
					JTextField taArrive = new JTextField();
					JTextField taDeparture = new JTextField();
					JTextField taDateDepart = new JTextField();
					JTextField taDateArrive = new JTextField();
					panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

					panel.add(new JLabel("Company ID that will service flight:"));
					panel.add(taCompanyID);
					panel.add(new JLabel("Enter AirportID for the departure:"));
					panel.add(taDeparture);
					panel.add(new JLabel("Enter AirportID for the arrival"));
					panel.add(taArrive);
					panel.add(new JLabel("Enter hh:mm for departure"));
					panel.add(taDateDepart);
					panel.add(new JLabel("Enter hh:mm for arrival"));
					panel.add(taDateArrive);

					int result = JOptionPane.showConfirmDialog(null, panel, 
							"Please Enter All Fields", JOptionPane.OK_CANCEL_OPTION);

					if (result == JOptionPane.OK_OPTION) {	
						AdminManagement am = AdminManagement.getInstance();

						SearchCriteria criteria = new SearchCriteria();
						criteria.set_transportationCompanyName(taCompanyID.getText());
						Searcher searcher = Searcher.getInstance();
						TransportationCompany company = searcher.findTransportationCompany(criteria);

						criteria = new SearchCriteria();
						criteria.set_transportationHubName(taDeparture.getText());
						searcher = Searcher.getInstance();
						TransportationHub departAirport = searcher.findOneTransportationHub(criteria);


						criteria = new SearchCriteria();
						criteria.set_transportationHubName(taArrive.getText());
						searcher = Searcher.getInstance();
						TransportationHub arriveAirport = searcher.findOneTransportationHub(criteria);

						String[] hhmmArray = taDateDepart.getText().split(":");
						Date departhhmm  = new Date();
						departhhmm.setHours(Integer.parseInt(hhmmArray[0]));
						departhhmm.setMinutes(Integer.parseInt(hhmmArray[1]));

						System.out.println("COMPANY: " + company.get_name());
						String[] hhmmArrayArrive = taDateArrive.getText().split(":");
						Date arrivehhmm  = new Date();
						arrivehhmm.setHours(Integer.parseInt(hhmmArrayArrive[0]));
						arrivehhmm.setMinutes(Integer.parseInt(hhmmArrayArrive[1]));


						TripGeneral tg = AirFactory.getInstance().createTripGeneral(departhhmm, arrivehhmm, company, departAirport, arriveAirport);
						AddTripGeneral atg = new AddTripGeneral(tg);
						am.addICommand(atg);




					}

				}

				catch (Exception e) {
					updateOutput("**** ERROR WITH AN INPUT FIELD, PLEASE MAKE SURE ALL INPUT DATA IS VALID AND PROPERLY FORMATTED ****");
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

	@Override
	public void update(String message) {
		updateOutput(message);
		
	}
}