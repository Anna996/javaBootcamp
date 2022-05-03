package customeTShirts;

public class Tshirt {
	protected Size size;
	protected Design design;
	protected double demandFactor = DEFAULT_FACTOR;
	protected double besePrice = DEFAULT_PRICE;
	private static final double MIN_FACTOR = 0.1;
	private static final double MAX_FACTOR = 1;
	private static final double MIN_PRICE = 3;
	private static final double DEFAULT_FACTOR = MIN_FACTOR;
	private static final double DEFAULT_PRICE = MIN_PRICE;
	private static final double EXPENSIVE_PRICE = 10000;

	public Tshirt() {
		this(null, null, DEFAULT_FACTOR, DEFAULT_PRICE);
	}

	public Tshirt(Size size, Design design, double demandFactor, double bestPrice) {
		setSize(size);
		setDesign(design);
		setDemandFactor(demandFactor);
		setBesePrice(bestPrice);
	}

	protected void setSize(Size size) {
		this.size = size == null ? Size.S : size;
	}

	protected void setDesign(Design design) {
		this.design = design == null ? new Design() : design;
	}

	protected void setDemandFactor(double demandFactor) {
		this.demandFactor = Utils.isInRange(demandFactor, MIN_FACTOR, MAX_FACTOR) ? demandFactor : DEFAULT_FACTOR;
	}

	protected void setBesePrice(double besePrice) {
		this.besePrice = besePrice >= MIN_PRICE ? besePrice : DEFAULT_PRICE;
	}

	@Override
	public String toString() {
		return "Tshirt [size=" + size + ", design=" + design + ", demandFactor=" + demandFactor + ", besePrice="
				+ besePrice + "]";
	}

	public double calculateFinalPrice() {
		return (besePrice + design.complexity) * design.calculateArea() / demandFactor;
	}

	public boolean isExpensive() {
		return calculateFinalPrice() >= EXPENSIVE_PRICE;
	}

	public enum Size {
		XS, S, M, L, XL
	}
}
