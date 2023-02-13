package com.spring_boot_mybatis.project.model;

public class MemberVO {
    private String memId;
    private String memPw;
    private String memName;
    private String memEmail;
    
    public String getMemId() {
        return this.memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return this.memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return this.memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemEmail() {
        return this.memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }
    
}
