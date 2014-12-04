
public class ObservableArgument {

	private String name;
	private Object value;
	
	public ObservableArgument(String name, Object val) {
		this.name = name;
		this.value = val;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
}
