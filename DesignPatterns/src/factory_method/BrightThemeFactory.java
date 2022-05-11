package factory_method;

public class BrightThemeFactory extends ThemeFactory {

	@Override
	public Theme createTheme() {
		return new BrightTheme();
	}
}
