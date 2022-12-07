package project.ProjectManagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 19)
    private Long id;

    @Column(length = 10, updatable = false)
    private String created_by;

    @Column(updatable = false)
    private Date created_date;

    @Column(length = 10)
    private String modify_by;

    private Date modify_date;

    @Column(length = 10)
    private String application;

    @Column(length = 6)
    private String project_type;

    @Column(length = 20, unique = true)
    private String project_code;

    @Column(length = 15, unique = true)
    private String project_bpro;

    @Column(length = 100)
    private String project_desc;

    private Date project_kickoff;

    @Column(length = 3)
    private String project_status;

    public Project(){
        
    }

    public Project(Long id, String created_by, Date created_date, String modify_by, Date modify_date, String application, String project_type, String project_code, String project_bpro, String project_desc, Date project_kickoff, String project_status) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modify_by = modify_by;
        this.modify_date = modify_date;
        this.application = application;
        this.project_type = project_type;
        this.project_code = project_code;
        this.project_bpro = project_bpro;
        this.project_desc = project_desc;
        this.project_kickoff = project_kickoff;
        this.project_status = project_status;
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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getProject_bpro() {
        return project_bpro;
    }

    public void setProject_bpro(String project_bpro) {
        this.project_bpro = project_bpro;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public Date getProject_kickoff() {
        return project_kickoff;
    }

    public void setProject_kickoff(Date project_kickoff) {
        this.project_kickoff = project_kickoff;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    @Override
    public String toString() {
        return "Application " + getApplication() + "\n" +
                "Project Type " + getProject_type() + "\n" +
                "Project BPRO " + getProject_bpro() + "\n" +
                "Project Desc " + getProject_desc() + "\n" +
                "Project Status " + getProject_status() + "\n";
    }
}
