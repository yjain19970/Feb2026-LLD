package com.example.feb2026.designpatterns.prototype;

public class Student implements Prototype<Student> {
    // These are student specific attributes.
    public int age;
    public int id;
    public String name;

    // BatchRelated attributes -- which will always remain same for
    // all students in the same batch
    public String univName;
    public int batch;
    public float avgBatchPsp;
    public String schedule; // MWF-Morning, MWF-Evening, TTS-Morning, TTS-Evening

    public Student(String univName, int batch, float avgBatchPsp, String schedule){
        this.univName = univName;
        this.batch = batch;
        this.avgBatchPsp = avgBatchPsp;
        this.schedule = schedule;
    }

    public Student(Student original){
        this.age = original.age;
        this.avgBatchPsp = original.avgBatchPsp;
        this.batch = original.batch;
        this.id = original.id;
        this.name = original.name;
        this.univName = original.univName;
    }

    @Override
    public Student clone(){
        return new Student(this);
    }


}
