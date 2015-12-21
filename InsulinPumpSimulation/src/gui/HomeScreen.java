package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

import org.eclipse.swt.browser.Browser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;

/**
 * Newly Imported from google.
 */

public class HomeScreen{

	/** Timer to refresh graph after every 1/4th of a second */
	//private Time timer = new Timer(1000, this);

	protected Shell shlHomeScreen;
	protected Label lblClock;
	final JFreeChart chart;
	
	private TimeSeries series;

    /** The most recent value added. */
    private double lastValue = 100.0;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public HomeScreen() {
        this.series = new TimeSeries("Random Data", Millisecond.class);

        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        chart = createChart(dataset);

        //Sets background color of chart
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
	}

	public static void main(String[] args) {

		try {
			HomeScreen window = new HomeScreen();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		//timer.setInitialDelay(1000);
		Display display = Display.getDefault();
		createContents();
		shlHomeScreen.open();
		shlHomeScreen.layout();
		//timer.start();
		while (!shlHomeScreen.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHomeScreen = new Shell(Display.getDefault(), SWT.TITLE | SWT.CLOSE
				| SWT.BORDER);
		shlHomeScreen.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		shlHomeScreen.setSize(748, 520);
		shlHomeScreen.setText("TWO HARMONE SIMULATOR PUMP : GROUP D");

		Group group = new Group(shlHomeScreen, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(10, 67, 441, 61);

		Label lblLatestSugarLevels = new Label(group, SWT.NONE);
		lblLatestSugarLevels.setBounds(10, 23, 151, 23);
		lblLatestSugarLevels.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblLatestSugarLevels.setFont(SWTResourceManager.getFont("Calibri", 14,
				SWT.BOLD));
		lblLatestSugarLevels.setText("Latest Sugar Levels");

		Label lblMgdl = new Label(group, SWT.NONE);
		lblMgdl.setBounds(176, 29, 51, 15);
		lblMgdl.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMgdl.setText("??? mg/dl");

		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(267, 29, 159, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("Expected Value 70 - 120 mg/dl");

		Group grpCriticalIndicators = new Group(shlHomeScreen, SWT.NONE);
		grpCriticalIndicators.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		grpCriticalIndicators.setFont(SWTResourceManager.getFont("Calibri", 12,
				SWT.BOLD));
		grpCriticalIndicators.setText("Critical Indicators");
		grpCriticalIndicators.setBounds(457, 50, 265, 381);

		ProgressBar progressBarBattery = new ProgressBar(grpCriticalIndicators,
				SWT.NONE);
		progressBarBattery.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		progressBarBattery.setBounds(132, 32, 123, 25);

		Label lblBattery = new Label(grpCriticalIndicators, SWT.NONE);
		lblBattery.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBattery.setBounds(10, 42, 55, 15);
		lblBattery.setText("Battery");

		ProgressBar progressBarInsulin = new ProgressBar(grpCriticalIndicators,
				SWT.NONE);
		progressBarInsulin.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		progressBarInsulin.setBounds(132, 79, 123, 25);

		ProgressBar progressBarGlucagon = new ProgressBar(
				grpCriticalIndicators, SWT.NONE);
		progressBarGlucagon.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		progressBarGlucagon.setBounds(132, 131, 123, 25);

		Label lblInsulinReservoir = new Label(grpCriticalIndicators, SWT.NONE);
		lblInsulinReservoir.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblInsulinReservoir.setBounds(10, 89, 102, 15);
		lblInsulinReservoir.setText("Insulin Reservoir");

		Label lblGlucagonReservoir = new Label(grpCriticalIndicators, SWT.NONE);
		lblGlucagonReservoir.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblGlucagonReservoir.setBounds(10, 141, 116, 15);
		lblGlucagonReservoir.setText("Glucagon Reservoir");

		Label lblNewLabel_1 = new Label(grpCriticalIndicators, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(10, 207, 116, 15);
		lblNewLabel_1.setText("Pump");

		Label lblNewLabel_2 = new Label(grpCriticalIndicators, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setBounds(10, 251, 129, 15);
		lblNewLabel_2.setText("Blood Glucose Sensor");

		Label lblNewLabel_3 = new Label(grpCriticalIndicators, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBounds(10, 294, 116, 15);
		lblNewLabel_3.setText("Needle Assembly");

		Label lblNewLabel_4 = new Label(grpCriticalIndicators, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setBounds(10, 342, 116, 15);
		lblNewLabel_4.setText("Alarm");

		Label label = new Label(grpCriticalIndicators, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(171, 207, 55, 25);
		label.setText("New Label");

		Label label_1 = new Label(grpCriticalIndicators, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setText("New Label");
		label_1.setBounds(171, 251, 55, 25);

		Label label_2 = new Label(grpCriticalIndicators, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setText("New Label");
		label_2.setBounds(171, 294, 55, 25);

		Label label_3 = new Label(grpCriticalIndicators, SWT.NONE);
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setText("New Label");
		label_3.setBounds(171, 342, 55, 25);

		Group grpNextBolusDosage = new Group(shlHomeScreen, SWT.NONE);
		grpNextBolusDosage.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		grpNextBolusDosage.setFont(SWTResourceManager.getFont("Calibri", 12,
				SWT.BOLD));
		grpNextBolusDosage.setText("Next Bolus Dosage");
		grpNextBolusDosage.setBounds(10, 133, 441, 61);

		Label lblDinner = new Label(grpNextBolusDosage, SWT.NONE);
		lblDinner.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDinner.setBounds(10, 25, 140, 20);
		lblDinner.setText("Dinner ???");

		Button btnAdjustCarb = new Button(grpNextBolusDosage, SWT.NONE);
		btnAdjustCarb.addSelectionListener(new SelectionAdapter() {
			// .setVisible(true)@Override
			
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				CARBRemainderPage crp = new CARBRemainderPage();
				crp.open(false);
				while (null != crp.shlCarbAndRemainder
						&& !crp.shlCarbAndRemainder.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
		btnAdjustCarb.setBounds(348, 20, 75, 25);
		btnAdjustCarb.setText("Adjust CARB");

		Label lblTimeLeftFor = new Label(grpNextBolusDosage, SWT.NONE);
		lblTimeLeftFor.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		lblTimeLeftFor.setBounds(171, 25, 171, 20);
		lblTimeLeftFor.setText("Next Dinner Time");

		Group graphDynamic = new Group(shlHomeScreen, SWT.NONE);
		graphDynamic
				.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		graphDynamic.setBounds(10, 200, 441, 191);
		
		graphDynamic.addListener(SWT.Activate, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				final double factor = 0.9 + 0.2 * Math.random();
				lastValue = lastValue * factor;

				final Millisecond now = new Millisecond();
				series.add(new Millisecond(), lastValue);
 
				System.out.println("Current Time in Milliseconds = " + now.toString()
						+ ", Current Value : " + lastValue);
				
			}
		});

		// Dynamic Chart
		ChartComposite frame = new ChartComposite(graphDynamic, SWT.NONE,
				chart, true);
		frame.setDisplayToolTips(true);
		frame.setHorizontalAxisTrace(false);
		frame.setVerticalAxisTrace(false);

		Group grpActivityLog = new Group(shlHomeScreen, SWT.NONE);
		grpActivityLog.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WHITE));
		grpActivityLog.setFont(SWTResourceManager.getFont("Calibri", 12,
				SWT.BOLD));
		grpActivityLog.setText("Activity Log");
		grpActivityLog.setBounds(10, 389, 441, 82);

		StyledText TxtActivityLog = new StyledText(grpActivityLog, SWT.MULTI
				| SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		TxtActivityLog.setBounds(0, 21, 441, 61);
		TxtActivityLog.setText("Hello \nHi");
		TxtActivityLog.setText("Hello World!\n" + TxtActivityLog.getText());
		Button btnHelp = new Button(shlHomeScreen, SWT.NONE);
		btnHelp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnHelp.setBounds(467, 446, 81, 25);
		btnHelp.setText("Help");

		Button btnGraphView = new Button(shlHomeScreen, SWT.NONE);
		btnGraphView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				GraphView gp = new GraphView();
				gp.open();
				while (null != gp.shlGraphView && !gp.shlGraphView.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
		btnGraphView.setBounds(554, 446, 81, 25);
		btnGraphView.setText("Graph View");

		Button btnSettings = new Button(shlHomeScreen, SWT.NONE);
		btnSettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				SettingsPage sp = new SettingsPage();
				sp.open();
				while (null != sp.shlSettings && !sp.shlSettings.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}

		});
		btnSettings.setBounds(641, 446, 81, 25);
		btnSettings.setText("Settings");

		lblClock = new Label(shlHomeScreen, SWT.NONE);
		lblClock.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblClock.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblClock.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblClock.setBounds(456, 19, 152, 25);
		lblClock.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		new Thread() {
			public void run() {
				while (true) {
					try {
						Display display = Display.getDefault();
						Thread.sleep(1000);
						display.asyncExec(new Runnable() {
							@Override
							public void run() {
								lblClock.setText(new SimpleDateFormat(
										"d MMM yyyy, HH:mm:ss ")
										.format(new Date()));
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		Label lblLogo = new Label(shlHomeScreen, SWT.NONE);
		lblLogo.setImage(SWTResourceManager.getImage(HomeScreen.class,
				"/resource/Uni_Logo.gif"));
		lblLogo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLogo.setBounds(614, 0, 112, 50);

		Group group_1 = new Group(shlHomeScreen, SWT.NONE);
		group_1.setLocation(10, 0);
		group_1.setSize(441, 61);
		group_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));

		Browser browser = new Browser(shlHomeScreen, SWT.NONE);
		browser.setBounds(467, 439, 64, 32);

	}

	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart result = ChartFactory.createTimeSeriesChart(
				"Dynamic Line And TimeSeries Chart", "Time", "sugar level",
				dataset, true, true, false);

		final XYPlot plot = result.getXYPlot();

		plot.setBackgroundPaint(new Color(0xffffe0));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.lightGray);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.lightGray);

		ValueAxis xaxis = plot.getDomainAxis();
		xaxis.setAutoRange(true);

		// Domain axis would show data of 60 seconds for a time
		xaxis.setFixedAutoRange((6000000.0) * 4.0); // 60 seconds
		xaxis.setVerticalTickLabels(true);

		ValueAxis yaxis = plot.getRangeAxis();
		yaxis.setRange(50.0, 440.0);

		return result;
	}

	/**
	 * Generates an random entry for a particular call made by time for every
	 * 1/4th of a second.
	 *
	 * @param e
	 *            the action event.
	 

	public void actionPerformed(final ActionEvent e) {

		final double factor = 0.9 + 0.2 * Math.random();
		this.lastValue = this.lastValue * factor;

		final Millisecond now = new Millisecond();
		this.series.add(new Millisecond(), this.lastValue);

		System.out.println("Current Time in Milliseconds = " + now.toString()
				+ ", Current Value : " + this.lastValue);
	}*/
}
