package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SYNC_JOB_RUN_STATUS")
public class SyncJobRunStatus {

	@Id
	@NotNull
    @Column(name="RUN_ID")
    private Long runId;

	@Column(name = "JOB_ID")
    private Long jobId;   

	@Column(name = "STATUS")
    private char status;   

	@Column(name = "FROM_TIME",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromTime;
	
    @Column(name="TO_TIME",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toTime;

	@Column(name = "SYNC_DURATION",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
    private Date syncDuration;   

	@Column(name = "LOWER_TIME",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
    private Date lowerTime;   

	@Column(name = "UPPER_TIME",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
    private Date upperTime;

	public Long getRunId() {
		return runId;
	}

	public void setRunId(Long runId) {
		this.runId = runId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public Date getSyncDuration() {
		return syncDuration;
	}

	public void setSyncDuration(Date syncDuration) {
		this.syncDuration = syncDuration;
	}

	public Date getLowerTime() {
		return lowerTime;
	}

	public void setLowerTime(Date lowerTime) {
		this.lowerTime = lowerTime;
	}

	public Date getUpperTime() {
		return upperTime;
	}

	public void setUpperTime(Date upperTime) {
		this.upperTime = upperTime;
	}

	@Override
	public String toString() {
		return "SyncJobRunStatus [runId=" + runId + ", jobId=" + jobId + ", status=" + status + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + ", syncDuration=" + syncDuration + ", lowerTime=" + lowerTime + ", upperTime="
				+ upperTime + "]";
	}

	
}
