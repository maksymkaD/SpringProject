package com.example.application.service;

import com.example.application.dal.model.Group;
import com.example.application.dal.model.Subject;
import com.example.application.dal.repository.GroupRepository;
import com.example.application.dal.repository.SubjectRepository;
import com.example.application.dto.group.GroupCreateDTO;
import com.example.application.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public void createGroup(GroupCreateDTO groupDTO)
    {
        Subject selected_subject = subjectRepository.getById(groupDTO.getGroupSubjectId());
        System.out.println("DTO: " + groupDTO.getGroupSubjectId() + ", " + groupDTO.getNumber() + ", " + selected_subject.getName());
        Group group = new Group(
                selected_subject,
                groupDTO.getNumber()
        );
        groupRepository.save(group);

      //System.out.println(this.user.getEmail());
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }

    public void addStudetToGroup(Group group, MyUserDetails user)
    {
        group.getGroupUsers().add(user.getUser());
        groupRepository.save(group);
        System.out.println();
    }
    public void deleteStudentFromGroup (Group group, MyUserDetails user)
    {
        group.getGroupUsers().remove(user.getUser());
    }

    public  Group getGroupById(int Id)
    {
        return groupRepository.getById(Id);
    }
}
