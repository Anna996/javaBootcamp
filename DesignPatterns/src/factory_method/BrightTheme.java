package factory_method;

public class BrightTheme extends Theme {
	
	private static final String TEXT;
	private static final String THEME_STYLE;
	private static final String TEXT_STYLE;
	
	static {
		TEXT = "Dark Text - Bright Theme";
		THEME_STYLE = "Bright";
		TEXT_STYLE = "Dark";
	}

	public BrightTheme() {
		super(TEXT, THEME_STYLE, TEXT_STYLE);
	}

	@Override
	public void createTheme() {
		System.out.println("\n\n");
		System.out.println("creating... Bright theme....");
		System.out.println(".");
		System.out.println("..");
		System.out.println("...");
	}
}
