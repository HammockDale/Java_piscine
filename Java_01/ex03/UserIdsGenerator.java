public class UserIdsGenerator {
	private static UserIdsGenerator instance;

	private static Integer id = 42;

	private UserIdsGenerator(){}

	public static UserIdsGenerator getInstance(){
		if (instance == null){
			instance = new UserIdsGenerator();
		}
		return instance;
	}

	public Integer generateId() {
		return id++;
	}
}
