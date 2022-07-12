import com.sun.istack.internal.localization.NullLocalizable;

public class UsersArrayList implements UserList{


	class UserNotFoundException extends RuntimeException{
		public UserNotFoundException(String message){
			super(message);
		}
	}

	private User		useArray[];
	private Integer		index;

	public void addUser(User newUser) {
		if (this.index < this.useArray.length - 1) {
			this.useArray[this.index] = newUser;
			this.index++;
		}
		else {
			User newar[] = new User[(int) (this.useArray.length * 1.5)];
			for (int i = 0; i < this.useArray.length; i++) {
				newar[i] = this.useArray[i];
			}
			newar[this.useArray.length] = newUser;
			this.useArray = newar;
			this.index++;
		}
	}

	public User getUserId(Integer id) {
		for (User user :this.useArray) {
			if (user.getIdentifier() == id)
			{
				return user;
			}
		}
		throw new UserNotFoundException("ID " + id + " is not found");
	}

	public User getUserIndex(Integer index) throws UserNotFoundException{

		if (index < 0 || index >=  this.index)
		throw new UserNotFoundException("ID " + index + " is not found");
		return this.useArray[index];
	}

	public Integer getNumberUser(){
		return this.index;
	}

	public UsersArrayList(){
		this.index = 0;
		this.useArray = new  User[10];
		for (User user :this.useArray) {
			user = null;
		}
	}
}
