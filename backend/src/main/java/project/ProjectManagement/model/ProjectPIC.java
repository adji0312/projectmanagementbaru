package project.ProjectManagement.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_pic")
public class ProjectPIC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 19)
    private Long id;

    @Column(length = 10, updatable = false)
    private String created_by;

    @Column(updatable = false)
    private Date created_date;

    @Column(length = 10)
    private String modify_by;

    private Date modify_date;

    @Column(length = 14)
    private String project_code; //ambil project code

    @Column(length = 25)
    private String pic_name;

    @Column(length = 10)
    private String pic_id; //ambil userID

    public ProjectPIC(){

    }

    public ProjectPIC(Long id, String created_by, Date created_date, String modify_by, Date modify_date, String project_code, String pic_name, String pic_id) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modify_by = modify_by;
        this.modify_date = modify_date;
        this.project_code = project_code;
        this.pic_name = pic_name;
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

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getPic_id() {
        return pic_id;
    }

    public void setPic_id(String pic_id) {
        this.pic_id = pic_id;
    }

    @Override
    public String toString() {
        return "PIC Name: " + getPic_name() + "\n" +
                "PIC ID: " + getPic_id();
    }
}
