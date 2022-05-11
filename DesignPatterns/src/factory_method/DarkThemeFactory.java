package factory_method;

public class DarkThemeFactory extends ThemeFactory {

	@Override
	public Theme createTheme() {
		return new DarkTheme();
	}

}
