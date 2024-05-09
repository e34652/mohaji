package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {



}
