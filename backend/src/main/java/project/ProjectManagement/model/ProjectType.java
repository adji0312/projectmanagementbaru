package project.ProjectManagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_types")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, updatable = false)
    private String created_by;

    @Column(updatable = false)
    private Date created_date;

    @Column(length = 10)
    private String modify_by;

    private Date modify_date;

    @Column(length = 6)
    private String project_type;

    @Column(length = 60)
    private String project_desc;

    public ProjectType(){

    }

    public ProjectType(Long id, String created_by, Date created_date, String modify_by, Date modify_date, String project_type, String project_desc) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modify_by = modify_by;
        this.modify_date = modify_date;
        this.project_type = project_type;
        this.project_desc = project_desc;
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

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }
}
