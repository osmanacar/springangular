package com.osman.springangular.service;

import com.osman.springangular.dto.IssueDto;
import com.osman.springangular.entity.Issue;
import com.osman.springangular.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issueId);

    IssueDto update(Long id, IssueDto issueDto);
}
