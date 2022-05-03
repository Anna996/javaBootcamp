package customeTShirts;

public class Design {
	protected double width;
	protected double height;
	protected String slogan;
	protected Color color;
	protected double complexity;

	private static final double MIN_WIDTH = 20;
	private static final double MAX_WIDTH = 30;
	private static final double MIN_HEIGHT = 10;
	private static final double MAX_HEIGHT = 25;
	private static final double MIN_COMLEXITY = 1;
	private static final double MAX_COMPLEXITY = 100;
	private final String DEFAULT_SLOGAN = "T Shirt";

	public Design() {
		this(MIN_WIDTH, MIN_HEIGHT, null, null, MIN_COMLEXITY);
	}

	public Design(double width, double height, String slogan, Color color, double complexity) {
		setWidth(width);
		setHeight(height);
		setSlogan(slogan);
		setColor(color);
		setComplexity(complexity);
	}

	protected void setWidth(double width) {
		this.width = Utils.isInRange(width, MIN_WIDTH, MAX_WIDTH) ? width : MIN_WIDTH;
	}

	protected void setHeight(double height) {
		this.height = Utils.isInRange(height, MIN_HEIGHT, MAX_HEIGHT) ? height : MIN_HEIGHT;
	}

	protected void setSlogan(String slogan) {
		this.slogan = Utils.hasOnlyDigitsOrLetter(slogan) ? slogan : DEFAULT_SLOGAN;
	}

	protected void setColor(Color color) {
		this.color = color == null ? new Color() : color;
	}

	protected void setComplexity(double complexity) {
		this.complexity = Utils.isInRange(complexity, MIN_COMLEXITY, MAX_COMPLEXITY)  ? complexity : MIN_COMLEXITY;
	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}

	public double calculateArea() {
		return width * height;
	}
}
