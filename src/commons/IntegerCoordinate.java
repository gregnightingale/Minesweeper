package commons;



public class IntegerCoordinate {

	private int x, y, z;
	private int dim;

	public IntegerCoordinate(int x) {
		this.x = x;
		y = 0;
		z = 0;
		dim = 1;
	}

	public IntegerCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
		z = 0;
		dim = 2;
	}

	public IntegerCoordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		dim = 3;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		switch (dim) {
		case 1:
			builder.append(Integer.toString(x));
			break;
		case 2:
			builder.append(Integer.toString(x)).append(",");
			builder.append(Integer.toString(y));
			break;
		case 3:
			builder.append(Integer.toString(x)).append(",");
			builder.append(Integer.toString(y)).append(",");
			builder.append(Integer.toString(z));
			break;
		default:
		}
		builder.append(")");
		return builder.toString();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}
