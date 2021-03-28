package com.webperside.user_website.dao.impl;

import com.webperside.user_website.config.AbstractDao;
import com.webperside.user_website.dao.inter.UserSkillDao;
import com.webperside.user_website.model.Skill;
import com.webperside.user_website.model.UserSkill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDao {

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

    @Override
    public void saveUserSkill(Integer userId, Integer skillId, Integer power) {
        try {
            Connection c = connect();

            String sql = "insert into user_skill(fk_user_id, fk_skill_id, power) " +
                    "values(?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, skillId);
            ps.setInt(3, power);

            ps.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
