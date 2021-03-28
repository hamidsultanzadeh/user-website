package com.webperside.user_website.dao.impl;

import com.webperside.user_website.config.AbstractDao;
import com.webperside.user_website.dao.inter.SkillDao;
import com.webperside.user_website.model.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDao {

    private Skill getSkill(ResultSet resultSet) throws SQLException {
        Skill skill = new Skill();

        skill.setSkillId(resultSet.getInt("skill_id"));
        skill.setName(resultSet.getString("name"));

        return skill;
    }

    @Override
    public List<Skill> findAll() {
        List<Skill> skills = new ArrayList<>();
        try(Connection c = connect()){
            String sql = "select * from skill";
            Statement statement = c.createStatement();
            statement.execute(sql);
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
                skills.add(getSkill(rs));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return skills;
    }

    @Override
    public boolean checkSkillExistsById(Integer skillId) {
        try(Connection c = connect()){
            String sql = "select s.skill_id from skill s where s.skill_id =" + skillId;
            Statement stmt = c.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if(rs.next()){
                return true;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
