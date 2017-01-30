package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.SyncJobRunStatus;

@Repository
public interface SyncJobRunStatusRepository extends CrudRepository<SyncJobRunStatus, Long> {
	
	public List<SyncJobRunStatus> findTop5ByJobIdOrderByRunIdDesc(Long jobId);
	
}
