package com.example.RemomaxBE.DTOout;

public class LoginAndLogoutDashboardDTOout {
    private String USERID;
    private String LoginRCC;
    private String LogoutRCC;
    private String CountLogin;
    private String CountLogout;

    public LoginAndLogoutDashboardDTOout() {
    }

    public LoginAndLogoutDashboardDTOout(String USERID, String loginRCC, String logoutRCC, String countLogin, String countLogout) {
        this.USERID = USERID;
        LoginRCC = loginRCC;
        LogoutRCC = logoutRCC;
        CountLogin = countLogin;
        CountLogout = countLogout;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getLoginRCC() {
        return LoginRCC;
    }

    public void setLoginRCC(String loginRCC) {
        LoginRCC = loginRCC;
    }

    public String getLogoutRCC() {
        return LogoutRCC;
    }

    public void setLogoutRCC(String logoutRCC) {
        LogoutRCC = logoutRCC;
    }

    public String getCountLogin() {
        return CountLogin;
    }

    public void setCountLogin(String countLogin) {
        CountLogin = countLogin;
    }

    public String getCountLogout() {
        return CountLogout;
    }

    public void setCountLogout(String countLogout) {
        CountLogout = countLogout;
    }
}
