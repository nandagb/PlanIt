package dao;

import entity.Projeto;

import java.util.ArrayList;

public interface ProjetoDAO {
    public boolean save(Projeto projeto);
    public boolean existe(Projeto projeto);
    public ArrayList<Projeto> getAllProjetos();
    public Projeto getProjetoById(int id);
    public boolean updateProjeto(Projeto projeto);
    public boolean deleteProjeto(Projeto projeto);
}
