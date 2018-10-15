package ru.job4j.search;

public class UserComparable implements Comparable<UserComparable> {

    private String name;
    private int age;

    public UserComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(UserComparable o) {
        final int result = this.name.compareTo(o.name);
        return result != 0 ? result : Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "UserComparable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserComparable that = (UserComparable) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
