package com.example.feb2026.designpatterns.prototype;

public class IntelligentStudent extends Student {
    public int iqLevel;

    public IntelligentStudent(String univName, 
        int batch, float avgBatchPsp, String schedule, int iq){
            super(univName, batch, avgBatchPsp, schedule);
            this.iqLevel = iq;
    }

    public IntelligentStudent(IntelligentStudent original){
        super(original.univName, original.batch, original.avgBatchPsp, original.schedule);
        this.iqLevel = original.iqLevel;
    }

    @Override
    public IntelligentStudent clone(){
        return new IntelligentStudent(this);
    }

    
}
