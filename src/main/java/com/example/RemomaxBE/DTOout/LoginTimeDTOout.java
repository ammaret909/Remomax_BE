package com.example.RemomaxBE.DTOout;

public class LoginTimeDTOout {
    private String user;
    private String ip;
    private String LoginTime;
    private String LogoutTime;
    private String useTime;

    public LoginTimeDTOout() {
    }

    public LoginTimeDTOout(String user, String ip, String loginTime, String logoutTime, String useTime) {
        this.user = user;
        this.ip = ip;
        LoginTime = loginTime;
        LogoutTime = logoutTime;
        this.useTime = useTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    public String getLogoutTime() {
        return LogoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        LogoutTime = logoutTime;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
}
