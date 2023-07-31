//unused prototype class
package myqtjambiproject;

import io.qt.widgets.QPushButton;

public abstract class Buttonhandler {

	private QPushButton qpb;
	private String color;

	public Buttonhandler(QPushButton qpb, String color) {
		super();
		this.qpb = qpb;
		this.color=color;
		this.handle();
	}
	
	abstract void handle();
	
	
}
