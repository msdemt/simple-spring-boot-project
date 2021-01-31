package org.msdemt.simple.redis_kyro.test;

public class UserDao {
    public static void main(String[] args) {
        AbstractDao<String> userDao = new AbstractDao<>();
        Class<String> actualType = userDao.getActualType();
        System.out.println(actualType.getName());
    }
}