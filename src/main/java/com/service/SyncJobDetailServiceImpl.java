package com.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.SyncJobDetail;
import com.model.SyncJobRunStatus;
import com.repository.SyncJobDetailRepository;
import com.repository.SyncJobRunStatusRepository;

@Service
@Transactional
public class SyncJobDetailServiceImpl implements SyncJobDetailService {

	@Autowired
	private SyncJobDetailRepository detailRepository;
	@Autowired
	private SyncJobRunStatusRepository runStatusRepository;
	
	@Override
	public List<SyncJobDetail> getAllSyncJob() throws Exception {
		
		List<SyncJobDetail> list = new ArrayList<>();
		for (SyncJobDetail syncJobDetail : detailRepository.findAll()) {
			list.add(syncJobDetail);
		}
		return list;
	}

	@Override
	public List<SyncJobRunStatus> getRunStatus(Long id) throws Exception {
		List<SyncJobRunStatus> list = runStatusRepository.findTop5ByJobIdOrderByRunIdDesc(id);
		return list;
	}

	@Override
	public boolean editUser(SyncJobDetail syncJobDetail) throws Exception {
		SyncJobDetail updated = null;
		updated = detailRepository.save(syncJobDetail);
		if(updated == null)
			return false;
		return true;
	}

	@Override
	public void startProcess(){
		
		Process pr = null;
		try
		{
			Runtime run = Runtime.getRuntime();
			//pr = run.exec("cmd.exe /c start java -jar D:\\test.jar");
			pr = run.exec("cmd.exe /c start ping -n 3 www.google.de");
			pr.waitFor();
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
			String line ="";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			line ="";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(pr != null)
			pr.destroy();
		}
		
	}

}
