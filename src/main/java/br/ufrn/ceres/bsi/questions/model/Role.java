package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = Role.ALL, query = "SELECT r FROM Role r")})
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static String ALL = "Role.populateRoles";

    private String roledesc;
    private String rolename;

    public Role() {
    }

    public Role(Integer roleid, String rolename) {
        this.rolename = rolename;
    }

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> users;

    public String getRoledesc() {
        return this.roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
    }
}
