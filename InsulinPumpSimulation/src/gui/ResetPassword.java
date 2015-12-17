package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ResetPassword {

	protected Shell shlResetPassword;
	private Text textPID;
	private Text textPWD;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ResetPassword window = new ResetPassword();
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
		shlResetPassword.open();
		shlResetPassword.layout();
		while (!shlResetPassword.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlResetPassword = new Shell(Display.getDefault(), SWT.TITLE|SWT.CLOSE|SWT.BORDER);
		shlResetPassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlResetPassword.setSize(297, 209);
		shlResetPassword.setText("Reset Password");
		
		Group groupResetPassword = new Group(shlResetPassword, SWT.NONE);
		groupResetPassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		groupResetPassword.setBounds(10, 10, 261, 150);
		
		Label lblNewLabel = new Label(groupResetPassword, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(10, 22, 129, 21);
		lblNewLabel.setText("Enter Your Patient I'd");
		
		textPID = new Text(groupResetPassword, SWT.BORDER);
		textPID.setBounds(141, 19, 110, 21);
		
		Label lblEnterYourDob = new Label(groupResetPassword, SWT.NONE);
		lblEnterYourDob.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEnterYourDob.setBounds(10, 49, 110, 21);
		lblEnterYourDob.setText("Enter Your DOB");
		
		Label lblEnterNewPassword = new Label(groupResetPassword, SWT.NONE);
		lblEnterNewPassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEnterNewPassword.setBounds(10, 75, 129, 21);
		lblEnterNewPassword.setText("Enter New Password");
		
		textPWD = new Text(groupResetPassword, SWT.BORDER|SWT.PASSWORD);
		textPWD.setBounds(141, 75, 110, 21);
		
		Button btnSave = new Button(groupResetPassword, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlResetPassword.close();
			}
		});
		btnSave.setBounds(176, 115, 75, 25);
		btnSave.setText("Submit");
		
		DateTime dateTime = new DateTime(groupResetPassword, SWT.BORDER);
		dateTime.setBounds(141, 46, 110, 24);

	}
}
