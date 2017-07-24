package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Job;

import java.util.List;


public interface JobService {
    List<Job> findAll();

    Job findOne(String jobId);

    Boolean delete(String jobId);

    Job save(Job job);

    Job update(Job job);
}
