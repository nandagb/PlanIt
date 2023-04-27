package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;

import java.util.List;

public interface ProjetoDAO {

    void save(Projeto projeto);

    Projeto findById(int id);

    Projeto findByName(String name);

    List<Projeto> findAll();

    void update(Projeto projeto);

    void delelete(int id);
}
