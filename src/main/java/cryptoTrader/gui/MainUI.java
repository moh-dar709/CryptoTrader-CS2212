/**
 * Main UI class
 * This is where the Login UI and the main trading interface will be displayed
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */
package cryptoTrader.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cryptoTrader.utils.DataVisualizationCreator;


public class MainUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static MainUI instance;
	private JPanel stats, chartPanel, tablePanel;

	private DefaultTableModel dtm;
	private JTable table;

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	/**
	 * MainUI constructor
	 * This is where the trade interface buttons/dropdown menus are created
	 */
	private MainUI() {

		super("Crypto Trading Tool"); //set window title

		JPanel north = new JPanel();  //set top bar

		JButton trade = new JButton("Perform Trade");
		trade.setActionCommand("refresh");
		trade.addActionListener(this);

		JPanel south = new JPanel();

		south.add(trade);

		dtm = new DefaultTableModel(new Object[] { "Trading Client", "Coin List", "Strategy Name" }, 1);
		table = new JTable(dtm);
		// table.setPreferredSize(new Dimension(600, 300));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Trading Client Actions",
				TitledBorder.CENTER, TitledBorder.TOP));
		Vector<String> strategyNames = new Vector<String>();
		strategyNames.add("Strategy-A");
		strategyNames.add("Strategy-B");
		strategyNames.add("Strategy-C");
		strategyNames.add("Strategy-D");
		TableColumn strategyColumn = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox(strategyNames);
		strategyColumn.setCellEditor(new DefaultCellEditor(comboBox));
		JButton addRow = new JButton("Add Row");
		JButton remRow = new JButton("Remove Row");
		addRow.setActionCommand("addTableRow");
		addRow.addActionListener(this);
		remRow.setActionCommand("remTableRow");
		remRow.addActionListener(this);

		scrollPane.setPreferredSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);

		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(scrollPane);
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(addRow);
		buttons.add(remRow);
		east.add(buttons);

		//set charts region
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(1250, 650));
		stats = new JPanel();
		stats.setLayout(new GridLayout(2, 2));

		west.add(stats);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(west, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);
	}

	/**
	 * Updates status of UI
	 * @param component Takes in component
	 */
	public void updateStats(JComponent component) {
		stats.add(component);
		stats.revalidate();
	}

	/**
	 * Main class
	 * This is where the loginUI will be displayed
	 * @param args
	 */
	public static void main(String[] args) {
		boolean loginDispVar = true;

		//login UI
		LoginSystem login = new LoginSystem();
		login.setPreferredSize(new Dimension(450, 600));
		login.pack();
		login.setVisible(loginDispVar);
	}

	/**
	 * Action performed method
	 * @param e Takes in an actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("refresh".equals(command)) {

			List<String> traderList = new ArrayList<String>();
			List<String[]> coinList = new ArrayList<String[]>();
			List<String> stratList = new ArrayList<String>();

			for (int count = 0; count < dtm.getRowCount(); count++){

				Object traderObject = dtm.getValueAt(count, 0);  //creates trader object
				if (traderObject == null) {
					JOptionPane.showMessageDialog(this, "please fill in Trader name on line " + (count + 1) );
					return;
				}

				String traderName = traderObject.toString(); //assigns trader name

				Object coinObject = dtm.getValueAt(count, 1);  //creates coin object
				if (coinObject == null) {
					JOptionPane.showMessageDialog(this, "please fill in cryptocoin list on line " + (count + 1) );
					return;
				}

				String[] coinNames = coinObject.toString().split(",");  //assigns coin list to object

				Object strategyObject = dtm.getValueAt(count, 2); //creates strat object
				if (strategyObject == null) {
					JOptionPane.showMessageDialog(this, "please fill in strategy name on line " + (count + 1) );
					return;
				}

				String strategyName = strategyObject.toString(); //assigns strat name

				System.out.println(traderName + " " + Arrays.toString(coinNames) + " " + strategyName);  //import the input data to create brokers

				traderList.add(traderName);
				coinList.add(coinNames);
				stratList.add(strategyName);

			}

			stats.removeAll();  //clears user input

			PerformTrade tradeAction = new PerformTrade(traderList,coinList,stratList);  //call perform trade

			System.out.println("hehe trade performed"); //-------------------------------------------------

			ActionLog log = tradeAction.getDataToVisual();

			DataVisualizationCreator creator = new DataVisualizationCreator(); //displays charts
			creator.createCharts(log);

		} else if ("addTableRow".equals(command)) {
			dtm.addRow(new String[3]);
		} else if ("remTableRow".equals(command)) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1)
				dtm.removeRow(selectedRow);
		}
	}

} // end of file