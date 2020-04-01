package com.osman.springangular.service.implementation;

import com.osman.springangular.entity.IssueHistory;
import com.osman.springangular.repository.IssueHistoryRepository;
import com.osman.springangular.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryImplementation implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryImplementation(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        //Business Logic

        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }

        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;

    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
