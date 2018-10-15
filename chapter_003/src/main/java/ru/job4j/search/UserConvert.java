package ru.job4j.search;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
//В классе UserConvert написать метод public
// HashMap<Integer, User> process(List<User> list) {},
// который принимает в себя список пользователей и
// конвертирует его в Map с ключом Integer id и
// соответствующим ему User.
    public HashMap<Integer, User> process(List<User> list) {

        if (list == null) {
            throw new NullPointerException();
        }
        HashMap<Integer, User> result = new HashMap<>();
        for (User l : list) {
            if (l != null) {
                result.put(l.getId(), l);
            }
        }
        return result;
    }
}
