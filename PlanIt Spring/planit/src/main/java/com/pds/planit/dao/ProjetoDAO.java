package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;

public interface ProjetoDAO {

    void save(Projeto projeto);

    Projeto findById(int id);

    Projeto findByName(String name);
}
