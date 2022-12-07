package project.ProjectManagement.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BacklogDevelopment implements Serializable {

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

    @Column(length = 10)
    private String application;

    @Column(length = 6)
    private String backlog_type;

    @Column(length = 20, unique = true)
    private String backlog_code;

    @Column(length = 15)
    private String backlog_bpro;

    @Column(length = 100)
    private String backlog_desc;

    private Date backlog_kickoff;

    @Column(length = 3)
    private String backlog_status;

    private Date backlog_start;

    private Date backlog_end;

    public BacklogDevelopment(){
    }

    public BacklogDevelopment(Long id, String created_by, Date created_date, String modify_by, Date modify_date, String application, String backlog_type, String backlog_code, String backlog_bpro, String backlog_desc, Date backlog_kickoff, String backlog_status, Date backlog_start, Date backlog_end) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modify_by = modify_by;
        this.modify_date = modify_date;
        this.application = application;
        this.backlog_type = backlog_type;
        this.backlog_code = backlog_code;
        this.backlog_bpro = backlog_bpro;
        this.backlog_desc = backlog_desc;
        this.backlog_kickoff = backlog_kickoff;
        this.backlog_status = backlog_status;
        this.backlog_start = backlog_start;
        this.backlog_end = backlog_end;
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

    public String getBacklog_type() {
        return backlog_type;
    }

    public void setBacklog_type(String backlog_type) {
        this.backlog_type = backlog_type;
    }

    public String getBacklog_code() {
        return backlog_code;
    }

    public void setBacklog_code(String backlog_code) {
        this.backlog_code = backlog_code;
    }

    public String getBacklog_bpro() {
        return backlog_bpro;
    }

    public void setBacklog_bpro(String backlog_bpro) {
        this.backlog_bpro = backlog_bpro;
    }

    public String getBacklog_desc() {
        return backlog_desc;
    }

    public void setBacklog_desc(String backlog_desc) {
        this.backlog_desc = backlog_desc;
    }

    public Date getBacklog_kickoff() {
        return backlog_kickoff;
    }

    public void setBacklog_kickoff(Date backlog_kickoff) {
        this.backlog_kickoff = backlog_kickoff;
    }

    public String getBacklog_status() {
        return backlog_status;
    }

    public void setBacklog_status(String backlog_status) {
        this.backlog_status = backlog_status;
    }

    public Date getBacklog_start() {
        return backlog_start;
    }

    public void setBacklog_start(Date backlog_start) {
        this.backlog_start = backlog_start;
    }

    public Date getBacklog_end() {
        return backlog_end;
    }

    public void setBacklog_end(Date backlog_end) {
        this.backlog_end = backlog_end;
    }

    @Override
    public String toString() {
        return "Application " + getApplication() + "\n" +
                "Backlog Type " + getBacklog_type() + "\n" +
                "Backlog BPRO " + getBacklog_bpro() + "\n" +
                "Backlog Desc " + getBacklog_desc() + "\n" +
                "Backlog Status " + getBacklog_status() + "\n";
    }
}
