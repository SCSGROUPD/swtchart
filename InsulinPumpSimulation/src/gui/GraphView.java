 package gui;

import java.awt.Color;
import java.text.SimpleDateFormat;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.experimental.chart.swt.demo.SWTBarChartDemo1;
import org.jfree.ui.RectangleInsets;

public class GraphView {

	protected Shell shlGraphView;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GraphView window = new GraphView();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();;
		shlGraphView.open();
		shlGraphView.pack();
		
		Label lblTo_1 = new Label(shlGraphView, SWT.NONE);
		lblTo_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTo_1.setBounds(224, 29, 26, 36);
		lblTo_1.setText("To");
		
		Button btnApply = new Button(shlGraphView, SWT.NONE);
		btnApply.setBounds(416, 29, 106, 36);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			shlGraphView.close();
			}
		});
		btnApply.setText("Apply");
		shlGraphView.layout();
		while (!shlGraphView.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
    private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "insulin sugar level graph",  // title
            "Date",             // x-axis label
            "sugar level",   // y-axis label
            dataset,            // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }
        
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return chart;

    }
    private static XYDataset createDataset() {

        TimeSeries s1 = new TimeSeries("insulin sugar level");
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);


        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
       
        
        return dataset;
    }

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlGraphView = new Shell(Display.getCurrent(), SWT.TITLE|SWT.CLOSE|SWT.BORDER);
		shlGraphView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlGraphView.setSize(1000, 517);
		shlGraphView.setText("Graph View");
		
		Group groupGraph = new Group(shlGraphView, SWT.NONE);
		
		groupGraph.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	       
		groupGraph.setBounds(10, 80, 674, 394);
		groupGraph.setLayout(new FillLayout());
		groupGraph.setText("Time series demo for jfreechart running with SWT");
		
		JFreeChart chart = createChart(createDataset());
		ChartComposite frame = new ChartComposite(groupGraph, SWT.NONE, chart, true);
		frame.setChart(chart);
		 frame.setDisplayToolTips(true);
	        frame.setHorizontalAxisTrace(true);
	        frame.setVerticalAxisTrace(true);
	    	
	        
		
		Label lblFrom = new Label(shlGraphView, SWT.NONE);
		lblFrom.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblFrom.setBounds(10, 29, 59, 36);
		lblFrom.setText("From");
		
		Label lblTo = new Label(shlGraphView, SWT.NONE);
		lblTo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTo.setBounds(138, 29, 14, 15);
		lblTo.setText("To");
		
		DateTime dateTimeFrom = new DateTime(shlGraphView, SWT.BORDER);
		dateTimeFrom.setBounds(62, 29, 134, 36);
		
		DateTime dateTimeTo = new DateTime(shlGraphView, SWT.BORDER);
		dateTimeTo.setBounds(256, 29, 134, 36);

	}
}
