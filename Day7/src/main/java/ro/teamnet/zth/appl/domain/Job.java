package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */


@Table(name="Jobs")
public class Job {
    @Id(name="JOB_ID")
    private Long id;
    @Column(name="JOB_TITLE")
    private String jobTitle;
    @Column(name="MIN_SALARY")
    private int minSalary;
    @Column(name="MAX_SALARY")
    private int maxSalary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (minSalary != job.minSalary) return false;
        if (maxSalary != job.maxSalary) return false;
        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        return jobTitle != null ? jobTitle.equals(job.jobTitle) : job.jobTitle == null;
    }


    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
