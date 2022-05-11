package factory_method;

public abstract class ThemeFactory {
	private Theme theme;

	protected abstract Theme createTheme();
	
	public void runLogic() {
		theme = createTheme();
		theme.createTheme();
	}
}
