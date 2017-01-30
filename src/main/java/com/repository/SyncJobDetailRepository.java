package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.model.SyncJobDetail;

@Repository
public interface SyncJobDetailRepository extends CrudRepository<SyncJobDetail,Long> {

}
