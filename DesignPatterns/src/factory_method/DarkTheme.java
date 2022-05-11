package factory_method;

public class DarkTheme extends Theme {
	
	private static final String TEXT;
	private static final String THEME_STYLE;
	private static final String TEXT_STYLE;
	
	static {
		TEXT = "Bright Text - Dark Theme";
		THEME_STYLE = "Dark";
		TEXT_STYLE = "Bright";
	}

	public DarkTheme() {
		super(TEXT, THEME_STYLE, TEXT_STYLE);
	}

	@Override
	public void createTheme() {
		System.out.println("creating... Dark theme....");
	}
}
