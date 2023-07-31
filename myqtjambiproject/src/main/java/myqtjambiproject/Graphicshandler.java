package myqtjambiproject;

import io.qt.gui.QColor;
import io.qt.gui.QColorTransform;
import io.qt.gui.QImage;
import io.qt.gui.QPixmap;
import io.qt.widgets.QGraphicsPixmapItem;
import io.qt.widgets.QGraphicsScene;
import io.qt.widgets.QGraphicsView;
import io.qt.widgets.QPushButton;

public class Graphicshandler {



	private QGraphicsView qgv;
	private QGraphicsPixmapItem qgpi;
	private QImage qi;
	
	public Graphicshandler(QGraphicsView qgv) {
		this.qgv=qgv;
		this.handle();
		
		
	}
	
	private void handle() {
		
		QGraphicsScene qgs=new QGraphicsScene();
		//TODO Link button to choose pixmap
		qi=new QImage("opengl_linux.png");
		
		QPixmap qpm=QPixmap.fromImage(qi);
		qgpi=new QGraphicsPixmapItem(qpm);
		qgs.addItem(qgpi);
		qgv.setScene(qgs);
		
	}
	
	public void setImage(QImage qi) {
		qgpi.setPixmap(QPixmap.fromImage(qi));
	}
	
	public void resetImage() {
		qgpi.setPixmap(QPixmap.fromImage(new QImage("opengl_linux.png")));
	}
	
	
	public void alterImageColor(String color,int value) {
		this.resetImage();
		//start of double loop
		for(int i=0;i<qi.width();i++) {
			for(int j=0;j<qi.height();j++) {
				QColor oldcolor=qi.pixelColor(i, j);
				if(color.toLowerCase().equals("red")) {oldcolor.setRed(oldcolor.red()+value);}
				else if(color.toLowerCase().equals("green")) {oldcolor.setGreen(oldcolor.green()+value);}
				else if(color.toLowerCase().equals("blue")) {oldcolor.setBlue(oldcolor.blue()+value);}
				else {
					System.out.println("Color not R/G/B");
				}
				qi.setPixelColor(i, j, oldcolor);
			}
			
		}
		//end of double loop
		this.setImage(qi);
		
	}
	
}
