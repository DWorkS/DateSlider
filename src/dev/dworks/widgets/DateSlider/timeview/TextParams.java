package dev.dworks.widgets.DateSlider.timeview;

public class TextParams {
	public int size = 25;
	public int color = 0xFF666666;
	public int colorBold = 0xFF333333;
	
	public TextParams() {
	}
	
	public TextParams(int size) {
		this.size = size;
	}
	
	public TextParams(int size, int color) {
		this.size = size;
		this.color =  color;
	}
	
	public TextParams(int size, int color, int colorBold) {
		this.size = size;
		this.color =  color;
		this.colorBold = colorBold;
	}
}
