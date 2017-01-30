package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.PropertySource;


@Entity
@Table(name = "SYNC_JOB_DETAIL")
@PropertySource("classpath:messages.properties")
public class SyncJobDetail {

	@Id
	@NotNull
    @Column(name="JOB_ID")
    private Long jobId;

	@NotEmpty
	@Column(name = "JOB_TYPE")
    private String jobType;   

	@NotEmpty
	@Column(name = "DESCRIPTION")
    private String description;   

	
	@NotNull
	@Column(name = "FREQUENCY")
	@Valid
    private Long frequency;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "SyncJobDetail [jobId=" + jobId + ", jobType=" + jobType + ", description=" + description
				+ ", frequency=" + frequency + "]";
	}
    
}
