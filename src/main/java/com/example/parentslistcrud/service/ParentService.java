package com.example.parentslistcrud.service;

import com.example.parentslistcrud.entity.Parent;

import java.util.List;

public interface ParentService {

    List<Parent> getAllParents();

    Parent saveParent(Parent parent);

    Parent getParentById(Long id);

    Parent updateParent(Parent parent);

    void deleteParentById(Long id);




}
