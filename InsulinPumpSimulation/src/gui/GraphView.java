 package gui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;

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
		createContents();
		shlGraphView.open();
		shlGraphView.layout();
		while (!shlGraphView.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGraphView = new Shell(Display.getDefault(), SWT.TITLE|SWT.CLOSE|SWT.BORDER);
		shlGraphView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlGraphView.setSize(590, 408);
		shlGraphView.setText("Graph View");
		
		Group groupGraph = new Group(shlGraphView, SWT.NONE);
		groupGraph.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		groupGraph.setBounds(10, 50, 554, 309);
		
		Label lblFrom = new Label(shlGraphView, SWT.NONE);
		lblFrom.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblFrom.setBounds(10, 29, 34, 15);
		lblFrom.setText("From");
		
		Label lblTo = new Label(shlGraphView, SWT.NONE);
		lblTo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTo.setBounds(138, 29, 14, 15);
		lblTo.setText("To");
		
		Button btnApply = new Button(shlGraphView, SWT.NONE);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			shlGraphView.close();
			}
		});
		btnApply.setBounds(263, 19, 75, 25);
		btnApply.setText("Apply");
		
		DateTime dateTimeFrom = new DateTime(shlGraphView, SWT.BORDER);
		dateTimeFrom.setBounds(50, 20, 80, 24);
		
		DateTime dateTimeTo = new DateTime(shlGraphView, SWT.BORDER);
		dateTimeTo.setBounds(159, 19, 80, 24);

	}

}
