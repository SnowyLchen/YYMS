package com.ct.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class SuperAdmin implements Serializable {
    private Integer superId;
    @NotEmpty
    @Pattern(regexp = "^([a-zA-Z]*[0-9_-]*$)", message = "只能包含字母、数字、下划线，且不能以数字或下划线开头")
    @Size(max = 10)
    private String superName;
    @NotEmpty
    @Pattern(regexp = "/^([a-zA-Z]*[0-9_-]*$)"+"^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W_]).{8,32}$/",message = "只能是长度为8-32位包含数字、字母、特殊字符的密码,且不能以数字或下划线开头")
    @Size(min = 8,max = 32)
    private String superPassword;

    private String superPic;

    private Authority superRole;


    private static final long serialVersionUID = 1L;

    public Integer getSuperId() {
        return superId;
    }

    public void setSuperId(Integer superId) {
        this.superId = superId;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName == null ? null : superName.trim();
    }

    public String getSuperPassword() {
        return superPassword;
    }

    public void setSuperPassword(String superPassword) {
        this.superPassword = superPassword == null ? null : superPassword.trim();
    }

    public String getSuperPic() {
        return superPic;
    }

    public void setSuperPic(String superPic) {
        this.superPic = superPic == null ? null : superPic.trim();
    }

    public Authority getSuperRole() {
        return superRole;
    }

    public void setSuperRole(Authority superRole) {
        this.superRole = superRole;
    }

    @Override
    public String toString() {
        return "SuperAdmin{" +
                "superId=" + superId +
                ", superName='" + superName + '\'' +
                ", superPassword='" + superPassword + '\'' +
                ", superPic='" + superPic + '\'' +
                ", superRole=" + superRole.getaRole()+
                '}';
    }
}