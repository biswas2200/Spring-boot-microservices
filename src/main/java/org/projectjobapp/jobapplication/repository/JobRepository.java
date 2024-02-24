package org.projectjobapp.jobapplication.repository;

import org.projectjobapp.jobapplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
