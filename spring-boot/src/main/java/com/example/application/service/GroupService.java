package com.example.application.service;

import org.springframework.stereotype.Service;
import com.example.application.dal.model.Group;
import com.example.application.dal.repository.GroupRepository;
import com.example.application.dto.group.GroupCreateDTO;
import com.example.application.dto.group.GroupUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public void createGroup(GroupCreateDTO groupDTO)
    {
        Group group = new Group(
                groupDTO.getSubjectName(),
                groupDTO.getNumber()
        );
        groupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }
}
