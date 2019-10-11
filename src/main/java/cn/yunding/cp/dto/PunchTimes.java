package cn.yunding.cp.dto;

import java.sql.Time;
import java.util.Date;

public class PunchTimes {
    private int punchId;
    private Time times;

    public int getPunchId() {
        return punchId;
    }

    public void setPunchId(int punchId) {
        this.punchId = punchId;
    }

    public void setTimes(Time times) {
        this.times = times;
    }

    public Date getTimes() {
        return times;
    }


    @Override
    public String toString() {
        return "PunchTimes{" +
                "punchId=" + punchId +
                ", times=" + times +
                '}';
    }
}
