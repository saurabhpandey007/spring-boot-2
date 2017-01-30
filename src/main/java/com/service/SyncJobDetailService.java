package com.service;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import com.model.SyncJobDetail;
import com.model.SyncJobRunStatus;

public interface SyncJobDetailService {
	
	public List<SyncJobDetail> getAllSyncJob()throws Exception;
	public List<SyncJobRunStatus> getRunStatus(Long id)throws Exception;
	public boolean editUser(SyncJobDetail detail)throws Exception;
	public void startProcess();
}
