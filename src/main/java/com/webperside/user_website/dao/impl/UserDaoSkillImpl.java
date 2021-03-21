package com.webperside.user_website.dao.impl;

import com.webperside.user_website.config.AbstractDao;
import com.webperside.user_website.dao.inter.UserSkillDao;
import com.webperside.user_website.model.Skill;
import com.webperside.user_website.model.UserSkill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSkillImpl extends AbstractDao implements UserSkillDao {

    public UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int userSkillId = rs.getInt("user_skill_id");
        int skillId = rs.getInt("skill_id");
        String name = rs.getString("name");
        int power = rs.getInt("power");
        return new UserSkill(userSkillId,null, new Skill(skillId, name),power);
    }

    @Override
    public List<UserSkill> getUserSkills(Integer userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user_skill us " +
                    "left join skill s on us.fk_skill_id = s.skill_id where us.fk_user_id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getUserSkill(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
