package factory_method;

public abstract class Theme {
	protected String text;
	protected String themeStyle;
	protected String textStyle;
	
	public Theme(String text, String themeStyle, String textStyle) {
		this.text = text;
		this.themeStyle = themeStyle;
		this.textStyle = textStyle;
	}

	public abstract void createTheme();
	
	public String about() {
		return String.format("This is a %s Theme. Id has a %s text", themeStyle, textStyle);
	}
}
