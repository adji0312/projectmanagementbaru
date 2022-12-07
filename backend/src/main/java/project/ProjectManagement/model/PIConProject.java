package project.ProjectManagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pic_on_project")
public class PIConProject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, length = 19)
    private Long id;

    @Column(length = 10, updatable = false)
    private String created_by;

    @Column(updatable = false)
    private Date created_date;

    @Column(length = 10)
    private String modify_by;

    private Date modify_date;

    private Boolean pic_flag;

    @Column(length = 10)
    private String pic_id;

    public PIConProject(){

    }

    public PIConProject(Long id, String created_by, Date created_date, String modify_by, Date modify_date, Boolean pic_flag, String pic_id) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modify_by = modify_by;
        this.modify_date = modify_date;
        this.pic_flag = pic_flag;
        this.pic_id = pic_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getModify_by() {
        return modify_by;
    }

    public void setModify_by(String modify_by) {
        this.modify_by = modify_by;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public Boolean getPic_flag() {
        return pic_flag;
    }

    public void setPic_flag(Boolean pic_flag) {
        this.pic_flag = pic_flag;
    }

    public String getPic_id() {
        return pic_id;
    }

    public void setPic_id(String pic_id) {
        this.pic_id = pic_id;
    }

}

