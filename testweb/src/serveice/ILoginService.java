package serveice;

import model.UserInfo;

public interface ILoginService {
	public boolean validateLogin(UserInfo user) throws Exception;
}
