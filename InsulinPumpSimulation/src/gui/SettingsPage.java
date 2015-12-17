package gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


public class SettingsPage {

	protected Shell shlSettings;
	private Text textUsrWeight;
	private Text textTDD;
	private Text text_2;
	private Text textICR;
	private Text textPWD;
	private Text txtGetconfirmationFromPatient;

	/**
	 * Launch the application.
	 * @param args
	 */ 
	public static void main(String[] args) {
		try {
			SettingsPage window = new SettingsPage();
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
		createContents();
		shlSettings.open();
		shlSettings.layout();
		while (!shlSettings.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSettings = new Shell(Display.getDefault(), SWT.TITLE|SWT.CLOSE|SWT.BORDER);
		shlSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlSettings.setSize(545, 506);
		shlSettings.setText("Settings");
		shlSettings.setLayout(null);
		
		Group grpCARBSettings = new Group(shlSettings, SWT.SHADOW_OUT);
		grpCARBSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpCARBSettings.setText("Default CARB Settings");
		grpCARBSettings.setBounds(10, 207, 509, 129);
		
		Label lblBrkfastCal = new Label(grpCARBSettings, SWT.NONE);
		lblBrkfastCal.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBrkfastCal.setBounds(10, 30, 106, 21);
		lblBrkfastCal.setText("Breakfast Calories");
		
		Label lblLunchCal = new Label(grpCARBSettings, SWT.NONE);
		lblLunchCal.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLunchCal.setText("Lunch Calories");
		lblLunchCal.setBounds(10, 67, 106, 15);
		
		Label lblDinnerCal = new Label(grpCARBSettings, SWT.NONE);
		lblDinnerCal.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDinnerCal.setBounds(10, 102, 106, 15);
		lblDinnerCal.setText("Dinner Calories");
		
		Label lblBreakfastTime = new Label(grpCARBSettings, SWT.NONE);
		lblBreakfastTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBreakfastTime.setText("Breakfast Time");
		lblBreakfastTime.setBounds(277, 30, 83, 21);
		
		Label lblLunchTime = new Label(grpCARBSettings, SWT.NONE);
		lblLunchTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLunchTime.setText("Lunch Time");
		lblLunchTime.setBounds(277, 67, 83, 15);
		
		Label lblDinnerTime = new Label(grpCARBSettings, SWT.NONE);
		lblDinnerTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDinnerTime.setText("Dinner Time");
		lblDinnerTime.setBounds(277, 102, 83, 15);
		
		Spinner spinnerBrkfstCal = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerBrkfstCal.setBounds(118, 30, 47, 22);
		
		Spinner spinnerLunchCal = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerLunchCal.setBounds(118, 60, 47, 22);
		
		Spinner spinnerDinnerCal = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerDinnerCal.setBounds(118, 95, 47, 22);
		
		Label lblHours = new Label(grpCARBSettings, SWT.NONE);
		lblHours.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHours.setBounds(363, 10, 55, 15);
		lblHours.setText("   Hours");
		
		Label lblMinutes = new Label(grpCARBSettings, SWT.NONE);
		lblMinutes.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMinutes.setBounds(424, 10, 55, 15);
		lblMinutes.setText(" Minutes");
		
		Spinner spinnerBFH = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerBFH.setMaximum(23);
		spinnerBFH.setBounds(366, 30, 47, 22);
		
		Spinner spinnerBFM = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerBFM.setMaximum(59);
		spinnerBFM.setBounds(425, 30, 47, 22);
		
		Spinner spinnerLNH = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerLNH.setMaximum(23);
		spinnerLNH.setBounds(366, 60, 47, 22);
		
		Spinner spinnerLNM = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerLNM.setMaximum(59);
		spinnerLNM.setBounds(425, 60, 47, 22);
		
		Spinner spinnerDNH = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerDNH.setMaximum(23);
		spinnerDNH.setBounds(366, 95, 47, 22);
		
		Spinner spinnerDNM = new Spinner(grpCARBSettings, SWT.BORDER);
		spinnerDNM.setMaximum(59);
		spinnerDNM.setBounds(425, 95, 47, 22);
		
		Group groupPWD = new Group(shlSettings, SWT.NONE);
		groupPWD.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		groupPWD.setBounds(10, 342, 509, 84);
		
		textPWD = new Text(groupPWD, SWT.BORDER|SWT.PASSWORD);
		textPWD.setBounds(109, 30, 171, 23);
		
		
		Label lblEnterPWD = new Label(groupPWD, SWT.NONE);
		lblEnterPWD.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEnterPWD.setBounds(10, 33, 93, 23);
		lblEnterPWD.setText("Enter Password");
		
		Button btnResetPassword = new Button(groupPWD, SWT.NONE);
		btnResetPassword.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display display = Display.getDefault();
				createContents();
				ResetPassword rp = new ResetPassword();
				rp.open();
				while (null != rp.shlResetPassword && !rp.shlResetPassword.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
		btnResetPassword.setBounds(328, 28, 155, 25);
		btnResetPassword.setGrayed(true);
		btnResetPassword.setSelection(true);
		btnResetPassword.setText("Reset Password");
		
		Group groupSettings = new Group(shlSettings, SWT.NONE);
		groupSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		groupSettings.setBounds(10, 0, 509, 201);
		
		Label lblUsrWeight = new Label(groupSettings, SWT.NONE);
		lblUsrWeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblUsrWeight.setLocation(10, 12);
		lblUsrWeight.setSize(179, 23);
		lblUsrWeight.setText("Enter User Weight");
		
		Label lblBolusInsulin = new Label(groupSettings, SWT.NONE);
		lblBolusInsulin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBolusInsulin.setBounds(10, 168, 179, 23);
		lblBolusInsulin.setText("Bolus Insulin Dose (mg/dl)");
		
		Label lblBOL = new Label(groupSettings, SWT.NONE);
		lblBOL.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBOL.setBounds(358, 168, 126, 21);
		lblBOL.setText("Usually 40% of TDD");
		
		Label lblBasalInsulin = new Label(groupSettings, SWT.NONE);
		lblBasalInsulin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBasalInsulin.setBounds(10, 135, 179, 23);
		lblBasalInsulin.setText("Basal Insulin Dose (mg/dl)");
		
		Label lblBSL = new Label(groupSettings, SWT.NONE);
		lblBSL.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBSL.setBounds(358, 135, 126, 21);
		lblBSL.setText("Usually 60% of TDD");
		
		Label lblICR = new Label(groupSettings, SWT.NONE);
		lblICR.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblICR.setBounds(10, 101, 179, 23);
		lblICR.setText("Insulin CARB Ratio (ICR)");
		
		textICR = new Text(groupSettings, SWT.BORDER);
		textICR.setBounds(261, 98, 76, 21);
		
		Label lblISF = new Label(groupSettings, SWT.NONE);
		lblISF.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblISF.setBounds(10, 70, 180, 23);
		lblISF.setText("Insulin Sensitivity Factor (ISF)");
		
		text_2 = new Text(groupSettings, SWT.BORDER);
		text_2.setBounds(261, 67, 76, 21);
		
		Label lblTDD = new Label(groupSettings, SWT.NONE);
		lblTDD.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTDD.setBounds(10, 41, 179, 23);
		lblTDD.setText("Total Daily Dosage (TDD)");
		
		textTDD = new Text(groupSettings, SWT.BORDER);
		textTDD.setBounds(261, 38, 76, 21);
		
		textUsrWeight = new Text(groupSettings, SWT.BORDER);
		textUsrWeight.setBounds(261, 11, 76, 21);
		
		Label lblKilograms = new Label(groupSettings, SWT.NONE);
		lblKilograms.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKilograms.setBounds(352, 14, 55, 15);
		lblKilograms.setText("Kilograms");
		
		Label lblUnitsOfInsulin = new Label(groupSettings, SWT.NONE);
		lblUnitsOfInsulin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblUnitsOfInsulin.setBounds(353, 41, 115, 19);
		lblUnitsOfInsulin.setText("Units of Insulin");
		
		Spinner spinnerBasalaInsulin = new Spinner(groupSettings, SWT.BORDER);
		spinnerBasalaInsulin.setBounds(261, 136, 76, 22);
		
		Spinner spinnerBolusInsulin = new Spinner(groupSettings, SWT.BORDER);
		spinnerBolusInsulin.setBounds(261, 168, 76, 22);
		
		Button btnCancel = new Button(shlSettings, SWT.NONE);
		btnCancel.setBounds(339, 432, 75, 25);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlSettings.close();
			}
		});
		btnCancel.setTouchEnabled(true);
		btnCancel.setGrayed(true);
		btnCancel.setSelection(true);
		btnCancel.setText("Cancel");
		
		Button btnSubmit = new Button(shlSettings, SWT.NONE);
		btnSubmit.setBounds(420, 432, 75, 25);
		btnSubmit.setTouchEnabled(true);
		btnSubmit.setSelection(true);
		btnSubmit.setGrayed(true);
		btnSubmit.setText("Submit");
		
		Button btnCheckButton = new Button(shlSettings, SWT.CHECK);
		btnCheckButton.setBounds(10, 436, 13, 16);
		
		txtGetconfirmationFromPatient = new Text(shlSettings, SWT.NONE);
		txtGetconfirmationFromPatient.setText("Get confirmation from patient for Bolus Injection");
		txtGetconfirmationFromPatient.setBounds(29, 437, 280, 21);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

	}
}
