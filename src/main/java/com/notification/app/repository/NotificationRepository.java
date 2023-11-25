package com.notification.app.repository;

import com.notification.app.model.db.NotificationRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationRepository extends PagingAndSortingRepository<NotificationRecord, Long>, CrudRepository<NotificationRecord, Long>, JpaSpecificationExecutor<NotificationRecord>{
}
