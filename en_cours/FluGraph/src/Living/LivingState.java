package Living;

public class LivingState {
	
	public LivingState(Class classe, String state) {
		super();
		this.classe = classe;
		this.state = state;
	}

	private Class classe;
	private String state;
	
	public Class getClasse() {
		return classe;
	}
	
	public String getState() {
		return state;
	}
	
	
}
