package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fly() {
		System.out.println("새(" + name + ")는 날아다닙니다.");		
	}
	
	public void sing() {
		System.out.println("새(" + name + ")는 소리내어 웁니다.");
	}
}