package app;

import util.PgSqlConnectionUtil;
import view.LoginView;

public class Main {

	public static void main(String[] args) throws Exception {
		new LoginView().setVisible(true);
	}
}
