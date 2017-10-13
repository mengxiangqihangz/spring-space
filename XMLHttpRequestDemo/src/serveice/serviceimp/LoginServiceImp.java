package serveice.serviceimp;

import dao.ILoginDao;
import dao.daoimp.LoginDaoImp;
import model.UserInfo;
import serveice.ILoginService;

public class LoginServiceImp implements ILoginService{
	ILoginDao loginDao;
	public LoginServiceImp()  throws Exception {
		if(loginDao==null){
			loginDao = new LoginDaoImp();
		}
	}

	@Override
	public boolean validateLogin(UserInfo user) throws Exception {
		String sql="";
		return loginDao.validateLogin(sql);
	}

}
