package org.xiaoyang.basesort.selectionSort2;

public class Student implements Comparable<Student> {

    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score == o.score) {
            return this.name.compareTo(o.name);
        }
        if (this.score < o.score)
            return 1;
        else if (this.score > o.score)
            return -1;
        else // this.score == that.score
            return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
