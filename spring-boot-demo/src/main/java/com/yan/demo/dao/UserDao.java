package com.yan.demo.dao;

import com.yan.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.TimeUnit;

/**
 * Created by yan on  25/09/2018.
 */
@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;

    @Transactional
    public boolean save(User user) {
        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        boolean success = false;
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);//设置成不自动提交
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name ) VALUES (?);");
            preparedStatement.setString(1, user.getName());
            success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean savePoint(User user) {
        boolean success = false;
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);//设置成不自动提交
            Savepoint savepoint = connection.setSavepoint("T1");
            try {
                save(user);
            }catch (Exception e){
                connection.rollback(savepoint);
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name ) VALUES (?);");
            preparedStatement.setString(1, user.getName());
            success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
