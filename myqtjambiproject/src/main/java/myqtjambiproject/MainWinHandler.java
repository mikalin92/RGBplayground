package myqtjambiproject;

import io.qt.widgets.QDial;
import io.qt.widgets.QGraphicsView;
import io.qt.widgets.QMainWindow;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QWidget;

public class MainWinHandler {

	private QMainWindow mainwin;
	private QWidget central;
	private Graphicshandler gh;
	QDial red, green, blue;

	public MainWinHandler(QMainWindow mainwin) {
		super();
		this.mainwin = mainwin;
		this.central = mainwin.centralWidget();
		this.handle();
	}

	private void handle() {
		mainwin.setWindowTitle("RGB playground");
		QPushButton qp = (QPushButton) central.findChild("pushButton");
		qp.setText("Reset!");
		QGraphicsView qgv = (QGraphicsView) central.findChild("graphicsView");
		gh = new Graphicshandler(qgv);

		red = (QDial) central.findChild("dial_red");
		green = (QDial) central.findChild("dial_green");
		blue = (QDial) central.findChild("dial_blue");

		red.valueChanged.connect(this, "redchanged()");
		green.valueChanged.connect(this, "greenchanged()");
		blue.valueChanged.connect(this, "bluechanged()");
		qp.pressed.connect(this, "buttonpressed()");

	}

	private void redchanged() {
		green.setValue(0);
		blue.setValue(0);
		gh.alterImageColor("red", red.value()-50);
	}

	private void greenchanged() {
		red.setValue(0);
		blue.setValue(0);
		gh.alterImageColor("green", green.value()-50);
	}

	private void bluechanged() {
		red.setValue(0);
		green.setValue(0);
		gh.alterImageColor("blue", blue.value()-50);
	}
	
	private void buttonpressed() {
		red.setValue(0);
		green.setValue(0);
		blue.setValue(0);
		gh.resetImage();
	}

}
