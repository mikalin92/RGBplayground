package myqtjambiproject;
import io.qt.core.QFile;
import io.qt.core.QIODeviceBase.OpenModeFlag;

import static java.lang.System.out;

import java.io.File;

import io.qt.widgets.*;
import io.qt.widgets.tools.QUiLoader;
public class Main {

	public static void main(String[] args) {
		
		
		QApplication.initialize(args);
		
		//Open file to read
		
		QFile qf=new QFile("mydesign.ui");
		out.println("Ui File exists: "+qf.exists());
		qf.open(OpenModeFlag.ReadOnly);
		
		
		QUiLoader quiloader=new QUiLoader();
		QMainWindow mainwin =(QMainWindow)quiloader.load(qf);
		qf.close();
		mainwin.show();
		new MainWinHandler(mainwin);
		
		
		QApplication.exec();
		
		
		
	}

}
