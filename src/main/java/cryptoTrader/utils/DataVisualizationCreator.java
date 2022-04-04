package cryptoTrader.utils;

import cryptoTrader.gui.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cryptoTrader.gui.MainUI;

public class DataVisualizationCreator {
	
	// creates the charts to be displayed
	public void createCharts(ActionLog log) {
		createTableOutput(log);
		createBar(log);
	}


	
	// action log table
	private void createTableOutput(ActionLog log) {
		// TODO
		// this is where we call action log and plug it in how it is shown below
		// we can call the action log class to retrieve the logs and replace the dummy values below
		
		// Dummy dates for demo purposes. These should come from selection menu
		Object[] columnNames = {"Trader","Strategy","CryptoCoin","Action","Quantity","Price","Date"};
		
//		ActionLog log = new ActionLog();
		Object[][] data = log.retrieveDataLogs();
		System.out.println("doing table things");

		JTable table = new JTable(data, columnNames);
		//table.setPreferredSize(new Dimension(600, 300));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Trader Actions",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
	
		
		scrollPane.setPreferredSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);;
		
		MainUI.getInstance().updateStats(scrollPane);
	}
	
	// histogram
	private void createBar(ActionLog log) {
		// this is where we call action log and loop through its data and plug it in how it is shown below
		// populated with frequency/number of trades performed
		
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        Object[][] data = log.retrieveDataLogs();
	        String[][] inputVal = new String[data.length][];
	        String brokerName, stratName;
	        for (Object[] datum : data) {
	            if (datum[3] != "Fail" && datum[0] != null) {
	                brokerName = datum[0].toString();
	                stratName = datum[1].toString();
	                if (exists(dataset, brokerName, stratName)) {
	                    dataset.incrementValue(1, brokerName, stratName);
	                } else {
	                    dataset.setValue(1, brokerName, stratName);
	                }
	            }
	        }

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Strategy");
		plot.setDomainAxis(domainAxis);
		LogAxis rangeAxis = new LogAxis("Actions(Buys or Sells)");
		rangeAxis.setRange(new Range(0.1, 20.0));
		plot.setRangeAxis(rangeAxis);

		//plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart barChart = new JFreeChart("Actions Performed By Traders So Far", new Font("Serif", java.awt.Font.BOLD, 18), plot,
				true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(600, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		chartPanel.setBackground(Color.white);
		MainUI.getInstance().updateStats(chartPanel);
	}
	
	private boolean exists(DefaultCategoryDataset dataset, String brokerName, String stratName) {
        try {
            dataset.getValue(brokerName, stratName);
        } catch (Exception e) {
            System.out.println("I don't exist lmao");
            return false;
        }
        return true;
    }

} // end of file